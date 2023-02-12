public class Main {
    public static void main(String[] args) throws InterruptedException {
        BurgerMaker burgerMaker = new BurgerMaker();
        Thread t1 = new Thread(() -> burgerMaker.toastBuns());
        Thread t2 = new Thread(() -> burgerMaker.grillPatty());
        Thread t3 = new Thread(() -> burgerMaker.meltCheese());
        Thread t4 = new Thread(() -> burgerMaker.fryOnions());
        Thread t5 = new Thread(() -> burgerMaker.assembleBurger());

        System.out.println("CHEESBURGER MAKER");

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

        // Cake maker

        CakeMaker c = new CakeMaker();

        Thread preheatOven = new Thread(() -> c.preheatOven(), "preheatOven");
        Thread mixDryIngredients = new Thread(() -> c.mixDryIngredients(), "mixDryIngredients");
        Thread mixWetIngredients = new Thread(() -> c.mixWetIngredients(), "mixWetIngredients");
        Thread combineIngredients = new Thread(() -> c.combineIngredients(), "combineIngredients");
        Thread bakeCake = new Thread(() -> c.bakeCake(), "bakeCake");
        Thread makeFrosting = new Thread(() -> c.makeFrosting(), "makeFrosting");
        Thread frostCake = new Thread(() -> c.frostCake(), "frostCake");

        System.out.println("CAKE MAKER");


        preheatOven.start();
        mixDryIngredients.start();
        mixWetIngredients.start();
        makeFrosting.start();

        mixDryIngredients.join();
        mixWetIngredients.join();
        combineIngredients.start();

        preheatOven.join();
        combineIngredients.join();
        makeFrosting.join();

        bakeCake.start();
        bakeCake.join();
        frostCake.start();
        frostCake.join();

        System.out.println("Cake complete!");
    }
}
