package mypractice.com.imp_interfaces_in_java.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Unlike Comparable, Comparator is external to the element type we are comparing. It’s a separate class.
 * We create multiple separate classes (that implement Comparator) to compare by different members.
 * Collections class has a second sort() method, and it takes Comparator.
 * The sort() method invokes the compare() to sort objects.
 *
 * To compare movies by Rating, we need to do 3 things:
 *
 * 1. Create a class that implements Comparator (and thus the compare() method that does the work previously done by compareTo()).
 * 2. Make an instance of the Comparator class.
 * 3. Call the overloaded sort() method, giving it both the list and the instance of the class that implements Comparator.
 */
class Movie{

    private String name;
    private String release;
    private String rating;

    public Movie() {
    }

    public Movie(String name, String release, String rating) {

        this.name = name;
        this.release = release;
        this.rating = rating;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public void setRelease(String release) {

        this.release = release;

    }

    public String getRelease() {

        return release;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", release='" + release + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}

class RatingSort implements Comparator<Movie>{

    @Override
    public int compare(Movie movie1, Movie movie2){
        return Double.compare(Double.parseDouble(movie1.getRating()), Double.parseDouble(movie2.getRating()));
    }
}

class NameSort implements  Comparator<Movie>{
    @Override
    public int compare(Movie movie1, Movie movie2){
        return movie1.getName().compareTo(movie2.getName());
    }
}
public class MainComparator {

    public static void main(String[] args){
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Bahubali", "2015", "9.3"));
        list.add(new Movie("Saaho", "2019", "5.5"));
        list.add(new Movie("Varsham", "2005", "7.3"));
        list.add(new Movie("Saalar", "2023", "6.3"));
        list.add(new Movie("Darling", "2010", "8.3"));


        System.out.println("======== SORTING BASED ON RATING ==========");
        RatingSort ratingSort = new RatingSort();
        Collections.sort(list, ratingSort); //        list.sort(ratingSort);
        list.forEach(movie -> System.out.println(movie.toString()));

        System.out.println("======== SORTING BASED ON NAME ==========");

        NameSort nameSort = new NameSort();
        Collections.sort(list, nameSort);
        list.forEach(movie -> System.out.println(movie.toString()));

    }
}
