package GameObjects;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

/**
 *token in game to break the blocks
 */
public class Shield extends Group implements Movable {
    int x;
    int y;

    /**
     * @param x
     * @param y
     */
    public Shield(int x, int y){

        super();
        this.x=x;
        this.y=y;
        Arc arc=new Arc();
        arc.setCenterX(x);
        arc.setCenterY(y);
        arc.setRadiusX(30);
        arc.setRadiusY(30);
        arc.setStartAngle(45);
        arc.setLength(90);
        arc.setType(ArcType.ROUND);
        arc.setFill(Color.GREY);
        this.getChildren().add(arc);

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
     * to check the intersection with the snake
     *
     */
    public boolean intersects(Body c){
        if(c.getCenterY()==this.y+40 && this.x-10<c.getCenterX() && c.getCenterX()<this.x+10   ){return true;}
        return  false;
    }
    public String toString(){return "Shield";}
}
