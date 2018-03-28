public class GumMachine extends AbstractGumMachine{
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                    switch (state) {
                        case NO_COIN:
                            if (Math.random() > 0.5) {
                                throwCoin();
                            } else {
                                giveCoin();
                            }
                            break;
                        case HAS_COIN:
                            pullTheLever();
                            break;
                        case LOTTERY:
                            conductLottery();
                            break;
                        case GIVE_PRIZE:
                            givePrize();
                            break;
                        case GIVE_GUM:
                            giveGum();
                            break;
                        case NO_GUM:
                            spreadGum(10);
                            break;
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
