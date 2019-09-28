package GuiComponent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *Button in menu scene to switch to the game
 */
public class ResumeButton extends Button {
    /**
     * @param gameScene
     * @param stage
     */
    public ResumeButton(GameScene gameScene,Stage stage){
        super();
        super.setText("    Resume    ");
        super.setMinSize(100,100);
        super.setStyle("-fx-background-color: rgb(22,22,22);;-fx-border-width:2px;-fx-border-color: rgb(255,255,255);-fx-border-radius: 50px;-fx-font-size: 25px;-fx-font-weight: bold;-fx-text-fill: white");
        super.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(gameScene);
                gameScene.play();
            }
        });
    }
}
