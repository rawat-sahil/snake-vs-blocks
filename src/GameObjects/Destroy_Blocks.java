package GameObjects;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *Token in the Game to destroy all the blocks in a certain range
 */
public class Destroy_Blocks extends Rectangle implements Movable {
    int x;
    int y;

    /**
     * @param x
     * @param y
     */
    public Destroy_Blocks(int x, int y){
        super();
        super.setHeight(30);
        super.setWidth(30);
        super.setArcHeight(100);
        super.setArcWidth(100);
        super.setFill(Color.rgb(255,100,100));
        super.setX(x);
        super.setY(y);


        }
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

    public Group getGroup(){return new Group();}

    /**
     * @param c
     * @return
     * function to check the collision with the snake in the game
     */
    public boolean intersects(Body c){
        if(c.getCenterY()==this.y+40 && this.getX()<c.getCenterX() && c.getCenterX()<this.getX()+30 ){return true;}
        return  false;
    }

}


