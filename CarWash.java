import java.io.*;
import java.util.*;

public class CarWash{   
   public static void main(String[]args)throws IOException{
   String username;
   String password;
   boolean blankData = false;
   int totalSpend = 0;
   int washBad = 0;
   int washGood = 0;
   int washSuper = 0;
   int carsWashed = 0;
   int averageSpend = 0;
   String date = new Date().toString();
   
   Logger log1 = new Logger("Carwash_log.txt");
   CreateFile g = new CreateFile();
   ReadFromFile y = new ReadFromFile();
   /// https://stackoverflow.com/questions/303913/java-reading-integers-from-a-file-into-an-array
   File file = new File("CarWashStats.txt");
   byte[] bytes = new byte[(int) file.length()];
      try {
         FileInputStream fis = new FileInputStream(file);
         fis.read(bytes);
         fis.close();
      } catch (Exception e){
         System.out.println("CarWashStats.txt does not excist, cannot load previous data.");
      }

   String[] valueStr = new String(bytes).trim().split("\\s+");
   int[] data = new int[valueStr.length];
   for (int i = 0; i < valueStr.length; i++)
      try {       
         data[i] = Integer.parseInt(valueStr[i]);
      } catch (Exception e){
         System.out.println("CarWashStats.txt is blank, cannot load previous data.");
         blankData = true;
      }
     

        
        if (!blankData){
        totalSpend = data[0];
        washBad = data[1];
        washGood = data[2];
        washSuper = data[3];
        carsWashed = data[4];
        averageSpend = data[5]; 
        } 



        // Used to hold the instance of a user who successfully logged in
        Customer loggedInUser = null;
        boolean admin;
        admin = false;
        
        Customer[] listOfCustomers = new Customer[6];       
        
        listOfCustomers[0] = new Customer("Thomas","1234");
        listOfCustomers[1] = new Customer("Anders","7894");
        listOfCustomers[2] = new Customer("Jonathan","1337");
        listOfCustomers[3] = new Customer("Gustav","3396");
        listOfCustomers[4] = new Customer("Admin","1");
        

                 
        // Get user input
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
            
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("*** Welcome to Grp. 5000 Car Wash machine ***\n");
        log1.log("System was started");
        menuPromptStart();
        
        // anti Jarl, således at Jarl ikke ødelægger vores code ....
        while (!input.hasNextInt()) {
        input.next();
        System.out.println("Not an integer; try again.\nNice try Jarl...");
        log1.log("User entered wrong input, most likely Jarl");
        }

        int choice; 
         do 
      {
      choice = input.nextInt();
         switch(choice)
         {
         
         case 1:
         break;
         
         case 2:
         
         while (choice !=5000){
         System.out.println("To Create an account you must type a username and a password\n");
         log1.log("Attempt to create a new account and password");
         System.out.println("Please type a Username :");
         String Username = input.next();
         log1.log("New user created: "+Username);
         System.out.println("please type a password :");
         String Password = input.next();
         System.out.println("please type password again :");
         log1.log(Username+" created a password :"+Password);
         
         
         if(Password.equals(input.next())){
         System.out.println("Credentials Accepted.");
         listOfCustomers[5] = new Customer(Username,Password);
         choice = 5000;
         }
         else{
         System.out.println("Password did not match, try again.");
         log1.log(Username+" entered wrong password");
          }
         
         }
         
         
         System.out.println("Account created!\n");
         log1.log("New user created");
         menuPromptStart();
         break;
         
         case 0:
         System.out.println("Have a nice day!");
         log1.log("User exited system");
         try{
         averageSpend = (totalSpend/carsWashed);
         } catch (Exception e){
         System.out.println("Something went wrong, probably divid by zero");
         }
         g.openFile();
         g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
         g.closeFile();
         System.exit(0);
         break;
         
         default:
         System.out.println("Not an integer; try again.");
         log1.log("User entered wrong input, most likely Jarl");
         break;

         }
         }while(choice !=1);
         
         


        System.out.println("Please type your Username* :");
        username = br.readLine();   
        System.out.println("Please type your Password* :");
        password = br.readLine();
        log1.log((username)+" entered the system with password: "+password);

        // Iterate through list of users to see if we have a match
    try{
        for (Customer user : listOfCustomers)
        {
        
            if (user.getUsername().equals(username))
            {
               
                if (user.getPassword().equals(password))
                {
                    
                    loggedInUser = user;
                    if (loggedInUser == listOfCustomers[4]){
                    admin = true;
                    }

                    // when a user is found, "break" stops iterating through the list
                    break;
                }
            }
        }
     }catch(Exception e){
     System.out.println("Password did not match, try again.");
     }


         // if loggedInUser was changed from null, it was successful
        if (loggedInUser != null)
        {
            System.out.println("User successfully logged in: "+loggedInUser.getUsername());
            log1.log("Succesfuly logged in.");
       }
        
        else
        {
            System.out.println("Invalid username or password");
            log1.log("Invalid username or password");
            main(new String[0]);
        }

     
      
      System.out.println();
      System.out.println("Hello " + loggedInUser.getUsername() + "\n");
      menuPrompt();
      if(admin){
      System.out.println("6: Check statistics (admin only)");
      System.out.println("8: Check Credit card");
      // Hahaa, earnings from "Little Animal Horror Zoo" ;)
      loggedInUser.setCreditCard(9567926);
      }
      


      
     
      do 
      {
                                   // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
      choice = input.nextInt();
         switch(choice)
         {
         
         case 1:
         System.out.println("Please choose a Wash");
         menuPrompt2();
      

        // anti User, således at User ikke ødelægger vores code ....
        while (!input.hasNextInt()) {
        input.next();
        System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
        log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
            do 
            {
                                         // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
              choice = input.nextInt();
              switch(choice)
              {

                  
                  case 1:
                  menuPromptYes();
                  while(choice!=5000){
                             // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                       choice = input.nextInt();
                       switch(choice) {
                       
                       
                           case 1:
                            loggedInUser.wash3();
                            totalSpend += 100;
                            washBad++;
                            carsWashed++;
                               
                               if(loggedInUser.getChanged() !=1){
                                loggedInUser.setChanged();
                                menuPromptReceipt();
                                                             // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                                 choice = input.nextInt();
                                 switch(choice) {
                             
                                
                                 case 1: 
                                 System.out.println("Receipt of purchase:\n1x Gustav special \"bad wash\"\nPrice: 100 dkk.\n");
                                 log1.log(loggedInUser.getUsername()+" Printed out a Receipt");
                                 break;
                             
                                 case 2:
                                 log1.log(loggedInUser.getUsername()+" did not print a receipt.");
                                 break;
                                 
                                 default:
                                 System.out.println("Wrong Input... again");
                                 
                                 break;
                                }}
                                      menuClose();
                                      while(choice!=5001){
                                                                   // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                                      choice = input.nextInt();
                                      switch(choice) {
                                    
                                       case 1: 
                                       System.out.println("Please choice a wash");
                                       choice = 5001;
                                       break;
                                   
                                       case 2:
                                        System.out.println("Have a nice day " + loggedInUser.getUsername());
                                        log1.log(loggedInUser.getUsername()+" logged out");
                 
                                        averageSpend = (totalSpend/carsWashed);
              
                                        g.openFile();
                                        g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
                                        g.closeFile();
                                        System.exit(0);
                                       break;
                                    
                                       default:
                                       System.out.println("Are you serious... WRONG INPUT "+loggedInUser.getUsername());
                                       break;
                                 }}

                           menuPrompt2();
                           choice=5000;
                           break;
                        
                           case 2:
                           menuPrompt2();
                           choice=5000;
                           break;
                           
                           default:
                           System.out.println("WRONG!!!");
                           menuPromptYes();
                           break;
                       }}
                  break; 
      
                  case 2:
                  menuPromptYes();
                       while(choice!=5000){
                             // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                       choice = input.nextInt();
                       switch(choice) {
                       
                           case 1:
                            loggedInUser.wash2();
                            totalSpend += 200;
                            washGood++;
                            carsWashed++;

                               if(loggedInUser.getChanged() !=1){
                                loggedInUser.setChanged();
                                
                                menuPromptReceipt();
                                                             // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                                   choice = input.nextInt();
                                   switch(choice) {
                             
                                   //MISSING RECEIPT!!!
                                   case 1: 
                                   System.out.println("Receipt of purchase:\n1x Gustav special \"good wash\"\nPrice: 200 dkk.\n");
                                   log1.log(loggedInUser.getUsername()+" Printed out a Receipt");
                                   break;
                             
                                   case 2:
                                   log1.log(loggedInUser.getUsername()+" Did not print out a Receipt");
                                   break;
                                   }}
                                      menuClose();
                                      while(choice!=5001){
                                                                   // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                                      choice = input.nextInt();
                                      switch(choice) {
                                    
                                       case 1: 
                                       System.out.println("Please choice a wash");
                                       choice = 5001;
                                       break;
                                   
                                       case 2:
                                        System.out.println("Have a nice day " + loggedInUser.getUsername());
                                        log1.log(loggedInUser.getUsername()+" logged out");
                 
                                        averageSpend = (totalSpend/carsWashed);
              
                                        g.openFile();
                                        g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
                                        g.closeFile();
                                        System.exit(0);
                                       break;
                                    
                                       default:
                                       System.out.println("Are you serious... WRONG INPUT "+loggedInUser.getUsername());
                                       break;
                                   }}

                           menuPrompt2();
                           choice=5000;
                           break;
                        
                           case 2:
                           menuPrompt2();
                           choice=5000;
                           break;
                           
                           default:
                           System.out.println("Wrong input");
                           menuPromptYes();
                           break;
                       }}                 
                  break;
      
                  case 3:
                  menuPromptYes();
                       while(choice!=5000){
                             // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                       choice = input.nextInt();
                       switch(choice) {
                       
                           case 1:
                              loggedInUser.wash1();
                              totalSpend += 300;
                              washSuper++;
                              carsWashed++;
                               
                               if(loggedInUser.getChanged() !=1){
                                loggedInUser.setChanged();
                                
                                menuPromptReceipt();
                              // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                                   choice = input.nextInt();
                                   switch(choice) {
                             
                                   
                                   case 1: 
                                   System.out.println("*****Receipt of purchase*****\nType of wash: Gustav special - \"Super wash\nPurchased "+date+" \nPrice: 300 dkk.\n");
                                   log1.log(loggedInUser.getUsername()+" Printed out a Receipt");
                                   break;
                             
                                   case 2:
                                   log1.log(loggedInUser.getUsername()+" Did not print out a Receipt");
                                   break;
                                   }}
                                      menuClose();
                                      while(choice!=5001){
                                                                   // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
                                      choice = input.nextInt();
                                      switch(choice) {
                                    
                                       case 1: 
                                       System.out.println("Please choice a wash");
                                       choice = 5001;
                                       break;
                                   
                                       case 2:
                                        System.out.println("Have a nice day " + loggedInUser.getUsername());
                                        log1.log(loggedInUser.getUsername()+" logged out");
                 
                                        averageSpend = (totalSpend/carsWashed);
              
                                        g.openFile();
                                        g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
                                        g.closeFile();
                                        System.exit(0);
                                       break;
                                    
                                       default:
                                       System.out.println("Are you serious... WRONG INPUT "+loggedInUser.getUsername());
                                       break;
                                  }}
                                   
                           menuPrompt2();
                           choice=5000;
                           break;
                        
                           case 2:
                           choice=5000;
                           break;
                           
                           default:
                           System.out.println("Wrong input");
                       }}
                  break;
      
                  case 4:
                  System.out.println("Your cars dirtyness is " +loggedInUser.customerCar.getDirt()+ ".");
                  log1.log(loggedInUser.getUsername()+ " Analyzed the cars dirtyness");
               
                   if(loggedInUser.customerCar.getDirt()>=170){
                      System.out.println("Your car is very dirty..");
                      System.out.println("We recommend: \"Wash Super\"\n");
                      menuPrompt2();
                     } else if(loggedInUser.customerCar.getDirt()>100 && loggedInUser.customerCar.getDirt()<170){
                      System.out.println("Your car is dirty..");
                      System.out.println("We recommend: \"Wash Super\"\n");
                      menuPrompt2();
                     } else if(loggedInUser.customerCar.getDirt()>50 && loggedInUser.customerCar.getDirt()<=100){
                      System.out.println("Your car a little dirty..");
                      System.out.println("We recommend: \"Wash Normal\"\n");
                      menuPrompt2();
                     } else if(loggedInUser.customerCar.getDirt()<=50){
                      System.out.println("WTF are you doing here... Your car is pretty much clean!");
                      System.out.println("We recommend: \"Wash bad\"\n");
                      menuPrompt2();
                      }
                  break;
                  
                  case 5:
                  menuPrompt();
                  break;
      
                  
                  case 0:
                  System.out.println("Have a nice day " + loggedInUser.getUsername());
                  log1.log(loggedInUser.getUsername()+" logged out");
                 
                  averageSpend = (totalSpend/carsWashed);
              
                  g.openFile();
                  g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
                  g.closeFile();
                  System.exit(0);
                  break;
      
                  default:
                  System.out.println(loggedInUser.getUsername() + "...");
                  log1.log(loggedInUser.getUsername()+" did something wrong.");
                  break;
      
                  }
   
                  }while(choice !=5); 
                   break;
      
      

     

         case 2:
         if (loggedInUser.getWashcard()>=1000){
         System.out.println("You are not allowed to have more than a 1000dkk on your WashCard*");
         log1.log(loggedInUser.getUsername()+ " tried to deposit more than 1000dkk... Stupid banks roles");
         }else{
         System.out.println("How much would you like to deposit?");
         
                                      // anti User, således at User ikke ødelægger vores code ....
                             while (!input.hasNextInt()) {
                             input.next();
                             System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
                             log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
         double money = input.nextDouble();
         if (money <=199 || money>=1001){
         System.out.println("You are not allowed to deposit less than 200dkk or more than 1000dkk");
         }else{ loggedInUser.depositWashCard(money);
         }}
         menuPrompt();         
         break;
               
         case 3:
         loggedInUser.checkBalance();
         menuPrompt();
         break; 
         
         case 4:
         loggedInUser.createWashCard();
         menuPrompt();   
         break;           
         
         case 5:
         System.out.println("Goodbye "+loggedInUser.getUsername());
         log1.log(loggedInUser.getUsername()+" logged out.");
         
         averageSpend = (totalSpend/carsWashed);
       
         g.openFile();
         g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
         g.closeFile();
         main(new String[0]);
         menuPromptStart();
         break;         
                           
         case 6: 
         if (admin) {
         y.openFile();
         y.readFile();
         y.closeFile();     
         } else {
         System.out.println("This is an admin only feature.\n");
         log1.log(loggedInUser.getUsername()+" attempted to acces admin functions.");       
         }
         menuPrompt();
         break;
         
         case 8:
         
         log1.log(loggedInUser.getUsername()+ " Checked their bank account on a wash maschine... How? O_O");
         System.out.println("You have " +loggedInUser.getCreditCard()+ " on your credit card");
         break;
               
         case 0:
         
        
         averageSpend = (totalSpend/carsWashed);
      
         g.openFile();
         g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
         g.closeFile();
         System.exit(0);
         break;
      
         default:
         System.out.println(loggedInUser.getUsername() + "...");
         break;
         
         }
      }while(choice !=1);
 
      }
      
      
       private static void menuPrompt()
   {
      System.out.println("1: Wash Car");
      System.out.println("2: Deposit Money");
      System.out.println("3: Check balance");
      System.out.println("4: Create Washcard");
      System.out.println("5: Log out");
      System.out.println();
      System.out.println("0: Exit");
      
   }
      
      private static void menuPrompt2()
   {
      System.out.println("1: Wash Bad - 100.00 dkk.");
      System.out.println("2: Wash Normal - 200.00 dkk.");
      System.out.println("3: Wash Super - 300.00 dkk.");
      System.out.println("4: \"New feature\" Analyze yours cars dirtyness");
      System.out.println();
      System.out.println("5: Back");
      System.out.println("0: Exit");
   }
      
      private static void menuPromptStart()
   {
      System.out.println("1: Login");
      System.out.println("2: Create Account");
      System.out.println();
      System.out.println("0: Exit");
   }
   
   
      private static void menuPromptYes()
   {
      System.out.println("Are you sure?");
      System.out.println("1: Yes");
      System.out.println("2: No");
   }
      
      private static void menuPromptReceipt()
   {
      System.out.println("Want a Receipt?");
      System.out.println("1: Yes");
      System.out.println("2: No");
   }
   
      private static void menuClose()
   {   
     System.out.println("Want to continue Washing");
     System.out.println("1: Yes");
     System.out.println("2: No");
   }
}