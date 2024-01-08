package mypractice.com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie implements Comparable<Movie> {

    private String name;
    private String release;
    private String rating;

    public Movie(){
    }

    public Movie(String name, String release, String rating){

        this.name = name;
        this.release = release;
        this.rating = rating;

    }

    public void setName(String name){

        this.name = name;

    }

    public String getName(){

        return name;

    }

    public void setRelease(String release){

        this.release = release;

    }

    public String getRelease(){

        return release;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getRating(){
        return rating;
    }

    @Override
    public String toString(){

        return "Movie {"+
        "name  = '"+name+'\''+
                ", release = '"+release+ '\''+
                ", rating = '"+rating+'\''+
                '}';
    }

    @Override
    public int compareTo(Movie movie){
        return Integer.compare(Integer.parseInt(this.release), Integer.parseInt(movie.release));
    }

}

public class Main{

    public static void main(String args[]){

        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Bahubali", "2015", "9.3"));
        list.add(new Movie("Saaho", "2019", "5.5"));
        list.add(new Movie("Varsham", "2005", "7.3"));
        list.add(new Movie("Saalar", "2023", "6.3"));
        list.add(new Movie("Darling", "2010", "8.3"));


        Collections.sort(list);
        list.forEach(movie -> System.out.println(movie.toString()));

    }

}
