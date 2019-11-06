package UI;

//import controller.StaffController;

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

    public StaffUi(){
        this.movieController = new MovieController();
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
            System.out.println("| 2.  Setting for All Cineplex                        |");
            System.out.println("| 3.  Setting for individual Cineplex                 |");
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
        System.out.println("Please enter the Movie Title:");
        movieTitle = sc.next();
        System.out.println("Please enter the Movie Status [Coming Soon, Preview, Now Showing]:");
        movieStatus = sc.next();
        System.out.println("Please enter the Movie Synopsis:");
        movieSynopsis = sc.next();
        System.out.println("Please enter the Movie Director:");
        movieDirector = sc.next();
        System.out.println("Please enter the Movie Cast(s) (Split by comma):");
        movieCast = sc.next();
        System.out.println("Please enter the Movie Rating [PG13, NC16, M18, R21]:");
        movieRating = sc.next();
        System.out.println("Please enter the movie duration: (in mins)");
        movieDuration = sc.next() + " mins";
        System.out.println("Please enter the movie type: [2D, 3D]");
        movieType = sc.next();

        do{
            System.out.println("Do you wish to enter additional reviews? (Y/N)");
            if(sc.next().equalsIgnoreCase("Y")){
                System.out.println("Enter your rating, (1-5):");
                int userRating = sc.nextInt();
                System.out.println("Enter your review!:");
                String userReview = sc.next();

                movieReviews.add(new Review(userReview, userRating));
            }
            else{
                break;
            }
        } while(sc.next().equalsIgnoreCase("Y"));

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


        if(movieController.addNewMovie(movie) == true ){
            System.out.println("\n" + "New Movie has been successfully created!");
        }
        else{
            System.out.println("\n" + "Sorry, something went wrong! :(");
        }
        System.out.println("==================== Add New Movie ====================");
    }

    public void removeExistingMovie(){
        System.out.println("Please enter the ");
    }

    /**
     * UI display for "Setting for Individual Cineplex"
     * Allows Staff to
     */
    public void showSettingForIndividualCineplex(){

    }

}
