
package GameObjects;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *Token to attract all the other token in the game
 */
public class Magnet extends Rectangle implements Movable {
    int x;
    int y;

    /**
     * @param x
     * @param y
     */
    public Magnet(int x,int y){
        super();
        super.setHeight(40);
        super.setWidth(40);
        super.setArcHeight(100);
        super.setArcWidth(100);
        Stop[] stops = new Stop[] { new Stop(0, Color.RED),new Stop(0.5,Color.WHITE), new Stop(1, Color.BLUE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        super.setFill(lg1);
        super.setX(x);
        super.setY(y);
    }



    @Override
    public int gety() {
        return this.y;
    }

    @Override
    public DoubleProperty translateyProperty() {
        return super.translateYProperty();
    }

    /**
     * @param y
     */
    @Override
    public void move( int y) {
        //setY(y);
        this.y=y;
    }

    /**
     * @return
     */
    public Group getGroup(){return new Group();}

    /**
     * @param c
     * @return
     * to check intersection with the snake
     */
    public boolean intersects(Body c){
        if(c.getCenterY()==this.y+40 && this.getX()<c.getCenterX() && c.getCenterX()<this.getX()+30 ){return true;}
        return  false;
    }

}
