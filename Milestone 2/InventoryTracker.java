package milestone2;

public class InventoryTracker implements Observer {

    private String orderStatus;

    @Override
    public void update(String orderStatus) {
        this.orderStatus = orderStatus;
        updateInventory();
    }

    public void updateInventory() {
        System.out.println(
            "Inventory Tracker: Received Order Status: " + orderStatus
        );
    }
}