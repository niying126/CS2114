/**
 *
 * File: ComputerTest.java
 * @author Ying Ni (pid niy1987)
 * @version 01/24/2014
 *
 */
import student.*;
public class ComputerTest extends student.TestCase
{
    private Computer c;
    /**
     * Create a computer test
     */
    public ComputerTest()
    {}
    /**
     * Set up the text fixture
     */
    public void setUp()
    {
        c = new Computer("Duo", 2, 2.0);
    }
    /**
     * Test the getProcessor() method
     */
    public void testGetProcessor()
    {
        assertEquals("Duo", c.getProcessor());
    }
    /**
     * Test the getNumCore() method
     */
    public void testGetnumCore()
    {
        assertEquals(2, c.getNumCore());
    }
    /**
     * Test the getProcessorSpeed() method
     */
    public void testGetProcessorSpeed()
    {
        assertEquals(2.0, c.getProcessorSpeed(), 0.01);
    }
    /**
     * Test the setProcessor() method
     */
    public void testSetProcessor()
    {
        c.setProcessor("Du");
        assertEquals("Du", c.getProcessor());
    }
    /**
     * Test the setNumCore() method
     */
    public void testSetNumCore()
    {
        c.setNumCore(3);
        assertEquals(3, c.getNumCore());
    }
    /**
     * Test the getProcessorSpeed() method
     */
    public void testProcessorSpeed()
    {
        c.setProcessorSpeed(3.0);
        assertEquals(3.0, c.getProcessorSpeed(), 0.01);
    }
    /**
     * Test the computerPower() method
     */
    public void testComputerPower()
    {
        assertEquals(4.0, c.computerPower(), 0.01);
    }
    /**
     * Test the toString() method
     */
    public void testToString()
    {
        c = new Computer("Core Duo", 2, 2.0);
        assertEquals("Core Duo, 2 cores at 2.0GHz", c.toString());
    }
}
