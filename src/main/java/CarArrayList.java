import java.util.ArrayList;
import java.util.Arrays;

public class CarArrayList implements CarList {

    private Car[] array = new Car[10];
    private int size;

    @Override
    public Car get(int index) {
        checkIfIndexNotOutOfBoundsThenThrowException(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        ifNeedToCreateNewArrayThenCreateArrayWithLengthMultiple2();
        array[size] = car;
        size++;
    }

    @Override
    public void add(Car car, int index) {
        ifNeedToCreateNewArrayThenCreateArrayWithLengthMultiple2();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIfIndexNotOutOfBoundsThenThrowException(index);
        System.arraycopy(array, index + 1, array, index - 1, size - 1 - index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    private void checkIfIndexNotOutOfBoundsThenThrowException(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ifNeedToCreateNewArrayThenCreateArrayWithLengthMultiple2() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
