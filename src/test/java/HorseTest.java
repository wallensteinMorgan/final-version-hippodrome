

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
public class HorseTest {
    @Test
    public void constructor_NeedThrowException_WhenNameIsNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 3.0, 2.2));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @Test
    public void exceptionNegativeNumberSecond() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse("name", -2.7, 2.2));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    public void exceptionNegativeNumberThird() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse("name", 2.7, -2.2));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t\t", "\n\n\n"})
    public void exceptionBlankName(String blankName) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(blankName, 2.7, 2.2));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    public void getNameTest(){
        Horse horse = new Horse("horse",12.0,2.0);
        Assertions.assertEquals("horse", horse.getName());
    }
    @Test
    public void getSpeedTest(){
        Horse horse = new Horse("horse",12.0,2.0);
        Assertions.assertEquals(12.0, horse.getSpeed());
    }
    @Test
    public void getDistance(){
        Horse horse = new Horse("horse",12.0,2.0);
        Assertions.assertEquals(2.0, horse.getDistance());
    }
    public void getDistance_NeedToReturnXeroTest() {
        Horse horse = new Horse("horse",12.0);
        Assertions.assertEquals(0.0, horse.getDistance());
    }
    @Test
    public void moveTest(){
        try (MockedStatic<Horse> mockedStatic= mockStatic(Horse.class)) {
            Horse horse = new Horse("horse",12.0,2.0);
            mockedStatic.when(()-> Horse.getRandomDouble(0.2,0.9)).thenReturn(0.5);
            horse.move();
            mockedStatic.verify(()->Horse.getRandomDouble(0.2,0.9));
            assertEquals(2.0+12.0*0.5,horse.getDistance());
        }
    }

}