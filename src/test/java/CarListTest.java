import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    void when1ElementRemovedByIndexThenSizeMustBeDecreasedBy1() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    void whenElementRemovedThenSizeMustBeDecreasedBy1() {
        Car car = new Car("Brand101", 101);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    void whenNonExistedElementRemovedThenReturnFalse() {
        Car car = new Car("aawd", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    void whenClearThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    void whenIndexOutOfBoundException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carList.get(carList.size() + 1);
        });
    }

    @Test
    void whenMethodGetReturnRightValue () {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }
}