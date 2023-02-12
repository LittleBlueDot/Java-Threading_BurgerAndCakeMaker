public class CakeMaker {

    private boolean whiskInUse = false;
    private boolean ovenInUse = false;
    private boolean mixingBowlInUse = false;


    public void preheatOven() {
        try {
            printTask("Oven pre-heating...");
            ovenInUse = true;
            Thread.sleep(10000);
            ovenInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void mixDryIngredients() {
        try {
            printTask("Mixing dry ingredients...");
            mixingBowlInUse = true;
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
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void mixWetIngredients() {
        try {
            printTask("Mixing wet ingredients...");
            mixingBowlInUse = true;
            Thread.sleep(1000);
            printTask("Adding butter...");
            Thread.sleep(500);
            printTask("Adding eggs...");
            Thread.sleep(500);
            printTask("Adding vanilla extract...");
            Thread.sleep(500);
            printTask("Adding buttermilk...");
            Thread.sleep(500);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(1500);
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void combineIngredients() {
        try {
            printTask("Combining ingredients...");
            mixingBowlInUse = true;
            Thread.sleep(1000);
            printTask("Adding dry mix to wet mix...");
            Thread.sleep(1500);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(1500);
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void bakeCake() {
        try {
            printTask("Baking cake...");
            ovenInUse = true;
            Thread.sleep(10000);
            ovenInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void makeFrosting() {
        try {
            printTask("Making frosting...");
            whiskInUse = true;
            mixingBowlInUse = true;
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
            whiskInUse = false;
            mixingBowlInUse = false;
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
