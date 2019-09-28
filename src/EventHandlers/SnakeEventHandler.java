package EventHandlers;


import GameObjects.Body;
import GameObjects.Snake;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 *Event Handler to control the position of the snake in
 * the game using cursor
 */
public class SnakeEventHandler implements EventHandler<MouseEvent> {
   Timeline timeline;
    Snake snake;
    int x1;int x2;

    /**
     *
     * @param snake
     * @param x1
     * @param x2
     */
    public SnakeEventHandler(Snake snake,int x1,int x2){
        this.x1=x1;
        this.x2=x2;
        this.snake=snake;
    }

    /**
     * handle function handle the position of the snake using keyframes and timeline
     * @param mouseEvent
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        try{if(this.snake.getFlag()){
        timeline=new Timeline();
        KeyFrame[] frames=new KeyFrame[snake.getSnake_length()];
        ArrayList<Body> body=snake.getSnake();
        // System.out.println(mouseEvent.getX());
        if(x1<mouseEvent.getX() && mouseEvent.getX()<x2){
            frames[0]=new KeyFrame(Duration.millis(10), new KeyValue(body.get(0).centerXProperty(),mouseEvent.getX()));
            snake.getCenter().set(0,(float)mouseEvent.getX());
            for(int j=1;j<snake.getSnake_length();++j){
                frames[j]=new KeyFrame(Duration.millis(10), new KeyValue(body.get(j).centerXProperty(), body.get(j-1).getCenterX()));
                timeline.getKeyFrames().add(frames[j]);

                snake.getCenter().set(j,(float)body.get(j-1).getCenterX());
            }
            timeline.getKeyFrames().add(frames[0]);
            // System.out.println(body.get(0).getCenterX());
            timeline.play();}}
            else {timeline.stop();}}
            catch (Exception e){}



    }

    /**
     * stops the time when game ends or game pauses
     */
    public void stop(){timeline.stop();}


}
