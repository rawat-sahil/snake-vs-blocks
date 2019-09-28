package GuiComponent;

import EventHandlers.BlockEvent;
import EventHandlers.SnakeEventHandler;
import GameObjects.*;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

/**
 *Game Scene where the game is being playes
 */
public class GameScene extends Scene {
    SnakeEventHandler event_Handler;
    MenuScene menuScene;
    Stage stage;
    Label Score;
    Score score;
    String name;
    Serialize serialize=new Serialize();
    GameComponent gameComponent;
    Snake snake;
    DropMenuButton dropMenuButton;
    Movable[][] grid;
    int[][] pos;
    boolean run=false;
    Timeline timeline1=new Timeline();

    /**
     * @param gameComponent
     */
    public GameScene(GameComponent gameComponent) {

        super(gameComponent,495,600);
        super.setFill(Color.BLACK);
        this.gameComponent=gameComponent;
        grid=new Movable[8][8];
        pos=new int[8][8];
    }

    /**
     * @param name
     */
    public void setText(String name){this.name=name;}

    /**
     * function to set all the fiels variable and initialise them
     * @param menuScene
     * @param stage
     */
    public void setScene(MenuScene menuScene,Stage stage){
        if(run==false){
            this.menuScene=menuScene;
            this.stage=stage;
            event_Handler=new SnakeEventHandler(snake,1,495);
            score=new Score();
            snake=new Snake(5, Color.PURPLE);
            int scores=score.getScore();
            this.Score=new Label("Score"+" "+scores);
            dropMenuButton=new DropMenuButton(menuScene,this,stage);
            gameComponent.setSnake(snake);
            gameComponent.setDropMenuButton(dropMenuButton);
            gameComponent.add(snake);
            gameComponent.add(dropMenuButton);
            gameComponent.setScore(Score);
            gameComponent.add(Score);
            Score.setLayoutX(400);
            Score.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white");
            super.setOnMouseMoved(event_Handler);
            run=true;

        }
        else return;
    }

    /**
     *function to start the game
     */
    public void play(){
        int y=20;
        int x=0;
        /**
         * loop to create the coordinates that movable needs to be moved in each frame
         */
        for(int i=0;i<8;++i){
                for(int j=0;j<8;++j){
                    pos[i][j]=y;
                }
                y+=145;
            }
            y=20;
//

        run();
    }
    Boolean shield_time=false;
    Boolean time=false;
    public void setTime(Boolean t){
        time=t;
    }
    public void setShieldTime(Boolean t){shield_time=t;}

