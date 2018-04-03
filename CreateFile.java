import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.youtube.com/watch?v=Bws9aQuAcdg&list=PLFE2CE09D83EE3E28&index=80
public class CreateFile{

   private Formatter x;
   
   public void openFile(){
      try{
         x = new Formatter("CarWashStats.txt");
      }
      catch(Exception e){
         System.out.println("An error occured.");
      }  
   }


public void addRecords(int spend, int bad, int good, int superb, int carsWashed, int average){
   x.format("%d %d %d %d %d %d", spend, bad, good, superb, carsWashed, average);
   x.format(System.lineSeparator());
}

public void closeFile(){
   x.close();
}
}