package milestone2;

public class BrewHubDemo {

    public static void main(String[] args) {

        OrderStatusPublisher publisher =
                new OrderStatusPublisher();
                

        KitchenDisplay kitchen =
                new KitchenDisplay();

        CustomerNotifier customer =
                new CustomerNotifier();

        InventoryTracker inventory =
                new InventoryTracker();

        publisher.registerObserver(kitchen);
        publisher.registerObserver(customer);
        publisher.registerObserver(inventory);

        publisher.setOrderStatus("QUEUED");
    }
}