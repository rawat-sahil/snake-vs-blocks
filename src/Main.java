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

    public static int  checkall(){
    	if(menu==null)return 0;
    	else return 1;
    	if(gameComponent==null)return 0;
    	else return 1;
    	if(leaderBoard==null)return 0;
    	else return 1;
    	if(menuScene==null)return 0;
    	else return 1;
    	if(gameScene==null)return 0;
    	else return 1;
    	if(leaderBoardScene==null)return 0;
    	else return 1;
    }

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
