public class Car{
   private int dirtyness;
   
   /// default constructor til snavseet bil
   public Car(){
      int dirtyness = 200;
   }
   
   // set dirtyness
   public void setDirt(int dirt){
      if ((dirtyness+dirt)<0 || (dirtyness+dirt)>=200){
      dirtyness+=dirt;
      System.out.println("New dirt level is:+ "+dirtyness);
      } else {
      System.out.println("You can max add "+(dirtyness-200)+" to dirt level");
      }
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
         System.out.println("Your car a little dirty..\n");
      } else if(dirtyness<=50){
         System.out.println("Your car is clean!\n");
      }
      return dirtyness;
   }
}