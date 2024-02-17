
import java.util.Arrays;

public class TariffList {
    private static Tariff[] tariffs = new Tariff[10];
    private int size = 0;

    public Tariff getTariff(int index) {
        checkIndex(index);
        return tariffs[index];
    }

    public void add(Tariff tariff) {
        increaseArray();
        tariffs[size] = tariff;
        size++;
    }

    public boolean remove(Tariff tariff) {
        for (int i = 0; i < size; i++) {
            if (tariffs[i].equals(tariff)) {
                return removeAt(i);
            }
        }
        return false;
    }

    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            tariffs[index] = tariffs[index + 1];
        }
        size--;
        tariffs[size] = null;
        return true;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        tariffs = new Tariff[0];
        size = 0;
    }

    public void add(Tariff tariff, int index) {
        checkIndex(index);
        increaseArray();
        for (int i = size; i > index; i--) {
            tariffs[i] = tariffs[i - 1];
        }
        tariffs[index] = tariff;
        size++;
    }

    public static double findPricePerMinute(String code) {
        for (Tariff tariff : tariffs) {
            if (tariff.getDirectionCode().equals(code)) {
                return tariff.getPricePerMinute();
            } else {
                throw new RuntimeException("Такого кода не существует");
            }
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= tariffs.length) {
            tariffs = Arrays.copyOf(tariffs, tariffs.length * 2);
        }
    }

}
