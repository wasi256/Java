import java.util.List;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        System.out.println("Duck Simulator: With Composite - Flocks");
        System.out.println("Duck Simulator: Whole Flock Simulation");
        Flock flock = new Flock();
        flock.add(duckFactory.createMallardDuck());
        flock.add(duckFactory.createDuckCall());
        flock.add(duckFactory.createRubberDuck());
        flock.add(new QuackCounter(new GooseAdapter(new Goose())));
        flock.add(duckFactory.createMallardDuck());
        flock.add(duckFactory.createMallardDuck());
        flock.add(duckFactory.createMallardDuck());
        flock.add(duckFactory.createMallardDuck());
        flock.quack();
        System.out.println();

        System.out.println("Duck Simulator :Mallard Flock Simulation");
        Flock mallardFlock = new Flock();
        mallardFlock.add(duckFactory.createMallardDuck());
        mallardFlock.add(duckFactory.createMallardDuck());
        mallardFlock.add(duckFactory.createMallardDuck());
        mallardFlock.add(duckFactory.createMallardDuck());
        mallardFlock.quack();
        System.out.println();

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}