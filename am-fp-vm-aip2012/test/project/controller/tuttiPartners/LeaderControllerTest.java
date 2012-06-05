package project.controller.tuttiPartners;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LeaderControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/tuttiPartners/leader");
        LeaderController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/tuttiPartners/leader.jsp"));
    }
}
