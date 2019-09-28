package GameObjects;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.Random;

/**
 *
 */
public class wall extends Group implements Movable {
    int y;
    int length=new Random().nextInt(30)+40;

    /**
     * @param x1
     * @param y1
     */
public wall(int x1, int y1){
    Line line1=new Line();
    line1.setStartX(x1);
    line1.setStartY(y1);
    line1.setEndX(x1);
    line1.setEndY(y1+length);
line1.setStroke(Color.WHITE);
line1.setStrokeWidth(2);

    Line line2=new Line();
    line2.setStartX(x1+100);
    line2.setStartY(y1);
    line2.setEndX(x1+100);
    line2.setEndY(y1+length);
    line2.setStrokeWidth(2);
    line2.setStroke(Color.WHITE);
    this.getChildren().addAll(line1,line2);

};
    public void move(int y){this.y=y;}
    public int gety(){return y; }
    public DoubleProperty translateyProperty(){return  super.translateYProperty();};
public Group getGroup(){return  this;}

    /**
     * @param c
     * @return
     */
    public boolean intersects(Body c){
     Line line =(Line)this.getChildren().get(0);
     Line line2=(Line)this.getChildren().get(1);

     if(line.getStartX()<c.getCenterX() && c.getCenterX()<line2.getStartX() && this.y>=165 && this.y<=455 ){return true;}
     return false;
    }

}

