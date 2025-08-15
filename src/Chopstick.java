import java.util.concurrent.Semaphore;

public class Chopstick {
    private final Semaphore semaphore = new Semaphore(1);

    void grabChopstick() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void dropChopstick() {
        semaphore.release();
    }
}
