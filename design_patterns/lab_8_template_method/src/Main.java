public class Main {
    public static void main(String[] args) {
        DataEncryption aesEncryption = new AESEncryption();
        aesEncryption.encryptData();

        DataEncryption rsaEncryption = new RSAEncryption();
        rsaEncryption.encryptData();
    }
}
