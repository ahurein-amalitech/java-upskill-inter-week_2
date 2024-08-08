import java.util.ArrayList;

public class WeatherStation implements  Subject{
    private ArrayList<ObjectObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(ObjectObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(ObjectObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (ObjectObserver ob : observers) {
            ob.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
