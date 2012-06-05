package project.controller.commissioneEuropea;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ContattiControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/commissioneEuropea/contatti");
        ContattiController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/commissioneEuropea/contatti.jsp"));
    }
}
