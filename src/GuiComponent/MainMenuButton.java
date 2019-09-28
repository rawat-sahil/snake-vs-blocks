package GuiComponent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *Button in leader bord to go back to the mainmenu
 */
public class MainMenuButton extends Button {
    /**
     * @param menuScene
     * @param stage
     */
public MainMenuButton(MenuScene menuScene , Stage stage){
    super();
    super.setText("       Exit      ");
    super.setMinSize(100,100);
    super.setStyle("-fx-background-color: rgb(22,22,22);;-fx-border-width:2px;-fx-border-color: rgb(255,255,255);-fx-border-radius: 50px;-fx-font-size: 25px;-fx-font-weight: bold;-fx-text-fill: white");
    super.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            stage.setScene(menuScene);
        }
    });
}
}
