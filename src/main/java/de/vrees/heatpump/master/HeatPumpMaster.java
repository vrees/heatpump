package de.vrees.heatpump.master;

import de.vrees.heatpump.slaves.beckhoff.EL1008;
import de.vrees.heatpump.slaves.beckhoff.EL2008;
import us.ihmc.etherCAT.master.EtherCATRealtimeThread;
import us.ihmc.etherCAT.slaves.beckhoff.*;
import us.ihmc.realtime.MonotonicTime;
import us.ihmc.realtime.PriorityParameters;

public class HeatPumpMaster extends EtherCATRealtimeThread {
    private final EK1100 ek1100 = new EK1100(0, 0); // Coupler
    private final EL1008 el1008 = new EL1008(0, 1); // 8-fach Digital Input
    private final EL2008 el2008 = new EL2008(0, 2); // 8-fach Digital Output
    private int counter = 0;

    public HeatPumpMaster() {
        super("enp3s0", PriorityParameters.MAXIMUM_PRIORITY, new MonotonicTime(0, 1000000), true, 100000);
        registerSlave(ek1100);
        registerSlave(el1008);
        registerSlave(el2008);
//      registerSlave(el4134);
        setRequireAllSlaves(false);
        enableTrace();
    }


    @Override
    protected void deadlineMissed() {
        System.out.println("deadlineMissed()");
    }

    @Override
    protected void doControl() {
        if (counter++ % 1000 == 0) {
            System.out.println("Input1: " + el1008.getInput1()
                    + ", Input2: " + el1008.getInput2()
                    + ", Input3: " + el1008.getInput3()
                    + ", Input4: " + el1008.getInput4()
                    + ", Input5: " + el1008.getInput5()
                    + ", Input6: " + el1008.getInput6()
                    + ", Input7: " + el1008.getInput7()
                    + ", Input8: " + el1008.getInput8()
            );

            el2008.setOut1(true);
            el2008.setOut2(true);
            el2008.setOut3(true);
            el2008.setOut4(true);


            System.out.println("Slaves: " + getSlaves().get(1));
        }
    }

    public static void main(String[] args) {
        HeatPumpMaster heatpumpExample = new HeatPumpMaster();
        heatpumpExample.start();
        heatpumpExample.join();
    }

    @Override
    protected void workingCounterMismatch(int expected, int actual) {
        System.out.println("workingCounterMismatch() actual=" + actual + ", expected=" + expected);
    }

    @Override
    protected void datagramLost() {
        System.out.println("DATAGRAM LOST");
    }

    @Override
    protected void doReporting() {
        // TODO Auto-generated method stub

    }
}
