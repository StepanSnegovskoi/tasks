
public class Main {
    public static void main(String[] args) {
        TariffList tariffList = new TariffList();
        FileWork.addTariffFromMySrcFileInTariffList("Tariffs.txt", tariffList);
        FileWork.addTariffPathInTariffList("C:\\Users\\stepa\\IdeaProjects\\task1\\src\\Tariffs.txt", tariffList);

        System.out.println(tariffList.getSize());
        System.out.println(tariffList.getTariff(5).getPricePerMinute());
        FileWork.AddElementsFromCodeToFile(tariffList);
    }
}
