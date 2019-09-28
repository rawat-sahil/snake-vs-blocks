package GuiComponent;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *Button to start the game and play
 * Start button
 */
public class GameButton extends Button {
    /**
     * @param gameScene
     * @param stage
     */
    public GameButton(GameScene gameScene, Stage stage){
        super();
        super.setText("       Enjoy The Game      ");
        super.setMinSize(100,100);
        super.setStyle("-fx-background-color: rgb(22,22,22);;-fx-border-width:2px;-fx-border-color: rgb(255,255,255);-fx-border-radius: 50px;-fx-font-size: 25px;-fx-font-weight: bold;-fx-text-fill: white");
        super.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * @param actionEvent
             */
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(gameScene);
                gameScene.play();
            }
        });

    }
}
