import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Scanner;

public class Loader2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите путь к папке");
        File folder = new File(scanner.nextLine());
        String readableSize = Loader.humanReadableByteCount(FileUtils.sizeOfDirectory(folder), false);
        System.out.println(readableSize);
    }
}
