import java.util.Observer;

public interface Subject {
    void registerObserver(ObjectObserver o);
    void removeObserver(ObjectObserver o);
    void notifyObservers();
}
