package project.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import com.google.appengine.api.datastore.Key;

import project.model.Progetto;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProgettoServiceTest extends AppEngineTestCase {

    private ProgettoService service = new ProgettoService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
