package milestone2;
public class KitchenDisplay implements Observer {
    private String orderStatus;

    @Override
    public void update(String orderStatus) {
        this.orderStatus = orderStatus;
        display();
    }

    public void display() {
        System.out.println("Kitchen Display: Order Status Updated to: " + orderStatus);
    }
}