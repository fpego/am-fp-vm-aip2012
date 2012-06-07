package project.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PartnerServiceTest extends AppEngineTestCase {

    private PartnerService service = new PartnerService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
