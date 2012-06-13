package project.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DocumentoServiceTest extends AppEngineTestCase {

    private DocumentoService service = new DocumentoService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
