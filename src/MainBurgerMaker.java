public class MainBurgerMaker {
    public static void main(String[] args) throws InterruptedException {
        BurgerMaker burgerMaker = new BurgerMaker();
        Thread t1 = new Thread(() -> burgerMaker.toastBuns());
        Thread t2 = new Thread(() -> burgerMaker.grillPatty());
        Thread t3 = new Thread(() -> burgerMaker.meltCheese());
        Thread t4 = new Thread(() -> burgerMaker.fryOnions());
        Thread t5 = new Thread(() -> burgerMaker.assembleBurger());


        t1.start();
        t2.start();
        t4.start();
        t2.join();
        t3.start();
        t1.join();
        t3.join();
        t4.join();
        // must complete all other steps before assembling burger
        t5.start();
        t5.join();
        System.out.println("Burger complete!");


    }
}
