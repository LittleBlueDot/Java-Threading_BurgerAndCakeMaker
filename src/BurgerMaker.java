import java.lang.Thread;
public class BurgerMaker {

    public void toastBuns() {
        try {
            System.out.println("Toasting buns...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void grillPatty(){
        try {
            System.out.println("Grilling patty...");
            Thread.sleep(1500);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public void meltCheese() {
        try {
            System.out.println("Melting cheese...");
            Thread.sleep(800);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public void fryOnions() {
        try {
            System.out.println("Frying onions...");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public void assembleBurger() {
        try {
            System.out.println("Assembling burger...");
            Thread.sleep(1500);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }

}

