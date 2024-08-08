public class OrderProcessingFacade {
    private InventorySystem inventorySystem = new InventorySystem();
    private PaymentSystem paymentSystem = new PaymentSystem();
    private NotificationSystem notificationSystem = new NotificationSystem();
    private ShippingSystem shippingSystem = new ShippingSystem();

    public void placeOrder(String productId, int quantity, String paymentDetails, String shippingAddress, String customerEmail){
        if(inventorySystem.checkStock(productId, quantity)){
            if(paymentSystem.processPayment(paymentDetails)){
                inventorySystem.updateStock(productId, quantity);
                shippingSystem.arrangeShipping(productId, shippingAddress);
                notificationSystem.sendOrderConfirmation(customerEmail);
                System.out.println("Order placed successfully" );
            }else{
                System.out.println("Payment failed.");
            }
        }else{
            System.out.println("Product out of stock.");
        }
    }
}
