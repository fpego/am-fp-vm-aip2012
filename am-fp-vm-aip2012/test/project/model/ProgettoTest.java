package project.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProgettoTest extends AppEngineTestCase {

    private Progetto model = new Progetto();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
