package GuiComponent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * DropDown Menu button in the game scene
 */
public class DropMenuButton extends MenuButton {
    MenuItem startAgain;
    MenuItem goToMain;

    /**
     * @param menuScene
     * @param gameScene
     * @param stage
     */
    public DropMenuButton(MenuScene menuScene, GameScene gameScene,Stage stage){
        super();
        startAgain=new MenuItem("Start Again");
        goToMain=new MenuItem("Go to Main");
        super.getItems().addAll(startAgain,goToMain);
        //start again event handler
        startAgain.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * function to start the game again
             * @param actionEvent
             */
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Runtime.getRuntime().exec("java -jar Game.jar  ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });

        //go to main event handler
        goToMain.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * function to go to main menu
             * @param actionEvent
             */
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Runtime.getRuntime().exec("java -jar game.jar  ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });


    }
}
