import java.util.Random;
public class Car{
   private int dirtyness;
   Random random = new Random();
   
   
   /// default constructor til snavseet bil
   public Car(){
   int dirtyness = 200;
   
   }
   // set dirtyness. 
   public void setDirt(){
      dirtyness = random.nextInt(200-35+1)+35;
   }
   
   // get dirt
   public int getDirt(){
      return dirtyness;
   }
   
   // display dirt
   public void displayDirt(){
      System.out.println(dirtyness);
   }
   
   // metoder til at vaske
   public int wash(int rens){
      dirtyness-=rens;
      if(dirtyness>=170){
         System.out.println("Your car is very dirty..\n");
      } else if(dirtyness>100 && dirtyness<170){
         System.out.println("Your car is dirty..");
      } else if(dirtyness>50 && dirtyness<=100){
         System.out.println("Your car is a little dirty..\n");
      } else if(dirtyness<=50){
         System.out.println("Your car is clean!\n");
      }
      return dirtyness;
   }
      

}