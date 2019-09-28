package GameObjects;

import java.io.Serializable;
import java.util.Date;

/**
 *Class that is used to save all the scores of the game
 */
public class Score implements Serializable ,Comparable {
    private Date date =new Date();
    private int score=0;
    private String name;
public String getName(){return this.name;
}
public void setName(String Name){this.name=Name;}
public int getScore(){
    return this.score;

}

public Date getDate(){
    return this.date;
}
public void setScore(int score){
    this.score+=score;
}

    @Override
    public int compareTo(Object o) {
        Score s=(Score)o;
        if(this.getScore()>s.getScore()){return 1;}
        else if(this.getScore()<s.getScore()){return -1;}
        return 0;
    }
}
