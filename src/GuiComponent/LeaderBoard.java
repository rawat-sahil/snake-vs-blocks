package GuiComponent;

import GameObjects.Score;
import GameObjects.Serialize;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


/**
 *LeaderBoard to Store the Highest Score
 */
public class LeaderBoard extends VBox {
    boolean run=false;
    Label[] labels=new Label[10];
    Serialize serialize=new Serialize();

    /**
     *Constructor
     */
    public LeaderBoard() {
        super();
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER_LEFT);
    }

    /**
     * @param menuScene
     * @param stage
     */
    public void setButtons(MenuScene menuScene, Stage stage){
      if(run==false) {
          super.setStyle("-fx-background-color: rgb(22,22,22);");
          MainMenuButton mainMenuButton = new MainMenuButton(menuScene, stage);
          List<Score>sc=new ArrayList<>();
          try{sc=serialize.deserialize();}
          catch(Exception e){}
          for(int i=0;i<10;++i){

              if(i<sc.size()){labels[i]=new Label(""+(i+1)+"."+" "+sc.get(sc.size()-i-1).getName()+" "+sc.get(sc.size()-i-1).getScore()+"  "+sc.get(i).getDate());}
              else{labels[i]=new Label(""+(i+1)+".");}
              labels[i].setStyle("-fx-background-color: rgb(22,22,22);-fx-text-fill: rgb(255,255,255);-fx-font-weight: bold;-fx-font-family: 'Century Schoolbook L';-fx-font-size: 30px;-fx-text-alignment: center");
                super.getChildren().add(labels[i]);
          }
          super.getChildren().add(mainMenuButton);
          run=true;
      }
    }

    }
