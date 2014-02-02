/**
 *
 * File: Computer.java
 * @author Ying Ni (pid niy1987)
 * @version 01/24/2014
 *
 */
public class Computer {
    private String processor;
    private int numCore;
    private double processorSpeed;
    /**
     * Creates a computer with all the detailed information
     * @param processor The processor of the computer
     * @param numCore The number of cores of the computer
     * @param processorSpeed The processor speed of the computer
     */
    public Computer(String processor, int numCore, double processorSpeed)
    {
        this.processor = processor;
        this.numCore = numCore;
        this.processorSpeed = processorSpeed;
    }
    /**
     *
     * @return The processor of the computer
     */
    public String getProcessor()
    {
        return processor;
    }
    /**
     *
     * @return The number of cores of the computer
     */
    public int getNumCore()
    {
        return numCore;
    }
    /**
     *
     * @return The processor speed of the computer
     */
    public double getProcessorSpeed()
    {
        return processorSpeed;
    }
    /**
     * @param processor Set the processor of a computer
     */
    public void setProcessor(String processor)
    {
        this.processor = processor;
    }
    /**
     * @param numCore Set the number of cores of a computer
     */
    public void setNumCore(int numCore)
    {
        this.numCore = numCore;
    }
    /**
     * @param processorSpeed Set the processor speed of a computer
     */
    public void setProcessorSpeed(double processorSpeed)
    {
        this.processorSpeed = processorSpeed;
    }
    /**
     * @return The computer power
     */
    public double computerPower()
    {
        return processorSpeed * numCore;
    }
    /**
     * @return The string which describes the computer
     */
    public String toString()
    {
        return processor + ", " + numCore + " cores at " + processorSpeed + "GHz";
    }
}
