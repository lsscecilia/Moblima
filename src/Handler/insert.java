package Handler;

import Entity.*;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class insert {
    public static void main(String[] args)
    {

/*
        LocalDateTime localDateTime = LocalDateTime.of(2020,01,03,10,00);
        System.out.println(localDateTime.toLocalDate().toString());

        String newString = "2020-04-05";
        String newnewString = (newString+"-"+localDateTime.toLocalTime().toString().replace(":","-")).replace("-",",");
        System.out.println(newnewString);
        int[] time = Stream.of((newnewString).split(",")).mapToInt(Integer::parseInt).toArray();
        localDateTime = LocalDateTime.of(time[0],time[1],time[2],time[3],time[4]);

        System.out.println("new"+ localDateTime.toLocalDate()+localDateTime.toLocalTime());


         */
        /*
        HandlerInterface database = new DataHandler();
        ArrayList<ShowTime> showTimeArrayList = new ArrayList<>();
        showTimeArrayList = database.readSerializedObject("ShowTime");
        for(ShowTime showTime: showTimeArrayList){
            System.out.println(showTime.getCineplex().getCineplexName() + " | " + showTime.getCinemaID() + " | " + showTime.getDateTime());
        }

         */

        //cineplex
        //    private int cineplexID;
        //    private String cineplexName;
        //    private String location;
        //    private ArrayList<Cinema> cinemaArrayList;
        //    private ArrayList<Movie> movieInCineplexArrayList;

        //create show time
        //    private Cineplex cineplex;
        //    private Movie movie;
        //    private int cinemaID;
        //    private int column;
        //    private int row;
        //    private LocalDateTime dateTime;
        //    private int[][] seatLayout;

        /*
        //format to insert showTime
        LocalDateTime dateTime[] = new LocalDateTime[15];
        //Friday to test the timing shit because thr is 2 cost for friday
        dateTime[0] = LocalDateTime.of(2020,01,03,10,00);
        dateTime[1] = LocalDateTime.of(2020,01,03,13,00);
        dateTime[2] = LocalDateTime.of(2020,01,03,16,00);
        dateTime[3] = LocalDateTime.of(2020,01,03,19,00);
        dateTime[4] = LocalDateTime.of(2020,01,03,22,00);
        //public hols
        dateTime[5] = LocalDateTime.of(2020,01,01,10,00);
        dateTime[6] = LocalDateTime.of(2020,01,01,13,00);
        dateTime[7] = LocalDateTime.of(2020,01,01,16,00);
        dateTime[8] = LocalDateTime.of(2020,01,01,19,00);
        dateTime[9] = LocalDateTime.of(2020,01,01,22,00);
        //weekend
        dateTime[10] = LocalDateTime.of(2020,01,04,10,00);
        dateTime[11] = LocalDateTime.of(2020,01,04,13,00);
        dateTime[12] = LocalDateTime.of(2020,01,04,16,00);
        dateTime[13] = LocalDateTime.of(2020,01,04,19,00);
        dateTime[14] = LocalDateTime.of(2020,01,04,22,00);
        ArrayList<ShowTime> showTimeArrayList = new ArrayList<>();
        ArrayList<Cineplex> cineplexArrayList = database.readSerializedObject("Cineplex");
        for (Cineplex cineplex: cineplexArrayList)
        {
            Movie movie = cineplex.getMovieInCineplexArrayList().get(0);
            int cinemaId = cineplex.getCinemaArrayList().get(0).getCinemaID();
            int column = cineplex.getCinemaArrayList().get(0).getColumn();
            int row = cineplex.getCinemaArrayList().get(0).getRows();
            int[][] layOut = new int[row][column];
            for (int i=0;i<row;i++)
            {
                for (int r=0; r<column;r++)
                {
                    layOut[i][r] =0;
                }
            }

            for (int i=0; i <15;i++)
            {
                showTimeArrayList.add(new ShowTime(cineplex, movie, cinemaId, column, row, dateTime[i],layOut));
            }
        }

        for (ShowTime showTime: showTimeArrayList)
        {
            System.out.println("cineplex: "+ showTime.getCineplex().getCineplexID());
            System.out.println("movie: "+showTime.getMovie());
            System.out.println("showtime " + showTime.getDateTime().toString());
            System.out.println("cinema: " + showTime.getCinemaID());
        }
        database.writeSerializedObject("ShowTime", showTimeArrayList);

        System.out.println("read from data");
        showTimeArrayList = new ArrayList<>();
        showTimeArrayList = database.readSerializedObject("ShowTime");
        for (ShowTime showTime: showTimeArrayList)
        {
            System.out.println("cineplex: "+ showTime.getCineplex().getCineplexID());
            System.out.println("movie: "+showTime.getMovie());
            System.out.println("showtime " + showTime.getDateTime().toString());
            System.out.println("cinema: " + showTime.getCinemaID());
        }

        //add showtime for platinum movie suit
        dateTime = new LocalDateTime[3];
        dateTime[0] = LocalDateTime.of(2020,01,03,19,00);  //friday
        dateTime[1] = LocalDateTime.of(2020,01,01,19,00);  //public holiday
        dateTime[2] = LocalDateTime.of(2020,01,04,19,00);  //weekend
        showTimeArrayList = database.readSerializedObject("ShowTime");
        for (Cineplex cineplex: cineplexArrayList)
        {
            Movie movie = cineplex.getMovieInCineplexArrayList().get(0);
            int cinemaId = cineplex.getCinemaArrayList().get(2).getCinemaID();
            int column = cineplex.getCinemaArrayList().get(2).getColumn();
            int row = cineplex.getCinemaArrayList().get(2).getRows();
            int[][] layOut = new int[row][column];
            for (int i=0;i<row;i++)
            {
                for (int r=0; r<column;r++)
                {
                    layOut[i][r] =0;
                }
            }

            for (int i=0; i <3;i++)
            {
                showTimeArrayList.add(new ShowTime(cineplex, movie, cinemaId, column, row, dateTime[i],layOut));
            }
        }
        for (ShowTime showTime: showTimeArrayList)
        {
            System.out.println("cineplex: "+ showTime.getCineplex().getCineplexID());
            System.out.println("movie: "+showTime.getMovie());
            System.out.println("showtime " + showTime.getDateTime().toString());
            System.out.println("cinema: " + showTime.getCinemaID());
        }
        database.writeSerializedObject("ShowTime", showTimeArrayList);*/

        //public holiday
        //    private LocalDate date;
        //    private String holidayName;

        /*insert public holiday
        LocalDate date = LocalDate.of(2020, 01,01);
        PublicHoliday publicHoliday = new PublicHoliday(date, "New year");

        ArrayList<PublicHoliday> publicHolidayArrayList = new ArrayList<>();
        publicHolidayArrayList.add(publicHoliday);

        database.writeSerializedObject("PublicHoliday", publicHolidayArrayList);
        publicHolidayArrayList = new ArrayList<>();
        publicHolidayArrayList = database.readSerializedObject("PublicHoliday");
        for (PublicHoliday publicHoliday1: publicHolidayArrayList)
        {
            System.out.println("public hol name:" + publicHoliday1.getHolidayName());
            System.out.println("date: " + publicHoliday1.getDate().toString());
        }*/


        //ticket
        //    private ShowTime showTime;
        //    private String customerClass;
        //    private double price;
        //    private String seat;

        //create transaction file
        /*ArrayList<Transaction>  transactionArrayList = new ArrayList<>();
        database.writeSerializedObject("Transaction", transactionArrayList);*/

        //create pricing chart

        //    private int pricingChartID;
        //    private String cinemaType;  Platinum Movie Suites
        //    private String customerClass;
        //    private String dayOfTheWeek;
        //    private String movieType;
        //    private double price;
        //    private LocalTime fromTime;
        //    private LocalTime toTime;

        //change cinema type
        /*ArrayList<Cineplex> cineplexArrayList = database.readSerializedObject("Cineplex");
        ArrayList<Cinema> cinemaArrayList;
        int count=0;
        for (Cineplex cineplex: cineplexArrayList)
        {
            cinemaArrayList = cineplex.getCinemaArrayList();
            if (cineplex.getCineplexID()==2)
            {
                for (Cinema cinema: cinemaArrayList)
                {
                    if (cinema.getCinemaID()==1)
                    {
                        cinema.setCinemaType("Normal");
                    }
                    System.out.println("cineplex: " + cineplex.getCineplexName());
                    System.out.println("cinema num: "+ cinema.getCinemaID());
                    System.out.println("Cinema type: " + cinema.getCinemaType());
                }

            }
            else
            {

                for (Cinema cinema: cinemaArrayList)
                {
                    if (cinema.getCinemaID()==1)
                    {
                        cinema.setCinemaType("Normal");
                    }
                    if (cinema.getCinemaID()==3)
                    {
                        cinema.setCinemaType("Platinum Movie Suites");
                    }
                    System.out.println("cineplex: " + cineplex.getCineplexName());
                    System.out.println("cinema num: "+ cinema.getCinemaID());
                    System.out.println("Cinema type: " + cinema.getCinemaType());


                }
            }
        }*/

        //database.writeSerializedObject("Cineplex", cineplexArrayList);

        /*
        ArrayList<PricingChart> pricingChartArrayList = new ArrayList<>();
        //platinum movie suites & block busters
        pricingChartArrayList.add(new PricingChart(1, "Platinum Movie Suites",
                "Adult", DayOfWeek.MONDAY, "blockbusters", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(2, "Platinum Movie Suites",
                "Adult", DayOfWeek.TUESDAY, "blockbusters", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(3, "Platinum Movie Suites",
                "Adult", DayOfWeek.WEDNESDAY, "blockbusters", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(4, "Platinum Movie Suites",
                "Adult", DayOfWeek.THURSDAY, "blockbusters", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(5, "Platinum Movie Suites",
                "Adult", DayOfWeek.FRIDAY, "blockbusters", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(6, "Platinum Movie Suites",
                "Adult", DayOfWeek.SATURDAY, "blockbusters", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(7, "Platinum Movie Suites",
                "Adult", DayOfWeek.SUNDAY, "blockbusters", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));


        //platinum movie suites & 2d
        pricingChartArrayList.add(new PricingChart(8, "Platinum Movie Suites",
                "Adult", DayOfWeek.MONDAY, "2D", 28,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(9, "Platinum Movie Suites",
                "Adult", DayOfWeek.TUESDAY, "2D", 28,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(10, "Platinum Movie Suites",
                "Adult", DayOfWeek.WEDNESDAY, "2D", 28,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(11, "Platinum Movie Suites",
                "Adult", DayOfWeek.THURSDAY, "2D", 28,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(12, "Platinum Movie Suites",
                "Adult", DayOfWeek.FRIDAY, "2D", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(13, "Platinum Movie Suites",
                "Adult", DayOfWeek.SATURDAY, "2D", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(14, "Platinum Movie Suites",
                "Adult", DayOfWeek.SUNDAY, "2D", 38,
                LocalTime.of(0,0), LocalTime.of(23,59)));

        // cinema type:"Normal" and movieType 2d adult
        pricingChartArrayList.add(new PricingChart(24, "Normal",
                "Adult", DayOfWeek.MONDAY, "2D", 8.5,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(25, "Normal",
                "Adult", DayOfWeek.TUESDAY, "2D", 8.5,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(26, "Normal",
                "Adult", DayOfWeek.WEDNESDAY, "2D", 8.5,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(27, "Normal",
                "Adult", DayOfWeek.THURSDAY, "2D", 9.5,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(28, "Normal",
                "Adult", DayOfWeek.FRIDAY, "2D", 9.5,
                LocalTime.of(0,0), LocalTime.of(18,00)));
        pricingChartArrayList.add(new PricingChart(29, "Normal",
                "Adult", DayOfWeek.FRIDAY, "2D", 11,
                LocalTime.of(18,00), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(30, "Normal",
                "Adult", DayOfWeek.SATURDAY, "2D", 11,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(31, "Normal",
                "Adult", DayOfWeek.SUNDAY, "2D", 11,
                LocalTime.of(0,0), LocalTime.of(23,59)));

        //student price 2d
        pricingChartArrayList.add(new PricingChart(32, "Normal",
                "Student", DayOfWeek.MONDAY, "2D", 7,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(33, "Normal",
                "Student", DayOfWeek.TUESDAY, "2D", 7,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(34, "Normal",
                "Student", DayOfWeek.WEDNESDAY, "2D", 7,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(35, "Normal",
                "Student", DayOfWeek.THURSDAY, "2D", 7,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(36, "Normal",
                "Student", DayOfWeek.FRIDAY, "2D", 7,
                LocalTime.of(0,0), LocalTime.of(18,00)));

        //student 3d
        pricingChartArrayList.add(new PricingChart(37, "Normal",
                "Student", DayOfWeek.MONDAY, "3D", 9,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(38, "Normal",
                "Student", DayOfWeek.TUESDAY, "3D", 9,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(39, "Normal",
                "Student", DayOfWeek.WEDNESDAY, "3D", 9,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(40, "Normal",
                "Student", DayOfWeek.THURSDAY, "3D", 9,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(41, "Normal",
                "Student", DayOfWeek.FRIDAY, "3D", 9,
                LocalTime.of(0,0), LocalTime.of(18,00)));

        //senior citizen
        pricingChartArrayList.add(new PricingChart(42, "Normal",
                "Senior Citizen", DayOfWeek.MONDAY, "2D", 4,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(43, "Normal",
                "Senior Citizen", DayOfWeek.TUESDAY, "2D", 4,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(44, "Normal",
                "Senior Citizen", DayOfWeek.WEDNESDAY, "2D", 4,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(45, "Normal",
                "Senior Citizen", DayOfWeek.THURSDAY, "2D", 4,
                LocalTime.of(0,0), LocalTime.of(23,59)));
        pricingChartArrayList.add(new PricingChart(46, "Normal",
                "Senior Citizen", DayOfWeek.FRIDAY, "2D", 4,
                LocalTime.of(0,0), LocalTime.of(18,00)));


        database.writeSerializedObject("PricingChart", pricingChartArrayList);
        */


        //Ticket t1 = new Ticket() --> nid to get showtime first

        //Transaction t = new Transaction(001,"tom", "9432444", "tom123@gmail.com",
               // )
/*


        ArrayList<Cineplex> cineplexArrayList = new ArrayList<>();
        cineplexArrayList = database.readSerializedObject("Cineplex");
        ArrayList<Cinema> cinemaArrayList = cineplexArrayList.get(0).getCinemaArrayList();
        for(Cinema cinema:cinemaArrayList){
            System.out.println(cinema.getColumn());
        }

        ArrayList reviewArrayList = new ArrayList();
        ArrayList<Movie> movieArrayList = new ArrayList();

        Review review = new Review("Very good movie", 5);
        Review review1 = new Review("Decent movie", 3);
        Review review2 = new Review("Bad movie", 1);
        reviewArrayList.add(review);
        reviewArrayList.add(review1);
        reviewArrayList.add(review2);

        Movie movie = new Movie(1,"Ah Boys To Men 4","Now Showing","Singapore's most successful movie franchise is back" +
                "! After leaving the military Wayang King Sergeant Ong and Ken Chow are all busy with their " +
                "respective career as civilians. That's until they are called back to serve the nation again under the " +
                "Singapore Armed Forces' Armoured Formation. Now they must juggle between work and their reservist duties." +
                " What hilarious situations will happen as they train together and their military roles are reversed? " +
                "There'll be new enemy threats and their brotherhood will be put to the test." , "Jack Neo" ,
                "Josh Zhang,Noah Yap,Joshua Tan,Maxi Lim", "PG13", "133min","2D", reviewArrayList);



        ArrayList<Movie> movieArrayList = new ArrayList<>();
        movieArrayList = database.readSerializedObject("Movie");
        for(Movie movie: movieArrayList){
            System.out.println(movie.toString());
        }









    movieArrayList.add(movie);
       //movieArrayList = database.readSerializedObject("Movie");

        database.writeSerializedObject("Movie", movieArrayList);




 */


/**
 *     private int cineplexID;
 *     private String cineplexName;
 *     private String location;
 *     private ArrayList<Cinema> cinemaArrayList;
 *     private ArrayList<Movie> movieInCineplexArrayList;
 *
 *    private int cinemaID;
 *     private int rows;
 *     private int column;
 */


/*
        ArrayList<Cineplex> cineplexArrayList = new ArrayList<>();

        ArrayList<Cinema> cinemaArrayList1 = new ArrayList<>();
        ArrayList<Movie> movieArrayList = database.readSerializedObject("Movie");
        System.out.println(movieArrayList.size());*/
        /*
        ArrayList<Movie> movieArrayList2 = database.readSerializedObject("Movie");
        ArrayList<Movie> movieArrayList3 = database.readSerializedObject("Movie");
        //ArrayList<Movie> movieArrayList1 = database.readSerializedObject("Movie");

        Cinema cinema1 = new Cinema(1,8,2, "Platinum Movie Suites");
        Cinema cinema2 = new Cinema(2,10, 5, "Normal");
        Cinema cinema3 = new Cinema(3,10, 4, "Normal");
        cinemaArrayList1.add(cinema1);
        cinemaArrayList1.add(cinema2);
        cinemaArrayList1.add(cinema3);
        Cineplex cineplex1 = new Cineplex(1, "Jem", "Jurong East", cinemaArrayList1,movieArrayList1);

        ArrayList<Cinema> cinemaArrayList2 = new ArrayList<>();
        Cinema cinema4 = new Cinema(1,5,4, "Platinum Movie Suites");
        Cinema cinema5 = new Cinema(2,12, 10, "Normal");
        Cinema cinema6 = new Cinema(3,11, 8, "Normal");
        cinemaArrayList2.add(cinema4);
        cinemaArrayList2.add(cinema5);
        cinemaArrayList2.add(cinema6);
        Cineplex cineplex2 = new Cineplex(2, "Lido", "Orchard", cinemaArrayList2,movieArrayList2);

        ArrayList<Cinema> cinemaArrayList3 = new ArrayList<>();
        Cinema cinema7 = new Cinema(1,10,10, "Normal");
        Cinema cinema8 = new Cinema(2,12, 10, "Normal");
        Cinema cinema9 = new Cinema(3,10, 12, "Normal");
        cinemaArrayList3.add(cinema7);
        cinemaArrayList3.add(cinema8);
        cinemaArrayList3.add(cinema9);
        Cineplex cineplex3 = new Cineplex(3, "The Cathay", "Dhoby Ghaut", cinemaArrayList3,movieArrayList2);

        cineplexArrayList.add(cineplex1);
        cineplexArrayList.add(cineplex2);
        cineplexArrayList.add(cineplex3);

        database.writeSerializedObject("Cineplex",cineplexArrayList);*/





    }
}
