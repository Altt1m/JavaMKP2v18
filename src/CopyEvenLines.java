import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class CopyEvenLines
{
    public static void main(String[] args)
    {
        String inputFile = "F1.txt";
        String outputFile = "F2.txt";

        try
        {
            // Перевіряємо, чи існує файл F1
            File fileF1 = new File(inputFile);
            if (!fileF1.exists())
            {
                System.out.println("Файл F1 не існує.");
                return;
            }

            // Копіюємо парні рядки з F1 в F2
            copyEvenLines(inputFile, outputFile);

            // Виводимо повідомлення про копіювання
            System.out.println("Рядки, скопійовані у F2:");
            displayFileContent(outputFile);

            // Підраховуємо розмір файлів
            long sizeF1 = getFileSize(inputFile);
            long sizeF2 = getFileSize(outputFile);

            // Виводимо результат
            System.out.println("Розмір файлу F1: " + sizeF1 + " байт");
            System.out.println("Розмір файлу F2: " + sizeF2 + " байт");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void copyEvenLines(String inputFile, String outputFile) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)))
        {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null)
            {
                lineNumber++;

                // Копіюємо тільки парні рядки
                if (lineNumber % 2 == 0)
                {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }

    private static long getFileSize(String filePath)
    {
        File file = new File(filePath);
        return file.length();
    }

    private static void displayFileContent(String filePath) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
    }
}
