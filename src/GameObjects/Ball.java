package GameObjects;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

/**
 *Ball is the token in the game
 */
public class Ball extends Group implements Movable {
    int x;
    int y;
    int value;
    final public Rectangle r=new Rectangle();
    final Paint color= Color.color(new Random().nextDouble(),new Random().nextDouble(),new Random().nextDouble());

    /**
     * @param x
     * @param y
     * @param value
     */
    public Ball(int x, int y, int value) {
        super();



        this.x=x;
        this.y=y;
        this.value=value;
        r.setX(x);
        r.setY(y);
        r.setHeight(40);
        r.setWidth(40);
        r.setFill(color);

        r.setArcWidth(100);
        r.setArcHeight(100);
        final Text text = new Text (this.value+"");
        text.setX(x+20);
        text.setY(y+20);
        text.setFont(Font.font ("Verdana", 20));
        this.getChildren().addAll(r,text);
    }
    public DoubleProperty translateyProperty(){return  super.translateYProperty();};
    public void move(int y){this.y=y;}
    public int gety(){return y; }
    public Group getGroup(){return this;}

    /**
     * @param c
     * @return
     * checks if the ball has collide with the snake or not
     */
    public boolean intersects(Body c){
        if(c.getCenterY()==this.y+40 && this.x<c.getCenterX() && c.getCenterX()<this.x+30 ){
            return true;}
        return  false;
    }


}