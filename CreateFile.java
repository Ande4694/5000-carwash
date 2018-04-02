import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.youtube.com/watch?v=Bws9aQuAcdg&list=PLFE2CE09D83EE3E28&index=80
public class CreateFile{

   private Formatter t;
   private Scanner x;
   
   public void openFile(){
      try{
         t = new Formatter("CarWashStats.txt");
      }
      catch(Exception e){
         System.out.println("An error occured.");
      }  
   }


public void addRecords(int spend, int bad, int good, int superb, int carsWashed, int average){
      try{
         x = new Scanner(new File("CarWashStats.txt"));
      }
      catch (Exception e){
         System.out.println("there was an error reading from file");
      }
      
      
    /*  while(x.hasNext()){
         String a = x.next(); // spend
         String b = x.next(); // bad
         String c = x.next(); // good
         String d = x.next(); // super
         String e = x.next(); // carswashed
         String f = x.next(); // average
         
         int aa = Integer.parseInt(a);
         int bb = Integer.parseInt(b);
         int cc = Integer.parseInt(c);
         int dd = Integer.parseInt(d);
         int ee = Integer.parseInt(e);
         int ff = Integer.parseInt(f);
         
         
int spenda = aa + spend;
int bada = bb + bad;
int gooda = cc + good;
int superba = dd + superb;
int carsWasheda = ee + carsWashed;
int averagea = ff + average;
*/
      
      
   t.format("%d %d %d %d %d %d", spend, bad, good, superb, carsWashed, average);
   t.format(System.lineSeparator());

}

public void closeFile(){
   x.close();
}
}