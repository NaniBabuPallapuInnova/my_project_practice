package mypractice.com.practice;

import java.util.*;

class Cinema {

    public Cinema() {
    }

    public Cinema(int movieId, String movieName, double movieRating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieRating = movieRating;
    }

    private int movieId;
    private String movieName;
    private double movieRating;

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getMovieRating() {
        return movieRating;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieRating=" + movieRating +
                '}';
    }


//    @Override
//    public int compareTo(Cinema o) {
//        return Integer.compare(this.getMovieId(), o.getMovieId());
//    }
}

public class PracticeTest {

    public static void main(String[] args) {

        Set<Cinema> list = new LinkedHashSet<>();
        list.add(new Cinema(11, "Avengers", 8.8));
        list.add(new Cinema(2, "Ride", 7.5));
        list.add(new Cinema(32, "Mission Impossible", 9.9));
        list.add(new Cinema(4, "JonWick", 8.5));
        list.add(new Cinema(4, "JonWick", 8.5));
        list.add(new Cinema(4, "JonWick", 8.5));
        list.add(new Cinema(4, "JonWick", 8.5));

        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (Cinema cinema : list) {
            map.put(cinema.getMovieId(), cinema.getMovieName());
            int value = cinema.hashCode();
            System.out.println(value);
        }

        for (Map.Entry<Integer, String> data : map.entrySet()) {
            System.out.println(data.getKey() + " " + data.getValue());


        }

        list.forEach(cinema -> System.out.println(cinema.toString()));

    }

}


