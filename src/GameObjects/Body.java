package GameObjects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 *This class extend circle class and used to make the body of the snake which are circles
 */
public class Body extends Circle {
    /**
     * @param x
     * @param y
     * @param radius
     */
    public Body(double x,double y,double radius){
        super();
        super.setCenterX(x);
        super.setCenterY(y);
        super.setRadius(radius);
        super.setFill(Color.YELLOW);
    }

    /**
     *
     * function to set the coordinates of the body
     * @param x
     * @param y
     */
    public void set_Coordinate(double x,double y){
        super.setCenterX(x);
        super.setCenterY(y);
    }
}
