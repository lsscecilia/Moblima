package UI;

//import controller.StaffController;

import java.util.Scanner;

/**
 * modifier package-private
 */
class StaffUi implements ConsoleBasedInterface {

    @Override
    public void show() {
        //StaffController staffController = new StaffController();
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("======================== STAFF ========================");
            System.out.println("|1.  Cineplexes                                       |");
            System.out.println("|2.  Cinemas                                          |");
            System.out.println("|3.  Movies                                           |");
            System.out.println("|4.  Show Times                                       |");
            System.out.println("|5.  Prices                                           |");
            System.out.println("|6.  Holidays                                         |");
            System.out.println("|7.  List Top 5 ranking by ticket sales               |");
            System.out.println("|8.  List Top 5 movies by overall reviewer's ratings  |");
            System.out.println("|9.  Back                                             |");
            System.out.println("|10. Quit                                             |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
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

                    break;
                case 9:
                    break;
                case 10:
                    sc.close();
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (choice != 9);
    }

}
