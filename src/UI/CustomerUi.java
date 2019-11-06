package UI;

import java.util.Scanner;

/**
 * modifier package-private
 */
class CustomerUi implements ConsoleBasedInterface{
    public Scanner sc = new Scanner(System.in);

    @Override
    public void show() {
        //MovieController movieController = new MovieController();
        //CineplexController cineplexController = new CineplexController();
        //TransactionController transController = new TransactionController();

        MoblimaApp application = new MoblimaApp();
        //Movie movieUserChoice = null;


        int userChoice = 0;
        do {
            System.out.println("====================== Menu++++ =======================");
            System.out.println("|1. Show me some Movies!                              |");
            System.out.println("|2. Search Movies!                                    |");
            System.out.println("|3. Show me some Cinplex!                             |");
            System.out.println("|4. Search Cinplex!                                   |");
            System.out.println("|5. Buy Tickets                                       |");
            System.out.println("|6. View my Booking History                           |");
            System.out.println("|7. Rate and Review                                   |");
            System.out.println("|8. Click here if you need movie recommendation       |");
            System.out.println("|9. Back                                              |");
            System.out.println("|10. Quit                                             |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    showOption1();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    MoblimaApp.main(null);
                    break;
                case 9:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 9);

    }

    public void showOption1()
    {
        //display list of movie
        //movieArrayList passed
        int userChoice = 0;
        do {
            System.out.println("====================== Option =========================");
            System.out.println("|1. Select movie for more details                     |");
            System.out.println("|2. Back                                              |");
            System.out.println("|3. Quit                                              |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    //take input from user
                    //show find movie
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 3 );
    }

    public void showOption2()
    {
        System.out.println("Enter movie to search: ");
        String search = sc.nextLine();
        //search
        //display result (may be a list of movie) --> rmb nid to show movie status too!! if not user hav no idea
        int userChoice = 0;
        do {
            System.out.println("====================== Option =========================");
            System.out.println("|1. Select movie for more details                     |");
            System.out.println("|2. Back                                              |");
            System.out.println("|3. Quit                                              |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    //take input from user
                    //show find movie
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 3 );
    }

    public void showOption3(){} //similar to showOption1, just that now its for cineplex

    public void showOption4(){} //similar to showOption2, just that now its for cineplex

    public void option5() //buy tickets
    {
        //display list of movie
        //ask which movie u want to watch?
        //get user input
        //display showtime from that list according to cineplex
        //choose showtime
        //choose num of seats
        // type of ticket for each seats (if day = weekday and time < 6pm** check for this tho and must put default)
        // choose seats
        // pass showtime, numSeats, seats, customerClass(arraylist for this) into makeBooking()
        // retreive buyers details (name, email, num etc etc)
        // confirmation display & payment
        // once confirm, add to transactions, update seat layout in showtime
    }

    public void option6() //view booking history
    {
        //in transaction, find using user's phone num or smth
        //but for here because its a single user, can just print transaction history
    }

    public void option7() //rate and review --> only for movies that they watch
    {
        //find history --> how to ensure that user only review and rate once? hav a counter or smth isit --> means nid to store data?
        //rate movie OR write review for that movie
    }

    public void option8()
    {
        //list top5 ranking by ticket sales
        //list top5 ranking by overall reviewer's rating
    }
}
