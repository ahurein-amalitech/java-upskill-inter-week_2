import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {34, 7, 23, 32, 5, 62};

        Sorter sorter = new Sorter(new BubbleSort());
        sorter.sortArray(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{34, 7, 23, 32, 5, 62};
        sorter.setStrategy(new QuickSort());
        sorter.sortArray(array);
        System.out.println(Arrays.toString(array));
    }
}
