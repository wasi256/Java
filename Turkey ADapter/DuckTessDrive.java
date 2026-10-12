public class DuckTessDrive {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);
        
        System.out.println("\nThe DuckAdapter says...");
        testDuckAdapter(duck);
        }

        static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
        }
    
    static void testDuckAdapter(Duck duck) {
        Turkey duckAdapter = new DuckAdapter(duck);
        
        System.out.println("\nThe DuckAdapter says...");
        duckAdapter.gobble();
        duckAdapter.fly();
        }
}