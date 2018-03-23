import java.io.*;
import java.util.*;

public class CarWash{   
   public static void main(String[]args)throws IOException{
   Logger log1 = new Logger("Carwash_log.txt");
   // log1.log("hvad skal der logges?");
   Customer claus = new Customer();
   claus.createWashCard();
   claus.depositWashCard(500.00);

        String username;
        String password;


        // Used to hold the instance of a user who successfully logged in
        User loggedInUser = null;

        // Create an empty list to hold users
        List<User> listOfUsers = new ArrayList<>();

        // Add 6 users to the list
        listOfUsers.add(new User("Thomas","1234"));
        listOfUsers.add(new User("Anders","7894"));
        listOfUsers.add(new User("Jonathan","1337"));
        listOfUsers.add(new User("Gustav","3396"));
        listOfUsers.add(new User("Admin","1"));
        

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
         
         // not done. missing payment and receipt
         while (choice !=5000){
         System.out.println("To Create an account you most type a username and a password\n");
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
         listOfUsers.add(new User(Username,Password));
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
        for (User user : listOfUsers)
        {
        
            if (user.getUsername().equals(username))
            {
               
                if (user.getPassword().equals(password))
                {
                    loggedInUser = user;

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
         System.out.println("doing");
         break;
         
         case 3:
         System.out.println("work in progrees");
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
      claus.wash3();
      break;
      
      case 2:
      claus.wash2();
      break;
      
      case 3:
      claus.wash1();
      break;
      
      
      case 0:
      System.out.println("Have a nice day " + loggedInUser.getUsername());
      log1.log(loggedInUser.getUsername()+" logged out");
      System.exit(0);
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
      System.out.println("3: view Static");
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