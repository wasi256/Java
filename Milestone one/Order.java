public class Order{
    PricingStrategy strategy;
    double subtotal;
    public Order(double subtotal){
        this.subtotal = subtotal;

    }
    public void setStrategy(PricingStrategy strategy){
        this.strategy = strategy;
    }
    public double calculateTotal(){
        return strategy.calculateTotal(subtotal);
    }
}