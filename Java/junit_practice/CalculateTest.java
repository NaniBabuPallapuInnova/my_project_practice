package junit_practice;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @Test annotation specifies that method is the test method.
 *
 * @Test(timeout=1000) annotation specifies that method will be failed if it takes longer than 1000 milliseconds (1 second).
 *
 * @BeforeClass annotation specifies that method will be invoked only once, before starting all the tests.
 *
 * @Before annotation specifies that method will be invoked before each test.
 *
 * @After annotation specifies that method will be invoked after each test.
 *
 * @AfterClass annotation specifies that method will be invoked only once, after finishing all the tests.
 *
 *
 *
 *
 * void assertEquals(boolean expected,boolean actual): checks that two primitives/objects are equal. It is overloaded.
 * void assertTrue(boolean condition): checks that a condition is true.
 * void assertFalse(boolean condition): checks that a condition is false.
 * void assertNull(Object obj): checks that object is null.
 * void assertNotNull(Object obj): checks that object is not null.
 *
 */
public class CalculateTest {

    @Test
    public void testFindMax() {
        System.out.println("THIS IS TEST FIND MAX METHOD == 1");
        assertEquals(9, Calculate.findMaxElementInArray(new int[]{1, 3, 6, 4, 8, 2, 9}));
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("CALLING BEFORE CLASS ");
    }

    @Before
    public void before(){
        System.out.println("CALLING BEFORE ");
    }

    @Test
    public void test2FindMax() {
        System.out.println("THIS IS TEST FIND MAX METHOD == 2");
        assertEquals(9, Calculate.findMaxElementInArray(new int[]{1, 3, 6, 4, 8, 2, 9}));
    }


    @Test
    public void test3FindMax() {
        System.out.println("THIS IS TEST FIND MAX METHOD == 3");
        assertEquals(9, Calculate.findMaxElementInArray(new int[]{1, 3, 6, 4, 8, 2, 9}));
    }

    @After
    public void after(){
        System.out.println("CALLING AFTER METHOD");
        assertEquals(9, Calculate.findMaxElementInArray(new int[]{1, 3, 6, 4, 8, 2, 9}));
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("CALLING AFTER CLASS METHOD");
        assertEquals(9, Calculate.findMaxElementInArray(new int[]{1, 3, 6, 4, 8, 2, 9}));
    }
}
