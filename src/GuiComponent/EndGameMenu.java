package GuiComponent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * VBOx to contain all the componenets of the scene after the game ends
 */
public class EndGameMenu extends VBox {

    public EndGameMenu(int Score){
        super();
        super.setSpacing(10);
        super.setStyle("-fx-background-color: rgb(22,22,22);");
        super.setAlignment(Pos.CENTER);
        Button gameEnd=new Button("Game Over \n Score "+Score);
        gameEnd.setMinSize(100,100);
        gameEnd.setStyle("-fx-background-color: rgb(22,22,22);;-fx-border-width:2px;-fx-border-color: rgb(255,255,255);-fx-border-radius: 50px;-fx-font-size: 25px;-fx-font-weight: bold;-fx-text-fill: white");
        Button Next=new Button("Next");
        Next.setOnAction(new EventHandler<ActionEvent>() {
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
        Next.setMinSize(100,100);
        Next.setStyle("-fx-background-color: rgb(22,22,22);;-fx-border-width:2px;-fx-border-color: rgb(255,255,255);-fx-border-radius: 50px;-fx-font-size: 25px;-fx-font-weight: bold;-fx-text-fill: white");
        super.getChildren().addAll(gameEnd,Next);
    }
}
