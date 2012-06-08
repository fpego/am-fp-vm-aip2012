package project.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DocumentoTest extends AppEngineTestCase {

    private Documento model = new Documento();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
