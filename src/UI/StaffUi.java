package UI;

//import controller.StaffController;

import Controller.ControllerInterface;
import Controller.DisplayController;

import java.util.Scanner;

/**
 * modifier package-private
 */
class StaffUi implements ConsoleBasedInterface {

    @Override
    public void show() {
        ControllerInterface displayController = new DisplayController();
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("======================== STAFF ========================");
            System.out.println("| 1.  View All Cineplex                               |");
            System.out.println("| 2.  Setting for individual Cineplex                 |");
            System.out.println("| 3.  Setting for All Cineplex                        |");
            System.out.println("| 4.  Configure System Setting                        |");
            System.out.println("| 5.  Back                                            |");
            System.out.println("| 6.  Quit                                            |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:
                    ((DisplayController) displayController).viewAllCineplex();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    //Back
                    break;
                case 6:
                    sc.close();
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (choice != 5);
    }

}
