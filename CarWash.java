import java.io.*;
import java.util.*;

public class CarWash{   
   public static void main(String[]args)throws IOException{
   Logger log1 = new Logger("Carwash_log.txt");
   // log1.log("hvad skal der logges?");


        String username;
        String password;
        int totalSpend = 1;
        int washBad = 1;
        int washGood = 1;
        int washSuper = 1;
        int carsWashed = (washBad + washGood + washSuper);
        int averageSpend = (totalSpend / carsWashed);



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
        log1.log("User entered wrong input");
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
         loggedInUser = null;
         choice = 0;/////// HVORDAN KOMEMR JEG TILBAGE TIL FØRSTE LOOP==!=!!?!=!=
         menuPromptStart();
         break;         
                           
         case 6: ///// STATs
         //// READ FROM FILE!!! FOR PERMANENT HUKOMELSE
         if (admin) {
         System.out.println("Cars washed this session: \t\t\t"+(carsWashed-3));
         System.out.println("Total spend this session: \t\t\t"+(totalSpend-1));
         System.out.println("Bad washes this session: \t\t\t"+(washBad-1));
         System.out.println("Good washes this session: \t\t\t"+(washGood-1));
         System.out.println("Super washes this session: \t\t"+(washSuper-1));
         System.out.println("Average spend this session: \t\t"+averageSpend);      
         } else {
         System.out.println("This is an admin only feature.\n");
         log1.log(loggedInUser.getUsername()+" attempted to acces admin functions.");       
         }
         menuPrompt();
         break;
               
         case 0:
         System.exit(0);
         break;
      
         default:
         System.out.println(loggedInUser.getUsername() + "...");
         break;
         
         }
      }while(choice !=1);
      
      menuPrompt2();

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
      loggedInUser.wash3();
      totalSpend += 100;
      washBad++;
      menuPrompt();
      break;
      
      case 2:
      loggedInUser.wash2();
      totalSpend += 200;
      washGood++;
      menuPrompt();
      break;
      
      case 3:
      loggedInUser.wash1();
      totalSpend += 300;
      washSuper++;
      menuPrompt();
      break;
      
      
      case 0:
      System.out.println("Have a nice day " + loggedInUser.getUsername());
      log1.log(loggedInUser.getUsername()+" logged out");
      loggedInUser = null ;
      break;
      
      default:
      System.out.println(loggedInUser.getUsername() + "...");
      log1.log(loggedInUser.getUsername()+" did something wrong.");
      break;
      
      }
   
      }while(choice !=0);
               
      
    

      
      
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
      System.out.println("1: Wash Bad");
      System.out.println("2: Wash Normal");
      System.out.println("3: Wash Super");
      System.out.println();
      System.out.println("0: Exit");
   }
      
      private static void menuPromptStart()
   {
      System.out.println("1: Login");
      System.out.println("2: Create Account");
      System.out.println();
      System.out.println("0: Exit");
   }
      
}