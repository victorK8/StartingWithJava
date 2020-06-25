

class ThreadingExample extends Thread{
  public void run(){
    System.out.println("thread is running...");
    }

  public static void main(String args[]){
    ThreadingExample t1=new ThreadingExample();
    t1.start();
     }
}
