public class Display implements  ObjectObserver{
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println(STR."Current conditions: \{temperature}F degrees, \{humidity}% humidity, and \{pressure} pressure");
    }
}
