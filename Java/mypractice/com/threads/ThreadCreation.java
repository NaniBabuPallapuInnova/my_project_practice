package mypractice.com.threads;

public class ThreadCreation extends Thread {
    public static void main(String[] args) {
        ThreadCreation threadCreation = new ThreadCreation();
        threadCreation.start();
        System.out.println(" THIS CODE IS OUTSIDE OF THREAD : "+threadCreation.getState());
    }

    public void run(){
        System.out.println("THIS CODE IS INSIDE THREAD : "+getState());
    }

}
