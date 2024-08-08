public class AESEncryption extends  DataEncryption {
    @Override
    protected void generateKey() {
        System.out.println("Generating AES key...");
    }

    @Override
    protected void encrypt() {
        System.out.println("Encrypting data using AES...");
    }

    @Override
    protected void decrypt() {
        System.out.println("Decrypting data using AES...");
    }
}
