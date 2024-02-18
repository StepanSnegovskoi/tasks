
public class Main {
    public static void main(String[] args) {
        TariffList tariffList = new TariffList();
        FileWork.AddTariffViaMySrc("Tariffs.txt", tariffList);
        FileWork.AddTariffPathToFile("C:\\Users\\stepa\\IdeaProjects\\task1\\src\\Tariffs.txt", tariffList);

        System.out.println(tariffList.getSize());
        System.out.println(tariffList.getTariff(0).getPricePerMinute());
        FileWork.addFromCodeToFile(tariffList);
        System.out.println(Tariff.callCost("78", 61));
    }
}
