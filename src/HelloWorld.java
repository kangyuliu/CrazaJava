public class HelloWorld {
   public static volatile int counter = 1;

    public static void main(String[] args){
       counter = 2;
       System.out.println(counter);
        System.out.println("Hello wrold. I am LKY.");
    }
}
