// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class MainOrder {
   public MainOrder() {
   }

   public static void main(String[] args) {
      Order order = new Order((double)50000.0);
      order.setStrategy(new StudentDiscount((double)20.0));
      System.out.println("Total expenditure is " + order.calculateTotal());
   }
}
