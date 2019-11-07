package UI;

//import controller.StaffController;

import Controller.CineplexController;
import Controller.MovieController;
import Entity.Movie;
import Entity.Review;
import Entity.Staff;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * modifier package-private
 */
class StaffUi implements ConsoleBasedInterface {
    private MovieController movieController;
    //private CineplexController cineplexController;

    public StaffUi(){
        this.movieController = new MovieController();
        //this.cineplexController = new CineplexController();
    }

    /**
     * Allows the Staff to choose the different options
     */
    @Override
    public void show() {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("======================== STAFF ========================");
            System.out.println("| 1.  View All Cineplex                               |");
            System.out.println("| 2.  All Cineplex                                    |");
            System.out.println("| 3.  Individual Cineplex                             |");
            System.out.println("| 4.  Configure System Setting                        |");
            System.out.println("| 5.  Back                                            |");
            System.out.println("| 6.  Quit                                            |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:

                    break;
                case 2:
                    showSettingForAllCineplex();
                    break;
                case 3:
                    showSettingForIndividualCineplex();
                    break;
                case 4:
                    showSettingForSystemSetting();
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


    // -------------------------------------------------------OPTION 1:View All Cineplex-------------------------------------------------------

    // -------------------------------------------------------OPTION 1:View All Cineplex-------------------------------------------------------


    // -------------------------------------------------------OPTION 2:Setting for All Cineplex-------------------------------------------------------
    /**
     * UI display for "Setting for all Cineplex"
     * Allows Staff to Add new movie, Remove existing movie, Update existing movie detail
     */
    public void showSettingForAllCineplex(){
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("=============== Setting for All Cineplex ==============");
            System.out.println("| 1.  Add new movie                                   |");
            System.out.println("| 2.  Remove existing movie                           |");
            System.out.println("| 3.  Update existing movie detail                    |");
            System.out.println("| 4.  Back                                            |");
            System.out.println("| 5.  Quit                                            |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:
                    addNewMovie();
                    break;
                case 2:
                    removeExistingMovie();
                    break;
                case 3:
                    updateExistingMovieDetail();
                    break;
                case 4:
                    //back
                    break;
                case 5:
                    sc.close();
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (choice != 4);
    }

    /**
     * Allows user to input new movie and it's details!
     */
    public void addNewMovie(){
        Scanner sc = new Scanner(System.in);

        int movieId;
        String movieTitle;
        String movieStatus;
        String movieSynopsis;
        String movieDirector;
        String movieCast;
        String movieRating;
        String movieDuration;
        String movieType;
        ArrayList<Review> movieReviews = new ArrayList<>();

        System.out.println("==================== Add New Movie ====================");
        System.out.println("Please enter the Movie ID (Integer):");
        movieId = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the Movie Title:");
        movieTitle = sc.nextLine();
        System.out.println("Please enter the Movie Status (Coming Soon, Preview, Now Showing):");
        movieStatus = sc.nextLine();
        System.out.println("Please enter the Movie Synopsis:");
        movieSynopsis = sc.nextLine();
        System.out.println("Please enter the Movie Director:");
        movieDirector = sc.nextLine();
        System.out.println("Please enter the Movie Cast(s) (Split by comma):");
        movieCast = sc.nextLine();
        System.out.println("Please enter the Movie Rating [PG13, NC16, M18, R21]:");
        movieRating = sc.nextLine();
        System.out.println("Please enter the movie duration: (in mins)");
        movieDuration = sc.nextLine();
        System.out.println("Please enter the movie type: (2D, 3D)");
        movieType = sc.next();

         while(true){
             System.out.println("Do you wish to enter additional reviews? (Y/N)");
             if(sc.next().equalsIgnoreCase("Y")){
                 System.out.println("Enter your rating, (1-5):");
                 int userRating = sc.nextInt();
                 sc.nextLine();
                 System.out.println("Enter your review!:");
                 String userReview = sc.nextLine();

                 movieReviews.add(new Review(userReview, userRating));
             }
             else{
                 break;
             }
         }

        Movie movie = new Movie(movieId
                               , movieTitle
                               , movieStatus
                               , movieSynopsis
                               , movieDirector
                               , movieCast
                               , movieRating
                               , movieDuration
                               , movieType
                               , movieReviews);


        if(movieController.addNewMovie(movie)){
            System.out.println("\n" + "New Movie has been successfully created!");
        }
        else{
            System.out.println("\n" + "Sorry, something went wrong! :(");
        }
        System.out.println("========================================================" + "\n");
    }

    /**
     * Allows Staff Admin to remove Movie based on MovieID or MovieTitle.
     */
    public void removeExistingMovie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================ Remove Existing Movie ================");
        System.out.println("These are the following Movies Available: " + "\n");
        if(!movieController.isEmpty()){
            movieController.viewAllMovie();
            System.out.println("\n" + "Please enter the movie ID that you wish to delete! (Enter 0 to cancel)");
            int userChoice = sc.nextInt();
            if(userChoice != 0){
                if(movieController.removeMovieById(userChoice)){
                    System.out.println("The movie has been successfully removed!");
                }
                else{
                    System.out.println("Sorry, something went wrong! :(");
                }
            }
            else{
                System.out.println("You have chosen to exit!");
            }
            System.out.println("========================================================" + "\n");
        }
        else{
            System.out.println("There is no movie available! :( Please add new movies!" + "\n");
        }
    }

    /**
     * Allows staff to update existing movie details
     */
    public void updateExistingMovieDetail(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================ Update Existing Movie ================");
        movieController.viewAllMovie();
        System.out.println("Which Movie would you like to update? (Enter 0 to cancel)");
        int chosenMovieId = sc.nextInt();
        sc.nextLine();
        System.out.println("Which portion would you like to update? (Enter 0 to cancel)");
        System.out.println("1. Movie ID");
        System.out.println("2. Movie Title");
        System.out.println("3. Movie Status");
        System.out.println("4. Movie Synopsis");
        System.out.println("5. Movie Director");
        System.out.println("6. Movie Cast");
        System.out.println("7. Movie Rating");
        System.out.println("8. Movie Duration");
        System.out.println("9. Movie Type");
        int chosenIndex = sc.nextInt();
        sc.nextLine();

        if(chosenMovieId != 0 && chosenIndex != 0){
            System.out.println("You are changing: ");
            movieController.printIndex(chosenMovieId, chosenIndex);
            System.out.println("To: ");
            String changedString = sc.nextLine();
            movieController.updateExistingMovieDetail(chosenMovieId, chosenIndex, changedString);
            System.out.println("You have successfully updated Movie ID " + chosenMovieId + "!");
        }
        else{
            System.out.println("You have chosen to exit!");
        }
        System.out.println("========================================================" + "\n");
    }
    // -------------------------------------------------------OPTION 2:Setting for All Cineplex-------------------------------------------------------


    // -------------------------------------------------------OPTION 3:Setting for individual Cineplex-------------------------------------------------------
    /**
     * UI display for "Setting for Individual Cineplex"
     * Allows Staff to
     */
    public void showSettingForIndividualCineplex() {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("=========== Setting For Individual Cineplex ===========");
            System.out.println("| 1.                               |");
            System.out.println("| 2.  All Cineplex                                    |");
            System.out.println("| 3.  Individual Cineplex                             |");
            System.out.println("| 4.  Configure System Setting                        |");
            System.out.println("| 5.  Back                                            |");
            System.out.println("| 6.  Quit                                            |");
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
    // -------------------------------------------------------OPTION 3:Setting for individual Cineplex-------------------------------------------------------

    // -------------------------------------------------------OPTION 4:Configure System Setting-------------------------------------------------------
    public void showSettingForSystemSetting(){

    }
    // -------------------------------------------------------OPTION 4:Configure System Setting-------------------------------------------------------
}
