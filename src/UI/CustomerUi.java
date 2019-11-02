package UI;

import java.util.Scanner;

/**
 * modifier package-private
 */
class CustomerUi implements ConsoleBasedInterface{

    @Override
    public void show() {
        //MovieController movieController = new MovieController();
        //CineplexController cineplexController = new CineplexController();
        //TransactionController transController = new TransactionController();

        MoblimaApp application = new MoblimaApp();
        //Movie movieUserChoice = null;
        Scanner sc = new Scanner(System.in);

        int userChoice = 0;
        do {
            System.out.println("====================== Menu++++ =======================");
            System.out.println("|1. Show me some Movies!                              |");
            System.out.println("|2. Search Movies!                                    |");
            System.out.println("|3. Buy Tickets                                       |");
            System.out.println("|4. View my Booking History                           |");
            System.out.println("|5. Rate and Review                                   |");
            System.out.println("|6. List Top 5 ranking by ticket sales                |");
            System.out.println("|7. List Top 5 movies by overall reviewer's ratings   |");
            System.out.println("|8. Back                                              |");
            System.out.println("|9. Quit                                              |");
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

        } while (userChoice != 8);

    }

}
