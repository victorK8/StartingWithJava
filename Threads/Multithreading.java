import java.io.*;
import java.time.*;


/** Task 1 **/
class Task1 implements Runnable{
  public void run(){
    /*** Vars ***/
    long stamp = System.nanoTime();
    long stamp0 = System.nanoTime();
    int CycleId = 0;

    System.out.println("Starting task 1 .......... ");

    while(CycleId<1000){
      // Get time
      stamp = System.nanoTime();
      // If past x second, increment CycleId
      if((stamp-stamp0) > 500000){
        CycleId ++;
      }
    }
  }
}

/** Task 2 **/
class Task2 implements Runnable{
  public void run(){

    System.out.println("Starting task 2 .......... ");

  }
}

/** Launch Task */
public class Multithreading{

  // APP
  public static void main(String[] Args){
    // Create objects for each task
    Task1 t1 = new Task1();
    Task2 t2 = new Task2();

    // Create thread for each task
    Thread tt1 = new Thread(t1);
    Thread tt2 = new Thread(t2);

    // Launch each task
    tt1.start();
    tt2.start();

  }

}
