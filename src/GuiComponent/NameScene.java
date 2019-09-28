package GuiComponent;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 */
public class NameScene extends Scene {
    Stage stage;
    GameScene gameScene;
    Name name;
    boolean run=false;
    public NameScene(Name name){
        super(name,600,600);
        this.name=name;
    }

    /**
     * @param gameScene
     * @param stage
     */
    public void setScene(GameScene gameScene, Stage stage){
        if(run==false){

            this.gameScene=gameScene;

            this.stage=stage;
            name.setText(gameScene, stage);
            run=true;

        }
        else return;
    }

}
