import controllers.*;
import org.junit.Test;

/**
 * Unit tests for Controller.
 *
 * @author Braeden Kloke
 * @version March 14, 2024
 */
public class ControllerTest {

    @Test
    public void testDBConnection() {
        assert new UserController().getHealth();
    }
}
