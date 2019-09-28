package GameObjects;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

/**
 *Token in the game which increases the length of the snake
 */
public class Coin extends Group implements Movable {
    int x;
    int y;

    /**
     * @param x
     * @param y
     */
    public Coin(int x,int y){

        super();
        this.x=x;
        this.y=y;
        Rectangle r=new Rectangle();
        r.setHeight(40);
        r.setWidth(40);
        r.setArcHeight(100);
        r.setArcWidth(100);
        r.setFill(Color.YELLOW);
        r.setX(x);
        r.setY(y);
        this.getChildren().add(r);



    }



    @Override
    public int gety() {
        return this.y;
    }

    @Override
    public DoubleProperty translateyProperty() {
        return super.translateYProperty();
    }

    @Override
    public void move( int y) {
        //setY(y);
        this.y=y;
    }

    public Group getGroup(){return this;}

    /**
     * @param c
     * @return
     * function to check the intersection with snake
     */
    public boolean intersects(Body c){
        if(c.getCenterY()==this.y+40 && this.x<c.getCenterX() && c.getCenterX()<this.x+30 ){return true;}
        return  false;
    }
    public String toString(){return "Coin";}
}
