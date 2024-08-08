import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {
    private static MyLogger instance;

    private static final String PATH = "log.txt";

    private MyLogger(){}

    public static MyLogger getInstance(){
        if(instance == null){
            synchronized (MyLogger.class){
                if(instance == null){
                    instance = new MyLogger();
                }
            }
        }
        return instance;
    }

    public void log(String message) throws IOException {
        String logMessage = STR."\{LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}: \{message}";
        try(FileWriter fw = new FileWriter(PATH, true);  PrintWriter pw = new PrintWriter(fw)){
            pw.println(message);
        }
    }
}
