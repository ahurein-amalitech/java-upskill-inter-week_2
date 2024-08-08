public class RSAEncryption extends DataEncryption{
    @Override
    protected void generateKey() {
        System.out.println("Generating RSA key...");
    }

    @Override
    protected void encrypt() {
        System.out.println("Encrypting data using RSA...");
    }

    @Override
    protected void decrypt() {
        System.out.println("Decrypting data using RSA...");
    }
}
