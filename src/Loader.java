import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;

        System.out.println("Пожалуйста, введите путь к папке");
        try {
            text = reader.readLine();
            File srcFile = new File(text);
            String s = humanReadableByteCount(getFolderSize(srcFile), false);
            System.out.println(getFolderSize(srcFile) + " bytes");
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getFolderSize(File folder) {
        long size = 0;
        for (File entry : folder.listFiles()) {
            if (entry.isDirectory()) {
                size += getFolderSize(entry);
            } else {
                size += entry.length();
            }
        }
        return size;
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        char pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1);
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}
