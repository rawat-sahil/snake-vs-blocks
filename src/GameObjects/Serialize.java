package GameObjects;

import java.io.*;
import java.util.*;

/**
 *Class to serialise the scores of the game
 */
public class Serialize {
    /**
     * @param lo
     * @param c
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public  void serialize(List<Score> lo, Score c) throws IOException,ClassNotFoundException	 {
        ObjectOutputStream out	=	null;

        try {int flag=0;
            out	=	new	ObjectOutputStream	(new FileOutputStream("out.txt"));
            if(lo.size()>=0){
               if(lo.size()==0){ lo.add(c);}
                else{
                    for(int k=0;k<lo.size();k++){if(lo.get(k).getDate().equals(c.getDate()) && lo.get(k).getScore()==c.getScore() ){flag=1;}}

                    if(flag==0){
                        lo.add(c);
                   Collections.sort(lo);}



                }


           }
           // System.out.println(lo.size());
            //for(int i=0;i<lo.size();i++){System.out.print(lo.get(i).getScore()+" yo");}
            if(lo.size()>10){lo.remove(0);}
            out.writeObject(lo);}
        finally	{
            out.close();
        }
    }

    /**
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public	List<Score>	deserialize()
            throws	IOException,	ClassNotFoundException{
        List <Score>l= new ArrayList<Score>();
        ObjectInputStream in	=	null;

        try	{

            in	=new	ObjectInputStream	(new FileInputStream("out.txt"));

            Object s1=in.readObject();

            if(s1!=null) {l=(List<Score>)s1;}

        }

        finally {
            in.close();
        }
        return l;

    }

    /**
     * @param s
     */
    public void check(Score s) {
        List<Score> c = new ArrayList<>();
        try {
            c = deserialize();

        } catch (Exception e) {

        }
        try {
            serialize(c, s);

        } catch (Exception e) {
        }

    }

    /**
     * @param s
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public  void serialize_Last_Score(Score s) throws IOException,ClassNotFoundException	 {
        ObjectOutputStream out	=	null;

        try {
            out	=	new	ObjectOutputStream	(new FileOutputStream("last_score.txt"));

            out.writeObject(s);}
        finally	{
            out.close();
        }
    }

    /**
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public	Score	deserialize_Last_Score()
            throws	IOException,	ClassNotFoundException{
        Score l= new Score();
        ObjectInputStream in	=	null;

        try	{

            in	=new	ObjectInputStream	(new FileInputStream("last_score.txt"));

            Object s1=in.readObject();

            if(s1!=null) {l=(Score)s1;}

        }

        finally {
            in.close();
        }
        return l;

    }




}
