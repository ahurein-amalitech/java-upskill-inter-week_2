public class Main {
    public static void main(String[] args) {
        OrderProcessingFacade facade = new OrderProcessingFacade();

        String productId = "P123";
        int quantity = 2;
        String paymentDetails = "CreditCard";
        String shippingAddress = "123 Main St, Anytown, USA";
        String customerEmail = "customer@example.com";

        facade.placeOrder(productId, quantity, paymentDetails, shippingAddress, customerEmail);
    }
}
