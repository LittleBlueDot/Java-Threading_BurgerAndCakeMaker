public class MainCakeMaker {
    public static void main(String[] args) throws InterruptedException {
        CakeMaker c = new CakeMaker();

        Thread preheatOven = new Thread(c::preheatOven, "preheatOven");
        Thread mixDryIngredients = new Thread(c::mixDryIngredients, "mixDryIngredients");
        Thread mixWetIngredients = new Thread(c::mixWetIngredients, "mixWetIngredients");
        Thread combineIngredients = new Thread(c::combineIngredients, "combineIngredients");
        Thread bakeCake = new Thread(c::bakeCake, "bakeCake");
        Thread makeFrosting = new Thread(c::makeFrosting, "makeFrosting");
        Thread frostCake = new Thread(c::frostCake, "frostCake");

//        Thread preheatOven = new Thread(() -> c.preheatOven(), "preheatOven");
//        Thread mixDryIngredients = new Thread(() -> c.mixDryIngredients(), "mixDryIngredients");
//        Thread mixWetIngredients = new Thread(() -> c.mixWetIngredients(), "mixWetIngredients");
//        Thread combineIngredients = new Thread(() -> c.combineIngredients(), "combineIngredients");
//        Thread bakeCake = new Thread(() -> c.bakeCake(), "bakeCake");
//        Thread makeFrosting = new Thread(() -> c.makeFrosting(), "makeFrosting");
//        Thread frostCake = new Thread(() -> c.frostCake(), "frostCake");



        preheatOven.start();
        mixDryIngredients.start();
        mixWetIngredients.start();
        makeFrosting.start();
        mixDryIngredients.join();
        mixWetIngredients.join();
        combineIngredients.start();
        combineIngredients.join();
        preheatOven.join();
        bakeCake.start();
        makeFrosting.join();
        bakeCake.join();
        frostCake.start();
        frostCake.join();

        System.out.println("Cake complete!");
    }
}
