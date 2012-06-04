package project.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RicercatoreTest extends AppEngineTestCase {

    private Ricercatore model = new Ricercatore();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
