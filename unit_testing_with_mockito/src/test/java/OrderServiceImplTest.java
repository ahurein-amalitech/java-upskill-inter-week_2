import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Mock
    OrderRepository orderRepository;

    private OrderServiceImpl orderService;

    public OrderServiceImplTest() {
        this.orderService = new OrderServiceImpl();
    }

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        when(orderRepository.saveOrder("item")).thenReturn(false);
    }

    @Test
    void saveOrder() {
        String payload = "item";
        boolean isSaved = orderService.saveOrder(payload);
        System.out.println(isSaved);
        assertEquals(true, isSaved);
    }
}