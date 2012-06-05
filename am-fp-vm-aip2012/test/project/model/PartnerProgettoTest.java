package project.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PartnerProgettoTest extends AppEngineTestCase {

    private PartnerProgetto model = new PartnerProgetto();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
