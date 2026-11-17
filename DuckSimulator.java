import java.util.List;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Flock flock = new Flock();
        flock.add(duckFactory.createMallardDuck());
        flock.add(duckFactory.createRedheadDuck());
        flock.add(duckFactory.createDuckCall());
        flock.add(duckFactory.createRubberDuck());
        flock.add(new GooseAdapter(new Goose()));

        System.out.println("\nDuck Simulator: With Abstract Factory");

        flock.quack();

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}