import java.util.Stack;

public class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy){
        this.strategy = strategy;
    }

    public void sortArray(int[] array){
        strategy.sort(array);
    }
}
