package GameObjects;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *Interface for the tokens
 */
public interface Movable {
    public void move(int y);
    public int gety();
    public DoubleProperty translateyProperty();
    public Group getGroup();

    boolean intersects(Body head);
}
