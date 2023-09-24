package com.welcome.threads;

import static sun.misc.VM.getState;

public class ThreadCreation2 implements Runnable{

    public static void main(String[] args) {
        ThreadCreation2 threadCreation2 = new ThreadCreation2();
        Thread thread = new Thread(threadCreation2);
        thread.start();
        System.out.println("CODE IS FROM INSIDE OF THE MAIN CLASS : "+thread.getState());
    }
    @Override
    public void run() {
        System.out.println("CODE IS FROM OUTSIDE  OF THE MAIN CLASS : "+getClass());
    }
}
