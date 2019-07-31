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
            foldersTree(srcFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void foldersTree(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                System.out.println(entry.getName());
                foldersTree(entry);
            } else {
                System.out.printf(" %10d байт - %s%n", entry.length(), entry.getName());
            }
        }
    }
}
