public class LegacyPaymentProcessor {
    public void makePayment(String paymentType, double amount){
        System.out.printf("Processing ${paymentType} payment of ${amount} using legacy system.%n",  paymentType, amount);
    }
}
