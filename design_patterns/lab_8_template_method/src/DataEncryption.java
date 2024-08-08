public abstract class DataEncryption {
    public final void encryptData(){
        generateKey();
        encrypt();
    }

    public final void decryptData(){
        generateKey();
        decrypt();
    }

    protected abstract void generateKey();
    protected abstract void encrypt();
    protected abstract void decrypt();
}
