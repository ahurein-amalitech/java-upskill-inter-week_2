public class PaymentProcessorAdapter implements ModernPaymentProcessor {
    private LegacyPaymentProcessor legacyPaymentProcessor;

    public PaymentProcessorAdapter(LegacyPaymentProcessor processor){
        this.legacyPaymentProcessor = processor;
    }
    @Override
    public void processPayment(String paymentType, double amount) {
        legacyPaymentProcessor.makePayment(paymentType, amount);
    }
}
