
class ThreadingExample_II implements Runnable{
  public void run(){
    System.out.println("thread is running...");
  }

  public static void main(String args[]){
      ThreadingExample_II m1=new ThreadingExample_II();
      Thread t1 =new Thread(m1);
      t1.start();
  }

}
