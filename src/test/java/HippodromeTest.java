import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class HippodromeTest {
    @Test
    public void constructor_NeedThrowException_WhenNameIsNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }
    @Test
    public void constructor_NeedThrowException_WhenNameIsEmpty() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }
    @Test
    public void getHorsesTest(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
        horses.add(new Horse("Horse"+i,10+i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        List<Horse> horsesList=hippodrome.getHorses();
        assertEquals(horses.size(),horsesList.size());
        for (int i = 0; i <horses.size() ; i++) {
            assertEquals(horses.get(i),horsesList.get(i));
        }
    }
    @Test
    public void moveTest(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for(Horse horse : horses){
            verify(horse).move();
        }
    }
    @Test
    public void getWinnerTest(){
    Horse horse1 = new Horse("Bucephalus", 2.4,60);
    Horse horse2 = new Horse("Ace of Spades", 2.5,70);
    Horse horse3 = new Horse("Zephyr", 2.6,80);
        List<Horse> horses = List.of(horse1, horse2,horse3);
        Hippodrome hippodrome = new Hippodrome(horses);
        Horse winner = hippodrome.getWinner();
        assertEquals(horse3, winner);
    }

}
