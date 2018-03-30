import java.io.File;
public class Customer{

   // han har :
   // dankort, holder double
   // vaske kort, holder double
   private String username;
   private String password;
   private int Changed = 1;
   private double[] washcard = new double[1];
   private double[] creditCard = new double[1];
   private double administrationFee = 150.00;
   Car customerCar = new Car();
   Logger log1 = new Logger("Carwash_log.txt");
   Logger log2 = new Logger("Receipt.txt");
   
   // default constructor  til customer så de har 1000 dkk
   public Customer(){
      creditCard[0]=1000;
   }
   
   Customer (String username, String password){
        this.username = username;
        this.password = password;
        creditCard[0]=1000;
   }
   
   public String getUsername(){
      return username;
   }
   
   public String getPassword(){
      return password;
   }
   
   // customer washes car1 300dkk - 150 dirt
   public void wash1(){
      if(washcard[0]>=300){
      Changed++;
      washcard[0]-=300.00;
      customerCar.wash(150);
      log1.log("Car was washed with \"Super wash\"");
      log2.log("Receipt of purchase: 1x \"Super wash\" by: "+getUsername()+" price: 300dkk.");
      } else {
         System.out.println("You do not have enough funds on your washcard, please deposit more money to purchase this wash."); 
         log1.log("Not enough funds for the \"Super wash\"");
      }
   }
   
   // customer washes car2 200dkk - 100 dirt
   public void wash2(){
      if(washcard[0]>=200){
      Changed++;
      washcard[0]-=200.00;
      customerCar.wash(100);
      log1.log("Car was washed with \"Good wash\"");
      log2.log("Receipt of purchase: 1x \"Good wash\" by: "+getUsername()+" price: 200dkk.");
      } else {
         System.out.println("You do not have enough funds on your washcard, please deposit more money to purchase this wash."); 
         log1.log("Not enough funds for the \"Good wash\"");
      }
   }

   // customer washes car3 100dkk - 50 dirt 
   public void wash3(){
      if(washcard[0]>=100){
      Changed++;
      washcard[0]-=100.00;
      customerCar.wash(50);
      log1.log("Car was washed with \"Bad wash\"");
      log2.log("Receipt of purchase: 1x \"Bad wash\" by: "+getUsername()+" price: 100dkk.");
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
         System.out.println("Your wash card has been created and is now ready to use.\n Please deposit money on it first.\n");
         log1.log(getUsername()+" succesfuly created a washcard"); 
         log2.log("Receipt of purchase: 1x \"5000 WashCard\" by: "+getUsername()+"Administration fee: 150dkk.");
         return washcard;
               } else {
         System.out.println("You do not have enough funds on your credit card..\n");
         log1.log(getUsername()+" failed to create a washcard due to insufficient funds."); 
      }    
      return washcard;  
   }   
   
   // set money på dankort
   public void setMoneyDankort(double money){
      creditCard[0]+=money;
   }
   
   
   // deposit money på vaske kort
   public void depositWashCard(double money){
      if(money<=creditCard[0]){         
         washcard[0]+=money;
         creditCard[0]=creditCard[0]-money;
         System.out.println(money+" dkk has been transfered from your credit card to you washcard.\nYour currently have "+washcard[0]+" dkk on your wash card.\n");
         log1.log(getUsername()+" transfered: "+money+" to "+getUsername()+"'s washcard."); 
         log2.log("Receipt of purchase: "+money+" washfunds added to washcard by: "+getUsername());
      } else {
         System.out.println("You do not have enough funds on your credit card..\n");
         log1.log(getUsername()+" failed to deposit money on his/hers washcard, due to insufficient funds."); 
      }     
   }
   
   // check balance
   public void checkBalance(){
      System.out.println("Your wash card account:   "+washcard[0]+"\n");
      log1.log(getUsername()+" checked balance."); 
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
   
   // get Changed
   public int getChanged(){
      return Changed;
   }
   // set Changed
   public void setChanged(){
      Changed = 1;
   }
   
   
}