package GameObjects;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

/**
 *Block are the brick to be broken by the snake
 */
public class Block extends Group implements Movable{
    int value;
    int x;
    int y;
    final public Rectangle r=new Rectangle();
    final Paint color= Color.color(new Random().nextDouble(),new Random().nextDouble(),new Random().nextDouble());

    /**
     * @param x
     * @param y
     * @param value
     */
    public Block(int x,int y,int value){
        super();


        this.x=x;
        this.y=y;
        this.value=value;
//        double rand= (Math.random()*100);
//        if(rand<20){
//            super.setFill(Color.rgb(0,0,0));
//            super.setHeight(20);
//            super.setWidth(20);
//            super.setArcHeight(1000);
//            super.setArcWidth(1000);
//        }
//    else  if(rand>=21&&rand<=30){
//            super.setFill(Color.rgb(256,0,0));
//            super.setHeight(20);
//            super.setWidth(20);
//            super.setArcHeight(1000);
//            super.setArcWidth(1000);
//        }
//        else {

        r.setX(x);
        r.setY(y);
        r.setHeight(70);
        r.setWidth(70);
        r.setFill(color);

        r.setArcWidth(10);
        r.setArcHeight(10);
        final Text text = new Text (this.value+"");
        text.setX(x+10);
        text.setY(y+25);
        text.setFont(Font.font ("Verdana", 20));
        this.getChildren().addAll(r,text);

        for(int i=0;i<10;i++) {
            Rectangle rect=new Rectangle();
            rect.setFill(color);
            rect.setHeight(10);
            rect.setWidth(10);
            rect.setX(x+25);
            rect.setY(y+25);

            this.getChildren().add(rect);

        }
//        }



    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int gety() {
        return this.y;
    }
    public Group getGroup(){return this;}
    @Override
    public void move( int y) {
        this.y=y;

    }

    /**
     * @param c
     * @return
     * function to check whether the block has colided with the snake
     */
    public boolean intersects(Body c){
        // System.out.println(r.getX() +" "+this.y+" "+c.getCenterX()+" "+c.getCenterY() );
        if(this.r.getX()<=c.getCenterX() && c.getCenterX()<=this.r.getX()+70 && this.y+40==c.getCenterY() ){

            return  true;
        }
        return  false;
    }

    public DoubleProperty translateyProperty(){
        return super.translateYProperty();
    }
    public String toString(){return "Block";}

}
