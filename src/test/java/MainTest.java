import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@Disabled
@Timeout(value = 22)
public class MainTest {
    @Test
    public void mainTest() throws Exception{
Main.main(null);
    }
}
