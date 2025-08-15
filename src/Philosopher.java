import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {
    private final int number;
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;

    public Philosopher(int number, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.number = number;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    private void performAction(String action) {
        int waitTime = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Философ " + (number + 1) + action + waitTime + " мс");
    }

    private void sleep() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            sleep();
            performAction(" думает ");
            leftChopstick.grabChopstick();
            System.out.println("Философ " + (number + 1) + " берёт левую вилку");
            rightChopstick.grabChopstick();
            System.out.println("Философ " + (number + 1) + " берёт правую вилку");
            sleep();
            performAction(" ест ");
            leftChopstick.dropChopstick();
            System.out.println("Философ " + (number + 1) + " кладёт левую вилку");
            rightChopstick.dropChopstick();
            System.out.println("Философ " + (number + 1) + " кладёт правую вилку");
        }
    }
}
