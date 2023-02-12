public class CakeMaker {

    private boolean whiskInUse = false;
    private boolean ovenInUse = false;
    private boolean mixingBowlInUse = false;


    public void preheatOven() {
        try {
            printTask("Oven pre-heating...");
            synchronized (this){
                printTask("Oven is in use!");
                ovenInUse = true;
            }
            Thread.sleep(10000);
            synchronized(this) {
                ovenInUse = false;
                printTask("Releasing oven!");
                notifyAll();
            }
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void mixDryIngredients() {
        try {
            printTask("Mixing dry ingredients...");
            synchronized(this) {
                while(mixingBowlInUse){
                    printTask("Waiting for the mixing bowl...");
                    wait();
                }
                printTask("Using the mixing bowl!");
                mixingBowlInUse = true;
            }
            Thread.sleep(200);
            printTask("Adding cake flour");
            Thread.sleep(200);
            printTask("Adding salt");
            Thread.sleep(200);
            printTask("Adding baking powder");
            Thread.sleep(200);
            printTask("Adding baking soda");
            Thread.sleep(200);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(200);
            synchronized(this) {
                mixingBowlInUse = false;
                printTask("Releasing the mixing bowl!");
                notifyAll();
            }
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void mixWetIngredients() {
        try {
            printTask("Mixing wet ingredients...");
            synchronized(this) {
                while(mixingBowlInUse){
                    printTask("Waiting for the mixing bowl...");
                    wait();
                }
                printTask("Using the mixing bowl!");
                mixingBowlInUse = true;
            }
            Thread.sleep(1000);
            printTask("Adding butter...");
            Thread.sleep(500);
            printTask("Adding eggs...");
            Thread.sleep(500);
            printTask("Adding vanilla extract...");
            Thread.sleep(500);
            printTask("Adding buttermilk...");
            Thread.sleep(500);
            synchronized(this) {
                while(whiskInUse){
                    printTask("Waiting for the whisk...");
                    wait();
                }
                printTask("Using the whisk!");
                whiskInUse = true;
            }
            printTask("Mixing...");
            Thread.sleep(1500);
            synchronized(this) {
                whiskInUse = false;
                printTask("Releasing the whisk!");
                notifyAll();
            }
            synchronized(this) {
                mixingBowlInUse = false;
                printTask("Releasing the mixing bowl!");
                notifyAll();
            }
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void combineIngredients() {
        try {
            printTask("Combining ingredients...");
            synchronized(this) {
                while(mixingBowlInUse){
                    printTask("Waiting for the mixing bowl...");
                    wait();
                }
                printTask("Using the mixing bowl!");
                mixingBowlInUse = true;
            }
            Thread.sleep(1000);
            printTask("Adding dry mix to wet mix...");
            Thread.sleep(1500);
            synchronized (this){
                while (whiskInUse){
                    printTask("Waiting for the whisk...");
                    wait();
                }
                printTask("Using the whisk");
                whiskInUse = true;
            }
            printTask("Mixing...");
            Thread.sleep(1500);
            synchronized(this) {
                whiskInUse = false;
                printTask("Releasing the whisk!");
                notifyAll();
            }
            synchronized(this) {
                mixingBowlInUse = false;
                printTask("Releasing the mixing bowl!");
                notifyAll();
            }
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void bakeCake() {
        try {
            printTask("Baking cake...");
            synchronized (this){
                while (ovenInUse){
                    printTask("Waiting for oven to be pre-heated...");
                    wait();
                }
                printTask("Oven is in use!");
                ovenInUse = true;
            }
            Thread.sleep(10000);
            synchronized(this) {
                ovenInUse = false;
                printTask("Releasing oven!");
                notifyAll();
            }
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void makeFrosting() {
        try {
            printTask("Making frosting...");
            synchronized(this) {
                while(whiskInUse){
                    printTask("Waiting for the whisk...");
                    wait();
                }
                printTask("Using the whisk!");
                whiskInUse = true;
            }
            synchronized(this) {
                while(mixingBowlInUse){
                    printTask("Waiting for the mixing bowl...");
                    wait();
                }
                printTask("Using the mixing bowl!");
                mixingBowlInUse = true;
            }
            printTask("Adding butter...");
            Thread.sleep(200);
            printTask("Adding milk...");
            Thread.sleep(200);
            printTask("Adding sugar...");
            Thread.sleep(200);
            printTask("Adding vanilla extract...");
            Thread.sleep(200);
            printTask("Adding salt...");
            Thread.sleep(200);
            synchronized(this) {
                whiskInUse = false;
                printTask("Releasing the whisk!");
                notifyAll();
            }
            synchronized(this) {
                mixingBowlInUse = false;
                printTask("Releasing the mixing bowl!");
                notifyAll();
            }
            printTask("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void frostCake() {
        try {
            printTask("Frosting cake...");
            Thread.sleep(1500);
            printTask("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private void printTask(String task) {
        System.out.println(Thread.currentThread().getName() + " " + " - " + task);
    };
}
