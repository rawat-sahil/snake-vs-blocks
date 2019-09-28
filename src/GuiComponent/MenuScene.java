package GuiComponent;

import GameObjects.Score;
import GameObjects.Serialize;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *Scene that contains Menu
 */
public class MenuScene extends Scene {
    Stage stage;
    GameScene gameScene;
    NameScene nameScene;
    LeaderBoardScene leaderBoardScene;
    Serialize s=new Serialize();
    Score score =new Score();
    Menu menu;
    boolean run=false;

    /**
     * @param menu
     */
    public MenuScene(Menu menu){
        super(menu,600,600);
        this.menu=menu;
    }

    /**
     * @param nameScene
     * @param gameScene
     * @param leaderBoardScene
     * @param stage
     */
    public void setScene(NameScene nameScene,GameScene gameScene,LeaderBoardScene leaderBoardScene,Stage stage){
        if(run==false){
        this.gameScene=gameScene;
        this.leaderBoardScene=leaderBoardScene;
        this.nameScene=nameScene;
        this.stage=stage;
            try{score=s.deserialize_Last_Score();}
            catch(Exception e){}
        menu.setButtons(nameScene,gameScene,leaderBoardScene,stage, score);
        run=true;

        }
        else return;
    }
public void setScore(Score s){
        this.score =s;
    menu.setButtons(nameScene,gameScene,leaderBoardScene,stage, s);
}
    }

