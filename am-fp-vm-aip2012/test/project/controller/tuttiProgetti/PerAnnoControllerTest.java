package project.controller.tuttiProgetti;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PerAnnoControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/tuttiProgetti/perAnno");
        PerAnnoController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/tuttiProgetti/perAnno.jsp"));
    }
}