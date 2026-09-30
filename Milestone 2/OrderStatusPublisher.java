package milestone2;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusPublisher implements Subject{
    private List<Observer> observers;
    private String orderStatus;

    // Constructor to initialize the observers list
    public OrderStatusPublisher() {
        observers = new ArrayList<>(); 
        
    }
   //method to register an observer
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    //method to remove an observer
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    //method to notify all registered observers about the order status change
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(orderStatus);
        }
    }

    //method to set the order status and notify observers about the change
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        notifyObservers(); 
    }
}