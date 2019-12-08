import GuiComponent.*;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application  {

    GuiComponent.Menu menu;
    GameComponent gameComponent;
    LeaderBoard leaderBoard;
    MenuScene menuScene;
    GameScene gameScene;
    LeaderBoardScene leaderBoardScene;

    

    /**
     * @param args
     */
    public static void main(String[]args){
        launch(args);
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Menu menu=new Menu();
        Name name=new Name();
        GameComponent gameComponent=new GameComponent();
        LeaderBoard leaderBoard=new LeaderBoard();
        NameScene nameScene=new NameScene(name);
        MenuScene menuScene=new MenuScene(menu);
        GameScene gameScene=new GameScene(gameComponent);
        LeaderBoardScene leaderBoardScene=new LeaderBoardScene(leaderBoard);
        menuScene.setScene(nameScene,gameScene,leaderBoardScene,stage);
        leaderBoardScene.setScene(menuScene,stage);
        nameScene.setScene(gameScene, stage);
        gameScene.setScene(menuScene,stage);
        stage.setScene(menuScene);
        stage.show();


    }
}
