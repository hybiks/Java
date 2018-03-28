import states.States;

public abstract class AbstractGumMachine {
    protected States state;
    protected int counterGum = 10;

    public AbstractGumMachine() {
        state = States.NO_COIN;
        System.out.println("Включили автомат");
    }

    public void throwCoin(){
            state = States.HAS_COIN;
        System.out.println("Кинули монетку");
    }

    public void pullTheLever(){
        state = States.LOTTERY;
        System.out.println("Дернули за рычаг");
    }

    public void conductLottery(){
        if ((Math.round(Math.random() * 2)) == 2 && counterGum >= 2){
            state = States.GIVE_PRIZE;
            System.out.println("Выйграли приз");
        } else {
            state = States.GIVE_GUM;
            System.out.println("Приз не выигран");
        }
    }

    public void givePrize(){
        counterGum--;
        state = States.GIVE_GUM;
        System.out.println("Приз выдан");
    }

    public void giveGum(){
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

    public void spreadGum(int gums){
        counterGum = gums;
        state = States.NO_COIN;
        System.out.println("Жвачка засыпана");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
