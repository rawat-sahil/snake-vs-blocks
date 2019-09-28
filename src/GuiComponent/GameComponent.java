package GuiComponent;

import GameObjects.Snake;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *Group to hold all the components of the game
 */
public class GameComponent extends Group {
    Snake snake;
    DropMenuButton dropMenuButton;
    boolean run =false;
    Label Score;
    public GameComponent(){

    }

    /**
     * @param snake
     */
    public void setSnake(Snake snake){
        if(run==false){
            this.snake=snake;
            run=true;
        }


        else return;
    }

    public void setDropMenuButton(DropMenuButton dropMenuButton){
        this.dropMenuButton=dropMenuButton;
    }

    public  void add(Node node){
        super.getChildren().add(node);
    }
    public void setScore(Label Score){this.Score=Score;}
}
