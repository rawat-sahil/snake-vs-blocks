package GuiComponent;

import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 */
public class Name extends VBox {
    boolean run=false;
    Label l=new Label("...");
    TextField tf=new TextField();

    /**
     *
     */
    public Name(){
        super();
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER);


    }

    /**
     * @param gameScene
     * @param stage
     */
    public void setText(GameScene gameScene, Stage stage){
        if (run==false){

            l.textProperty().bind(tf.textProperty());
            tf.setOnKeyTyped(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {

                    gameScene.setText(tf.getText());
                }
            });

            l.setStyle("-fx-background-color: rgb(22,22,22);-fx-text-fill: rgb(255,255,255);-fx-font-weight: bold;-fx-font-family: 'Century Schoolbook L';-fx-font-size: 50px;-fx-text-alignment: center");

            GameButton gameButton=new GameButton(gameScene,stage);

            super.setStyle("-fx-background-color: rgb(22,22,22);");
            super.getChildren().addAll(l,gameButton,tf);


        }
        else return;
    }

}


