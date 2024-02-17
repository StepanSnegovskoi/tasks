import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWork {
    private static final ArrayList<String[]> array = new ArrayList<>();
    private static File file;

    public static void addTariffFromMySrcFileInTariffList(String nameFile, TariffList tariffList) { // только для меня
        file = new File(String.format("C:\\Users\\stepa\\IdeaProjects\\task1\\src\\%s", nameFile));
        AddElementsInTariffList(tariffList);
    }

    public static void addTariffPathInTariffList(String pathToFile, TariffList tariffList) { // для всех
        file = new File(String.format("%s", pathToFile));
        AddElementsInTariffList(tariffList);
    }

    private static void AddElementsInTariffList(TariffList tariffList) {
        int countTariffs = 0;
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            countTariffs++;
            array.add(scanner.nextLine().split(" "));
        }
        for (int i = 0; i < countTariffs; i++) {
            Tariff tariff = new Tariff(array.get(i)[0], array.get(i)[1], Double.parseDouble(array.get(i)[2]));
            tariffList.add(tariff);
        }
        scanner.close();
    }

    public static void AddElementsFromCodeToFile(TariffList tariffList) {
        File file = new File("C:\\Users\\stepa\\IdeaProjects\\task1\\src\\TariffsFromCode");
        PrintWriter pw;

        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < tariffList.getSize(); i++) {
            String directionCode = tariffList.getTariff(i).getDirectionCode();
            String nameOfTheDirection = tariffList.getTariff(i).getNameOfTheDirection();
            double pricePerMinute = tariffList.getTariff(i).getPricePerMinute();
            pw.printf("%s %s %s\n", directionCode, nameOfTheDirection, pricePerMinute);
        }
        pw.close();
    }
}