    /**
     * function being called by play() to rn the logic to create the movables and their interaction
     */
    public void run(){
score.setName(name);
        timeline1.getKeyFrames().addAll(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            /**
             * @param actionEvent
             */
            @Override

            public void handle(ActionEvent actionEvent) {
                GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake,0,496));
                ArrayList<Movable> blocks=new ArrayList<>();
                ArrayList<Boolean> AnimationBlocks=new ArrayList<Boolean>();
                ArrayList<Movable> coins=new ArrayList<>();
                ArrayList<Boolean> Animation_Coins=new ArrayList<>();
                ArrayList<Movable> wall=new ArrayList<>();
                ArrayList<Boolean> Animation_wall=new ArrayList<>();
                ArrayList<Movable> ball=new ArrayList<>();
                ArrayList<Boolean> AnimationBalls=new ArrayList<>();
                ArrayList<Movable> destroy_blocks=new ArrayList<>();
                ArrayList<Boolean> Animation_Destroy=new ArrayList<>();
                ArrayList<Movable> Magnet=new ArrayList<>();
                ArrayList<Boolean> Animation_Magnet=new ArrayList<>();
                ArrayList<Movable>Shield=new ArrayList<>();
                ArrayList<Boolean>Animation_Shield=new ArrayList<>();
                ArrayList<Integer>Block_value=new ArrayList<>();
                Timeline timeline=new Timeline();
                KeyFrame[][] keyFrames=new KeyFrame[8][8];
                int x=0;
                for(int j=0;j<8;++j){
                    if(grid[0][j]!=null){
                        gameComponent.add((Node) grid[0][j]);
                    }
                }

                int b=(int)(Math.random()*100);

                for(int i=6;i>=0;--i){
                    for(int j=0;j<8;++j){
                        if(grid[i][j]!=null){
                        keyFrames[i][j]=new KeyFrame(Duration.millis(1000),
                                new KeyValue(grid[i][j].translateyProperty(),pos[i][j]),
                                new KeyValue(grid[i][j].translateyProperty(),pos[i+1][j]));
                        timeline.getKeyFrames().add(keyFrames[i][j]);
                        if(i>1){System.out.println(pos[i-1][j]);
                            grid[i][j].move(pos[i-1][j]);}
                        if(i==6){
                            gameComponent.getChildren().remove(grid[i+1][j]);
                        }}

                    }
int flag=0;
for(int index=0;index<Block_value.size();index++){if(Block_value.get(index)<snake.getSnake_length()){
    flag=1;
}}
                       if(b>=0&&b<30){
                            int a= (int) (Math.random()*10);
                            if(a>=0 && a<=4){
                                grid[0][i]=new Block(x,-20,new Random().nextInt(10)+1);
                            blocks.add(grid[0][i]);
                            AnimationBlocks.add(false);
                            }
//

                            else{
                                grid[0][i]=null;
                            }
                        }
                       else if(b>31 && b<=50){
                           int a= (int) (Math.random()*10);
                           if(a>=0 && a<=3){
                               grid[0][i]=new wall(x,-20);
                               wall.add(grid[0][i]);
                               Animation_wall.add(false);
                           }

                           else{
                               grid[0][i]=null;
                           }
                       }
                        else if(b>=51&&b<=60){
                            int a= (int) (Math.random()*10);
                            if(a>=0 && a<=3){
                                grid[0][i]=new Coin(x,-20);
                            coins.add(grid[0][i]);
                            Animation_Coins.add(false);}
                            else{
                                grid[0][i]=null;
                            }
                        }
                        else if(b>=61&&b<=65){
                            int a= (int) (Math.random()*10);
                            if(a>=0 && a<=5){
                                grid[0][i]=new Magnet(x,-20);
                            Magnet.add(grid[0][i]);
                            Animation_Magnet.add(false);}
                            else{
                                grid[0][i]=null;
                            }
                        }
                        else if(b>65 && b<=70){

                            if(flag==1 || snake.getSnake_length()==1){int z=new Random().nextInt(10)+1;
                            Block_value.add(z);
                            grid[0][i]=new Block(x,-20,z);}
                            else{
                                int y=new Random().nextInt(snake.getSnake_length()-1)+1;
                                Block_value.add(y);
                                grid[0][i]=new Block(x,-20,y);
                            }
                            blocks.add(grid[0][i]);
                            AnimationBlocks.add(false);

                       }
                       else if(b>70 && b<=75){
                           int a= (int) (Math.random()*10);

                           if(a>=0 && a<=5){
                               grid[0][i]=new Ball(x,-20,new Random().nextInt(10)+1);
                           ball.add(grid[0][i]);
                           AnimationBalls.add(false);
                           }

                           else{
                               grid[0][i]=null;
                           }
                       }
                       else if(b>75 && b<=80){
                           int a= (int) (Math.random()*10);
                           if(a>=0 && a<=3){
                               grid[0][i]=new Destroy_Blocks(x,-20);
                               destroy_blocks.add(grid[0][i]);
                               Animation_Destroy.add(false);
                           }

                           else{
                               grid[0][i]=null;
                           }
                       }
                       else if(b>80 && b<=85){
                           int a= (int) (Math.random()*10);
                           if(a>=0 && a<=3){
                               grid[0][i]=new Shield(x,-20);
                               Shield.add(grid[0][i]);
                               Animation_Shield.add(false);
                           }

                           else{
                               grid[0][i]=null;
                           }
                       }

                       else {
                           grid[0][i]=null;
                       }
                        x+=70;


                }
                for(int i=6;i>=0;--i){
                    for(int j=0;j<8;++j){
                        grid[i+1][j]=grid[i][j];


                    }
                }
                new AnimationTimer(){
                    public void handle(long now){

                        for(int k=0;k<blocks.size();k++){
                            if( blocks.get(k).intersects(snake.getHead()) && AnimationBlocks.get(k)==false){



                                int index=gameComponent.getChildren().indexOf(blocks.get(k));
                                Movable grid=(Movable) gameComponent.getChildren().get(index);

                                Group g=(Group)gameComponent.getChildren().get(index);
                                Rectangle r=(Rectangle)g.getChildren().get(0);

                                if(g.getChildren().size()==12){
                                    Text t=(Text)g.getChildren().get(1);
//

                                    if(snake.getSnake().size()-Integer.parseInt(t.getText())>0 || time==true){
                                        score.setScore(Integer.parseInt(t.getText()));
                                    Label s=new Label("Score"+" "+score.getScore());
                                    s.setLayoutX(400);
                                    s.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white");
                                    gameComponent.getChildren().remove(Score);
                                    Score=s;
                                    gameComponent.getChildren().add(s);
                                      if(!time){  gameComponent.getChildren().remove(snake);
                                    Snake sna=new Snake(snake.getSnake().size()-Integer.parseInt(t.getText()) , snake.getCenter(),snake.getHead().getFill() );
                                    gameComponent.getChildren().add(sna);
                                    snake=sna;
                                    GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake,1,496));}}

                                    else{
                                    int sc=score.getScore();

                                    try{serialize.serialize_Last_Score(score);}catch (Exception e){}

                                    serialize.check(score);
                                    run=false;


                                        snake.setFlag(false);
                                        GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake,(int)r.getX()+1,(int)r.getX()+69));
                                       menuScene.setScore(score);
                                        stage.setScene(menuScene);
                                    timeline.stop();
                                        timeline1.stop();

//
                                    EndGameScene end=new EndGameScene(score.getScore());
                                    stage.setScene(end);

                                    }
                       long b=System.nanoTime();

                                    if(Integer.parseInt(t.getText())>5){
                                     while(System.nanoTime()-b <500000000){  timeline1.pause();}
                                    timeline1.play();
                                    }


                                    Timeline time=BlockEvent.getTimeLine(blocks.get(k));
                                    time.play();
                                    }
                                blocks.get(k).getGroup().getChildren().remove(0);
                                blocks.get(k).getGroup().getChildren().remove(0);
                                if(index>0){gameComponent.getChildren().remove(grid);
                                gameComponent.getChildren().add((Node)blocks.get(k));
                                AnimationBlocks.set(k,true);
                               }

            GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake,(int)r.getX()+1,(int)r.getX()+69));
                            }
                        }
                    }
                }.start();
                new AnimationTimer(){
                    public void handle(long now){
                        for(int k=0;k<ball.size();k++){
                            if(ball.get(k).intersects(snake.getHead()) && AnimationBalls.get(k)==false){
                                Text t=(Text)ball.get(k).getGroup().getChildren().get(1);
                                int length=snake.getSnake().size();

                                gameComponent.getChildren().remove(snake);
                                Rectangle re=(Rectangle)ball.get(k).getGroup().getChildren().get(0);

                                Snake s=new Snake(length+Integer.parseInt(t.getText()) , snake.getCenter(),re.getFill() );
                                gameComponent.getChildren().add(s);
                                snake=s;
                                GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake,1,496));
                                AnimationBalls.set(k,true);
                                gameComponent.getChildren().remove(ball.get(k));

                            }
                        }
                    }
                }.start();

                new AnimationTimer(){
                    public void handle(long now){
                        for(int k=0;k<coins.size();k++){
                            if(coins.get(k).intersects(snake.getHead()) && Animation_Coins.get(k)==false ){
                                gameComponent.getChildren().remove(coins.get(k));
                                score.setScore(5);
                                Label s=new Label("Score"+" "+score.getScore());
                                s.setLayoutX(400);
                                s.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white");
                                gameComponent.getChildren().remove(Score);
                                Score=s;
                                gameComponent.getChildren().add(s);
                                Animation_Coins.set(k,true);
                            }
                        }
                    }
                }.start();
                new AnimationTimer(){
                    public void handle(long now){
                        for(int k=0;k<destroy_blocks.size();k++){
                            if(destroy_blocks.get(k).intersects(snake.getHead()) && Animation_Destroy.get(k)==false){
                                for(int u=0;u<grid.length;u++){
                                    for(int v=0;v<grid[0].length;v++){
                                        if(grid[u][v]!=null){

                                            if(grid[u][v].toString().equals("Block"))
                                            {if(grid[u][v].getGroup().getChildren().size()==12){
                                                Text t=(Text)grid[u][v].getGroup().getChildren().get(1);
                                                score.setScore(Integer.parseInt(t.getText()));
                                                Label s=new Label("Score"+" "+score.getScore());
                                                s.setLayoutX(400);
                                                s.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white");
                                                gameComponent.getChildren().remove(Score);
                                                Score=s;
                                                gameComponent.getChildren().add(s);}


                                                Timeline time=BlockEvent.getTimeLine(grid[u][v]);
                                                time.play();
                                                int index=gameComponent.getChildren().indexOf(grid[u][v]);


                                                grid[u][v].getGroup().getChildren().remove(0);
                                                grid[u][v].getGroup().getChildren().remove(0);
                                                if(index>=0){gameComponent.getChildren().set(index,(Node)grid[u][v]);}

                                            }

//

                                        }}
                                }

                                Animation_Destroy.set(k,true);
                                gameComponent.getChildren().remove(destroy_blocks.get(k));

                            }
                        }
                    }
                }.start();
                new AnimationTimer(){
                    public void handle(long now){
                        if(time){
                            for(int u=0;u<grid.length;u++){
                                for(int v=0;v<grid[0].length;v++){
                                    if(grid[u][v]!=null){
                                        if(grid[u][v].toString().equals("Coin")  )
                                        {Rectangle re=(Rectangle)grid[u][v].getGroup().getChildren().get(0);
                                            if( grid[u][v].gety()>=185 && grid[u][v].gety()<515 && snake.getHead().getCenterX()-100 <= re.getX()&&re.getX()<snake.getHead().getCenterX()+100)
                                            {
                                                gameComponent.getChildren().remove(grid[u][v]);}



                                        }


//

                                    }}
                            }
                        }
                    }
                }.start();
                new AnimationTimer(){
                    public void handle(long now){

                        for(int k=0;k<Magnet.size();k++){


                            if(Magnet.get(k).intersects(snake.getHead()) && Animation_Magnet.get(k)==false){
                                // translate coins to snake head
                                setTime(true);
                                Timeline timeline1=new Timeline(new KeyFrame(Duration.millis(10000), new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent action){
                                        setTime(false);

                                    }
                                }));
                                timeline1.play();



                                for(int u=0;u<grid.length;u++){
                                    for(int v=0;v<grid[0].length;v++){
                                        if(grid[u][v]!=null){


                                            if(grid[u][v].toString().equals("Coin")  )
                                            {Rectangle re=(Rectangle)grid[u][v].getGroup().getChildren().get(0);
                                                if( grid[u][v].gety()>=165 && grid[u][v].gety()<310 && snake.getHead().getCenterX()-150 <= re.getX()&&re.getX()<snake.getHead().getCenterX()+150)
                                                {
                                                    gameComponent.getChildren().remove(grid[u][v]);}



                                            }

//

                                        }}
                                }
                                Animation_Magnet.set(k,true);
                                gameComponent.getChildren().remove(Magnet.get(k));
                            }
                        }
                    }
                }.start();
                new AnimationTimer(){
                    public void handle(long now){
                        for(int k=0;k<wall.size();k++){
                            Line l1=(Line)wall.get(k).getGroup().getChildren().get(0);

                            if(wall.get(k).intersects(snake.getHead())){

                                //Line l2=(Line)wall.get(k).getGroup().getChildren().get(1);
                                GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake,(int)l1.getStartX()-1 ,(int)l1.getStartX()+101));

                            }
                            else if(k==0){if(0<=snake.getHead().getCenterX() && snake.getHead().getCenterX() <l1.getStartX()&&snake.getHead().getCenterY()==wall.get(k).gety()){
                                GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake,0 ,(int)l1.getStartX()));
                            }}
                            else if(k==wall.size()-1){
                                if(l1.getStartX()+101<=snake.getHead().getCenterX() && snake.getHead().getCenterX() <600&&snake.getHead().getCenterY()==wall.get(k).gety()){
                                    GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake, (int)l1.getStartX()+101,600));
                                }
                            }
                            else {
                                Line l2=(Line)wall.get(k-1).getGroup().getChildren().get(1);

                                if(l2.getStartX()<snake.getHead().getCenterX() && snake.getHead().getCenterX()<l1.getStartX() && snake.getHead().getCenterY()==wall.get(k).gety()){
                                    GameScene.super.setOnMouseMoved(new SnakeEventHandler(snake,(int)l2.getStartX(),(int)l1.getStartX()));
                                }

                            }


                            //System.out.println(l1.getStartX()+" "+l1.getStartX());

                        }
                    }
                }.start();
new AnimationTimer(){
    public void handle(long now){
        for(int k=0;k<Shield.size();k++){
            if(Shield.get(k).intersects(snake.getHead())){
                setShieldTime(true);
                Timeline timeline1=new Timeline(new KeyFrame(Duration.millis(10000), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent action){
                        setShieldTime(false);

                    }
                }));
                timeline1.play();
     gameComponent.getChildren().remove(Shield.get(k));
     Animation_Shield.set(k,true);
            }
        }

    }
}.start();
                timeline.play();

            }
        }));

        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();

       // run();
    }

}
