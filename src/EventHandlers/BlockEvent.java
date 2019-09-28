package EventHandlers;

import GameObjects.Movable;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;


/**
 * Class For the animation of the token break in the game
 */
public class BlockEvent {

    /**
     * @param a
     * @return
     */
    public static Timeline getTimeLine(Movable a){
        Timeline time=new Timeline();
        int u=0;

        for(Node square:a.getGroup().getChildren()) {
            if(u>1){
                time.getKeyFrames().addAll(

                        new KeyFrame(new Duration(0),
                                new KeyValue(square.translateXProperty(),0),
                                new KeyValue(square.translateYProperty(),0)	),
                        new KeyFrame(new Duration(100),new KeyValue(square.translateXProperty(),100*Math.cos(u*30)),
                                new KeyValue(square.translateYProperty(),100*Math.sin(u*30)))
                );
                FadeTransition ft=new FadeTransition(Duration.millis(400), square);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();}

            u+=1;
        }
        return  time;

    }

}
