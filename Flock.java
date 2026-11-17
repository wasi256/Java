import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {
    List<Quackable> quackers = new ArrayList<Quackable>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    public void quack(){
        Iterator<Quackable>iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }
}