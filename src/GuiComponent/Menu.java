package GuiComponent;

import GameObjects.Score;
import GameObjects.Serialize;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *VBOx that contains all the components of the first page i.e menu page
 */
public class Menu extends VBox {
    boolean run=false;

    /**
     *Constructor
     */
    public Menu(){
        super();
        super.setSpacing(10);
         super.setAlignment(Pos.CENTER);


    }

    /**
     * @param nameScene
     * @param gameScene
     * @param leaderBoardScene
     * @param stage
     * @param score
     */
    public void setButtons(NameScene nameScene,GameScene gameScene, LeaderBoardScene leaderBoardScene, Stage stage, Score score){
        if (run==false){
            StartButton startButton=new StartButton(nameScene,stage);
            LeaderBoardButton leaderBoardButton=new LeaderBoardButton(leaderBoardScene,stage);
            ResumeButton resumeButton=new ResumeButton(gameScene,stage);
            Label gameLabel=new Label(" Snake \n VS \n Blocks");



            if(score!=null){
            Label sx=new Label("Score :" + score.getScore());

            sx.setStyle("-fx-background-color: rgb(22,22,22);-fx-text-fill: rgb(255,255,255);-fx-font-weight: bold;-fx-font-family: 'Century Schoolbook L';-fx-font-size: 30px;-fx-text-alignment: center");
            gameLabel.setStyle("-fx-background-color: rgb(22,22,22);-fx-text-fill: rgb(255,255,255);-fx-font-weight: bold;-fx-font-family: 'Century Schoolbook L';-fx-font-size: 30px;-fx-text-alignment: center");
            super.setStyle("-fx-background-color: rgb(22,22,22);");
            super.getChildren().addAll(gameLabel,sx,startButton,resumeButton,leaderBoardButton);}
            else{ gameLabel.setStyle("-fx-background-color: rgb(22,22,22);-fx-text-fill: rgb(255,255,255);-fx-font-weight: bold;-fx-font-family: 'Century Schoolbook L';-fx-font-size: 30px;-fx-text-alignment: center");
                super.setStyle("-fx-background-color: rgb(22,22,22);");
                super.getChildren().addAll(gameLabel,startButton,resumeButton,leaderBoardButton);}
            run=true;
        }
        else return;
    }

}
