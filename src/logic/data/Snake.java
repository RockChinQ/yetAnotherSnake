package logic.data;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Snake {
    Point towards=new Point(0,0);
    Point headPosition=new Point(0,0);
    ArrayList<Line2D> body=new ArrayList<>();

    /**
     * 前进一格
     * @param width 范围宽度
     * @param height 范围高度
     * @param cookie 食物坐标
     * @return 是否成功移动
     */
    public boolean nextTick(int width,int height,Point cookie){
        headPosition.move((int)towards.getX(),(int)towards.getY());
        //检查是否撞到墙
        if (headPosition.getX()<0||headPosition.getY()<0||headPosition.getX()>=width||headPosition.getY()>=height){
            return false;
        }

        //检查是否撞到自己
        for(Line2D line:this.body){
            if (line.contains(headPosition)){
                return false;
            }
        }

        //存到body中
        Line2D latest=this.body.get(this.body.size()-1);
        latest.setLine(latest.getP1(),this.headPosition);

        //删除尾巴一格
        if (headPosition.distance(cookie)>=0){
            Line2D tail=this.body.get(0);
            if (tail.getX1()==tail.getX2()&&tail.getY1()==tail.getY2()){
                //如果只有一个点，则删除此line2D对象
                this.body.remove(tail);
                tail=this.body.get(0);
            }
            // 将第一个line2D对象减去一格
            int deltaX= (int) (tail.getX2()-tail.getX1()),deltaY= (int) (tail.getY2()-tail.getY1());
            int newX1= deltaX==0? (int) tail.getX1() :(int)tail.getX1()+deltaX/Math.abs(deltaX);
            int newY1= deltaY==0? (int) tail.getY1() :(int)tail.getY1()+deltaY/Math.abs(deltaY);
            tail.setLine(new Point(newX1,newY1),tail.getP2());
        }

        return true;
    }

    /**
     * 转向
     * @param direction 方向
     */
    public void turnTo(EnumSnackDirection direction){
        //检查头部line2D对象是否只有一个点
        Line2D head=this.body.get(this.body.size()-1);
        if (!(head.getX1()==head.getX2()&&head.getY1()==head.getY2())){
            //不只有一个点，则压入一个新的line2D对象作为新的一段身体
            this.body.add(new Line2D.Double(head.getP2(),head.getP2()));
        }

        //设置方向向量
        switch (direction){
            case NORTH:
                this.towards.setLocation(0,-1);
                break;
            case SOUTH:
                this.towards.setLocation(0,1);
                break;
            case WEST:
                this.towards.setLocation(-1,0);
                break;
            case EAST:
                this.towards.setLocation(1,0);
                break;
        }
    }
}
