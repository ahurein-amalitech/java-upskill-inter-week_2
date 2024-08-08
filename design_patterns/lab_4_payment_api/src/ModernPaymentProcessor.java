public interface ModernPaymentProcessor {
    void processPayment(String paymentType, double mount);
}
