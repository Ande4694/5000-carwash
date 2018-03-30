import java.io.*;
import java.util.*;

public class CarWash{   
   public static void main(String[]args)throws IOException{
   Logger log1 = new Logger("Carwash_log.txt");
   CreateFile g = new CreateFile();
   ReadFromFile y = new ReadFromFile();
   
        String username;
        String password;
        int totalSpend = 0;
        int washBad = 0;
        int washGood = 0;
        int washSuper = 0;
        int carsWashed = 0;
        int averageSpend = 0;
        

    


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
         choice = 5000;
         }
         else{
         System.out.println("Password did not match, try again.");
         log1.log(Username+" entered wrong password");
          }
         listOfCustomers[5] = new Customer(Username,Password);
         }
         
         
         System.out.println("Account created!\n");
         log1.log("New user created");
         menuPromptStart();
         break;
         
         case 0:
         System.out.println("Have nice day!");
         log1.log("User exited system");
         averageSpend = (totalSpend/carsWashed);
         g.openFile();
         g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
         g.closeFile();
         System.exit(0);
         break;

         }
         }while(choice !=1);
         
         

        
        
        
        
        
        System.out.println("Please type your Username* :");
        username = br.readLine();   
        System.out.println("Please type your pin code :");
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
      }
      

        // anti User, således at User ikke ødelægger vores code ....
        while (!input.hasNextInt()) {
        input.next();
        System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
        log1.log(loggedInUser.getUsername()+" did something wrong.");
        }
      
      do 
      {
      choice = input.nextInt();
         switch(choice)
         {
         
         case 1:
         System.out.println("Please choose a Wash");
         menuPrompt2();
      

            do 
            {
              choice = input.nextInt();
              switch(choice)
              {

                  case 1:
                  menuPromptYes();
                       while (choice !=5000){
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
                                while (choice !=5001){
                                choice = input.nextInt();
                                switch(choice) {
                             
                                //MISSING RECEIPT!!!
                                case 1: 
                                System.out.println("printing...\nSorry out off papper\n");
                                choice = 5001;
                                break;
                             
                                case 2:
                                choice = 5001;
                                break;
                                
                                
                                }}
                                }

                           menuPrompt2();
                           choice = 5000;
                           break;
                        
                           case 2:
                           menuPrompt2();
                           choice = 5000;
                           break;
                       }}
                  break; 
      
                  case 2:
                  menuPromptYes();
                       while (choice !=5000){
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
                                  while (choice !=5001){
                                   choice = input.nextInt();
                                   switch(choice) {
                             
                                   //MISSING RECEIPT!!!
                                   case 1: 
                                   System.out.println("printing...\nSorry out off paper\n");
                                   choice = 5001;
                                   break;
                             
                                   case 2:
                                   choice = 5001;
                                   break;
                                   }}
                                   }

                           menuPrompt2();
                           choice = 5000;
                           break;
                        
                           case 2:
                           menuPrompt2();
                           choice = 5000;
                           break;
                       }}                  
                  break;
      
                  case 3:
                  menuPromptYes();
                       while (choice !=5000){
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
                                  while (choice !=5001){
                                   choice = input.nextInt();
                                   switch(choice) {
                             
                                   //MISSING RECEIPT!!!
                                   case 1: 
                                   System.out.println("printing...\nSorry out off paper\n");
                                   choice = 5001;
                                   break;
                             
                                   case 2:
                                   choice = 5001;
                                   break;
                                   }}
                                   }

                           menuPrompt2();
                           choice = 5000;
                           break;
                        
                           case 2:
                           menuPrompt2();
                           choice = 5000;
                           break;
                       }}
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
         System.out.println("How much would you like to deposit?");
         loggedInUser.depositWashCard(input.nextDouble());
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
         //"averageSpend" virker kun hvis man har købt noget ellers crahser systemet, så måske en if statement?
         averageSpend = (totalSpend/carsWashed);
         g.openFile();
         g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
         g.closeFile();
         //Hvorfor "System.exit(0)"? Skal man ikke tilbage til hovedmenuen...
         System.exit(0);
         main(new String[0]);
         menuPromptStart();
         break;         
                           
         case 6: ///// STATs
         //// READ FROM FILE!!! FOR PERMANENT HUKOMELSE
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
               
         case 0:
         System.exit(0);
         averageSpend = (totalSpend/carsWashed);
         g.openFile();
         g.addRecords(totalSpend, washBad, washGood, washSuper, carsWashed, averageSpend);
         g.closeFile();
         break;
      
         default:
         System.out.println(loggedInUser.getUsername() + "...");
         break;
         
         }
      }while(choice !=1);
      

        // anti User, således at User ikke ødelægger vores code ....
        while (!input.hasNextInt()) {
        input.next();
        System.out.println("Not an integer; try again.\nNice try " + loggedInUser.getUsername() + "...");
        log1.log(loggedInUser.getUsername()+" did something wrong.");
        }

      
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
      
}