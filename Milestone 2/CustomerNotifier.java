package milestone2;
public class CustomerNotifier implements Observer {
    private String orderStatus;

    @Override
    public void update(String orderStatus) {
        this.orderStatus = orderStatus;
        notifyCustomer();
    }

    public void notifyCustomer() {
        System.out.println("Customer Notifier: Order Status Updated to: " + orderStatus);
    }
}