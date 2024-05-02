import java.util.LinkedList;

public class Car {
    private String brand;
    private int number;

    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;

    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3};
        int[] array1 = new int[3];
        int[] array2 = {1,2,3};
        System.out.println(array1[2]);
    }
}
