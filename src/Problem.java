import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Problem {
    private final int numOfPhilosophers = 5;
    private final Philosopher[] philosophers = new Philosopher[numOfPhilosophers];
    private final Chopstick[] chopsticks = new Chopstick[numOfPhilosophers];

    public void startModelling() {
        for (int i = 0; i < numOfPhilosophers; i++) {
            chopsticks[i] = new Chopstick();
        }
        ExecutorService executor = Executors.newFixedThreadPool(numOfPhilosophers);
        for (int i = 0; i < numOfPhilosophers; i++) {
            if (i % 2 == 0) {
                philosophers[i] = new Philosopher(i, chopsticks[(i + 1) % numOfPhilosophers], chopsticks[i]);
            }
            else {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % numOfPhilosophers]);
            }

            executor.execute(philosophers[i]);
        }
    }
}
