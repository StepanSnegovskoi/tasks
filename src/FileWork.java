import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWork {
    private static final ArrayList<String[]> array = new ArrayList<>();
    private static File file;

    public static void AddTariffViaMySrc(String nameFile, TariffList tariffList) { // только для меня
        file = new File(String.format("C:\\Users\\stepa\\IdeaProjects\\task1\\src\\%s", nameFile));
        AddElementsInTariffList(tariffList);
    }

    public static void AddTariffPathToFile(String pathToFile, TariffList tariffList) { // для всех
        file = new File(String.format("%s", pathToFile));
        AddElementsInTariffList(tariffList);
    }

    public static void addFromCodeToFile(TariffList tariffList) {
        File file = new File("C:\\Users\\stepa\\IdeaProjects\\task1\\src\\TariffsFromCode");
        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < tariffList.getSize(); i++) {
            String directionCode = tariffList.getTariff(i).getDirectionCode();
            String nameOfTheDirection = tariffList.getTariff(i).getNameOfTheDirection();
            double pricePerMinute = tariffList.getTariff(i).getPricePerMinute();
            printWriter.printf("%s %s %s\n", directionCode, nameOfTheDirection, pricePerMinute);
        }
        printWriter.close();
    }
    private static void AddElementsInTariffList(TariffList tariffList) {
        Scanner scanner;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int index = 0;
        while (scanner.hasNextLine()) {
            array.add(scanner.nextLine().split(" "));
            String directionCode = array.get(index)[0];
            String nameOfTheDirection = array.get(index)[1];
            double pricePerMinute = Double.parseDouble(array.get(index)[2]);
            Tariff tariff = new Tariff(directionCode, nameOfTheDirection, pricePerMinute);
            tariffList.add(tariff);
            index++;
        }
        scanner.close();
    }
}
