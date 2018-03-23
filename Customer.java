import java.io.File;
public class Customer{

   // han har :
   // dankort, holder double
   // vaske kort, holder double
   
   private double[] washcard = new double[1];
   private double[] creditCard = new double[1];
   private double administrationFee = 150.00;
   Car customerCar = new Car();
   Logger log1 = new Logger("Carwash_log.txt");
   
   // default constructor  til customer s� de har 1000 dkk
   public Customer(){
      creditCard[0]=1000;
   }
   
   // customer washes car1 300dkk - 150 dirt
   public void wash1(){
      if(washcard[0]>=300){
      washcard[0]-=300.00;
      customerCar.wash(150);
      log1.log("Car was washed with \"Super wash\"");
      } else {
         System.out.println("You do not have enough funds on your washcard, please deposit more money to purchase this wash."); 
         log1.log("Not enough funds for the \"Super wash\"");
      }
   }
   
   // customer washes car2 200dkk - 100 dirt
   public void wash2(){
      if(washcard[0]>=200){
      washcard[0]-=200.00;
      customerCar.wash(100);
      log1.log("Car was washed with \"Good wash\"");
      } else {
         System.out.println("You do not have enough funds on your washcard, please deposit more money to purchase this wash."); 
         log1.log("Not enough funds for the \"Good wash\"");
      }
   }

   // customer washes car3 100dkk - 50 dirt 
   public void wash3(){
      if(washcard[0]>=100){
      washcard[0]-=100.00;
      customerCar.wash(50);
      log1.log("Car was washed with \"Bad wash\"");
      } else {
         System.out.println("You do not have enough funds on your washcard, please deposit more money to purchase this wash.");
         log1.log("Not enough funds for the \"bad wash\""); 
      }
   }   
   
   // create washcard
   public double[] createWashCard(){
      if (creditCard[0]>=administrationFee){
         creditCard[0]-=administrationFee;
         double[] washcard = new double[1];
         System.out.println("Your wash card has been created and is now ready to use.\n Please deposit money on it first.");
         return washcard;
               } else {
         System.out.println("You do not have enough funds on your credit card..");
      }    
      return washcard;  
   }   
   
   // set money p� dankort
   public void setMoneyDankort(double money){
      creditCard[0]+=money;
   }
   
   
   // deposit money p� vaske kort
   public void depositWashCard(double money){
      if(money<=creditCard[0]){         
         washcard[0]+=money;
         creditCard[0]=creditCard[0]-money;
         System.out.println(money+" dkk has been transfered from your credit card to you washcard.\nYour currently have "+washcard[0]+" dkk on your wash card.");
      } else {
         System.out.println("You do not have enough funds on your credit card..");
      }     
   }
   
   // check balance
   public void checkBalance(){
      System.out.println("Your wash card account:   "+washcard[0]);
   }
   
   // set washcard
   public void setWashCard(double money){
      washcard[0]=money;
   }
   
   // get dankort
   public double getCreditCard(){
      return creditCard[0];
   }
   
   // get washcard
   public double getWashcard(){
      return washcard[0];
   }
   
   
}