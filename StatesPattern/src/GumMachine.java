public class GumMachine extends AbstractGumMachine implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    switch (state) {

                        case NO_COIN:
                            wait(5000);
                            throwCoin();
                            break;
                        case HAS_COIN:
                            wait(1000);
                            pullTheLever();
                            break;
                        case LOTTERY:
                            wait(1000);
                            conductLottery();
                            break;
                        case GIVE_PRIZE:
                            wait(1000);
                            givePrize();
                            break;
                        case GIVE_GUM:
                            wait(1000);
                            giveGum();
                            break;
                        case NO_GUM:
                            wait(100000);
                            spreadGum(10);
                            break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
