package GameObjects;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

/**
 *Class to store the property of the snake while the game is running
 */
public class Snake extends Group {
    ArrayList<Body> snake;
    Body head;
    ArrayList <Float>  center =new ArrayList<>();
    private int snake_length;
Boolean flag=true;

    /**
     * Constructor
     * @param length
     * @param color
     */
    public Snake(int length, Paint color){
        center=new ArrayList<>();
        snake=new ArrayList<Body>();
        head=new Body(300,350,15);
    head.setFill(color);
        center.add((float)300);
        snake_length=length;
        snake.add(head);
        this.getChildren().add(head);
        for(int i=0;i<length-1;++i){
            Body body=snake.get(i);

            snake.add(new Body(body.getCenterX(),body.getCenterY()+2*body.getRadius() ,body.getRadius()));
            snake.get(i+1).setFill(color);
            this.getChildren().add(snake.get(i+1));
            center.add((float) body.getCenterX());
        }
    }

    /**
     * Constructor
     * @param length
     * @param center
     * @param color
     */
    public Snake(int length,ArrayList<Float> center, Paint color){
        snake=new ArrayList<Body>();
        head=new Body(center.get(0),350,15);
    head.setFill(color);
        snake_length=length;
        snake.add(head);
        this.getChildren().add(head);
        for(int i=0;i<length-1;++i){
            Body body=snake.get(i);

            snake.add(new Body(center.get(i),body.getCenterY()+2*body.getRadius() ,body.getRadius()));
            if(i==center.size()-1){center.add(center.get(i));}
            snake.get(i+1).setFill(color);
            this.getChildren().add(snake.get(i+1));

        }this.center=center;
    }
    public ArrayList<Body> getSnake() {
        return snake;
    }

    /**
     * @return
     */
    public Body getHead() {
        return head;
    }

    /**
     * @return
     */
    public int getSnake_length() {
        return snake_length;
    }

    /**
     * @return
     */
    public ArrayList<Float> getCenter(){return this.center;}
    public void setFlag(Boolean t){this.flag=t;}
    public Boolean getFlag(){return this.flag;}
}
