package net.mjc;

import junit.framework.TestCase;
import org.junit.*;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import java.io.IOException;

public class TestServletTest extends TestCase {

    @Before
    public void before() {
        System.out.println("FwdProxyServletTest.before");
        MockitoAnnotations.initMocks(TestServletTest.class);
    }

    @After
    public void after() {
        System.out.println("FwdProxyServletTest.after");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("FwdProxyServletTest.afterClass");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("FwdProxyServletTest.beforeClass");
    }

    @Test
    public void testA() throws IOException, ServletException {
        System.out.println("FwdProxyServletTest.testA");
    }
}