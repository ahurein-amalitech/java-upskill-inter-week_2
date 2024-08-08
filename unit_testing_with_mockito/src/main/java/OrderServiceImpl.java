import java.util.List;

public class OrderServiceImpl {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderServiceImpl() {
        orderRepository = new OrderRepository();
    }

    public String findOne(int id){
        return orderRepository.findOne(id);
    }

    public List<String> findAll(){
        return orderRepository.findAll();
    }

    public boolean saveOrder(String data){
        return orderRepository.saveOrder(data);
    }
}
