import states.States;

public abstract class AbstractGumMachine implements Runnable {
    protected States state;
    protected int counterGum = 10;

    public AbstractGumMachine() {
        state = States.NO_COIN;
        System.out.println("Включили автомат");
    }

    public synchronized void throwCoin() throws InterruptedException {
        wait(5000);
        state = States.HAS_COIN;
        System.out.println("Кинули монетку");
    }

    public synchronized void pullTheLever() throws InterruptedException {
        wait(1000);
        state = States.LOTTERY;
        System.out.println("Дернули за рычаг");
    }

    public synchronized void giveCoin() throws InterruptedException {
        wait(1000);
        state = States.NO_COIN;
        System.out.println("Вернули монету");
    }

    public synchronized void conductLottery() throws InterruptedException {
        wait(1000);
        if ((Math.round(Math.random() * 2)) == 2 && counterGum >= 2){
            state = States.GIVE_PRIZE;
            System.out.println("Выйграли приз");
        } else {
            state = States.GIVE_GUM;
            System.out.println("Приз не выигран");
        }
    }

    public synchronized void givePrize() throws InterruptedException {
        wait(1000);
        counterGum--;
        state = States.GIVE_GUM;
        System.out.println("Приз выдан");
    }

    public synchronized void giveGum() throws InterruptedException {
        wait(1000);
        System.out.println("Жвачка выдана");
        if (--counterGum == 0){
            state = States.NO_GUM;
            System.out.println("Жвачка кончилась");
        } else {
            System.out.println();
            System.out.println();
            System.out.println();
            state = States.NO_COIN;
        }

    }

    public synchronized void spreadGum(int gums) throws InterruptedException {
        wait(10000);
        counterGum = gums;
        state = States.NO_COIN;
        System.out.println("Жвачка засыпана");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
