public class StudentDiscount implements PricingStrategy{
    private double discountRate;
public StudentDiscount(double discountRate){
    this.discountRate =discountRate;
}
@Override
public double calculateTotal(double subTotal) {
return ((100-discountRate)/100)*subTotal;
}
}