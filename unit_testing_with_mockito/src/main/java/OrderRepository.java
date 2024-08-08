import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderRepository {
    List<String> data = new ArrayList<>();

    public String findOne(int id) {
        return data.get(id);
    }

    public List<String> findAll() {
        data.add("item one");
        data.add("item two");
        return data;
    }

    public boolean saveOrder(String payload){
        data.add(payload);
        return true;
    }
}
