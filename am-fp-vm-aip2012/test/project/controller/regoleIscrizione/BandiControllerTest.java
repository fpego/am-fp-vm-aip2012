package project.controller.regoleIscrizione;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BandiControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/regoleIscrizione/bandi");
        BandiController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/regoleIscrizione/bandi.jsp"));
    }
}
