package project.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RicercatoreProgettoTest extends AppEngineTestCase {

    private RicercatoreProgetto model = new RicercatoreProgetto();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
