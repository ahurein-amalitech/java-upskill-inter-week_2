import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyLogger logger = MyLogger.getInstance();
        logger.log("This is a log message.");
        logger.log("This is another log message.");

        MyLogger anotherLogger = MyLogger.getInstance();
        System.out.println(logger == anotherLogger);
    }
}
