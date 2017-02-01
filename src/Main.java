import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String[] lanArray;
    private static String[] pathFinal;

    public static void main(String[] args) throws InterruptedException {
        displayWelcomeMsg();
        readLanguageList();

    }

    private static void displayWelcomeMsg() {
        try {
            readText("welcomeMsg.txt", null, true);
            System.out.println("Please wait");
            TimeUnit.SECONDS.sleep(1);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readLanguageList() {
        try {
            String commonPath;
            BufferedReader in;
            lanArray = new String[100];

            //Get language list
            readText("languageList.txt", lanArray, false);

            //Get common path
            in = new BufferedReader(new FileReader("commonPath.txt"));
            commonPath = in.readLine();
            in.close();

            for (String lanCode : lanArray) {
                if (lanCode != null)
                    System.out.println(commonPath + lanCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readText(String fileName, String[] targetArray, boolean printOption) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        for (int i = 0; (line = in.readLine()) != null; ++i) {
            if (printOption)
                System.out.println(line);
            if (targetArray != null)
                targetArray[i] = line;
        }
        in.close();
    }
}
