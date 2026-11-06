import java.rmi.*;
import java.rmi.server.*;

public class GumballMachine  extends UnicastRemoteObject implements GumballMachineRemote {
    private static final long serialVersionUID = 2L;
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state;
    int count = 0;
    String location;

    public GumballMachine(String location, int numberGumballs) throws RemoteException {
        this.location = location;
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
    void setState(State state) {
        this.state = state;
    }
    public int getCount() {
        return count;
    }
    public State getState() {
        return state;
    }
    public String getLocation() {
        return location;
    }
    public State getNoQuarterState() {
        return noQuarterState;
    }
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    public State getSoldState() {
        return soldState;
    }
    public State getSoldOutState() {
        return soldOutState;
    }
    public State getWinnerState() {
        return winnerState;
    }
    public String toString() {
        if (count > 0) {
            return "Mighty Gumball, Inc.\nJava-enabled Standing Gumball Model #2004\nInventory: " + count + " gumballs\nMachine is waiting for quarter";
        } else {
            return "Mighty Gumball, Inc.\nJava-enabled Standing Gumball Model #2004\nInventory: 0 gumballs\nMachine is sold out";
        }
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    public static void main(String[] args) {
        try {
            GumballMachine machine = new GumballMachine("Test Location", 5);
            System.out.println(machine);
            System.out.println("Initial state: " + machine.getState().getClass().getSimpleName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}