public class Main {
    public static void main(String[] args) {
        LegacyPaymentProcessor legacyPaymentProcessor = new LegacyPaymentProcessor();

        ModernPaymentProcessor modernPaymentProcessor = new PaymentProcessorAdapter(legacyPaymentProcessor);

        modernPaymentProcessor.processPayment("card", 1223);
        modernPaymentProcessor.processPayment("momo", 59);
    }
}
