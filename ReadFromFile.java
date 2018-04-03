import java.io.*;
import java.util.*;

public class ReadFromFile{
public String read;
   private Scanner x;
   int aa;

   
   public void openFile(){
      try{
         x = new Scanner(new File("CarWashStats.txt"));
      }
      catch (Exception e){
         System.out.println("there was an error reading from file");
      }
   }
   
   public void readFile(){
   try{
      while(x.hasNext()){
         String a = x.next(); // spend
         String b = x.next(); // bad
         String c = x.next(); // good
         String d = x.next(); // super
         String e = x.next(); // carswashed
         String f = x.next(); // average
         
         System.out.println("Cars washed this session: \t\t\t"+e);
         System.out.println("Total spend this session: \t\t\t"+a);
         System.out.println("Bad washes this session: \t\t\t"+b);
         System.out.println("Good washes this session: \t\t\t"+c);
         System.out.println("Super washes this session: \t\t"+d);
         System.out.println("Average spend this session: \t\t"+f);   

      }
      } catch (Exception e){
      System.out.println("Nothing has been logged yet.");
      }

   }
   
   ///// udskift "hentData" med "readFromFile"////
   ///
   ////
   public int[] hentData(){
   int [] data = new int[6];
      try{
         while(x.hasNext()){
           String a = x.next(); // spend
           String b = x.next(); // bad
           String c = x.next(); // good
           String d = x.next(); // super
           String e = x.next(); // carswashed
           String f = x.next(); // average
           //// cast til int
           int aa = Integer.parseInt(a);
           int bb = Integer.parseInt(b);
           int cc = Integer.parseInt(c);
           int dd = Integer.parseInt(d);
           int ee = Integer.parseInt(e);
           int ff = Integer.parseInt(f);           
           //// tilføj til data[]
           data[0] = aa;
           data[1] = bb;
           data[2] = cc;
           data[3] = dd;
           data[4] = ee;
           data[5] = ff;
           }   
      } catch (Exception e){
      System.out.println("problem under laesning af data"); 
      }
           
      return data;
   }
   
   public void closeFile(){
      try{ 
      x.close();
      }catch (Exception e){
      System.out.println("Could not close file because it doesnt excist.");
      }
   }

}