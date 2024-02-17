
public class Tariff {

    private String directionCode;
    private String nameOfTheDirection;
    private double pricePerMinute;

    public Tariff(String directionCode, String nameOfTheDirection, double pricePerMinute) {
        this.directionCode = directionCode;
        this.nameOfTheDirection = nameOfTheDirection;
        this.pricePerMinute = pricePerMinute;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(String directionCode) {
        this.directionCode = directionCode;
    }

    public String getNameOfTheDirection() {
        return nameOfTheDirection;
    }

    public void setNameOfTheDirection(String nameOfTheDirection) {
        this.nameOfTheDirection = nameOfTheDirection;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(int priceMinute) {
        this.pricePerMinute = priceMinute;
    }

    public double callCost(String code, int second) {
        if (second < 6) {
            return 0;
        }
        return TariffList.findPricePerMinute(code) * Math.ceil(second / 60.0);
    }
}
