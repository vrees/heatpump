package de.vrees.heatpump.heatpump.slaves.beckhoff;

import us.ihmc.etherCAT.master.Slave;
import us.ihmc.etherCAT.master.SyncManager;
import us.ihmc.etherCAT.master.TxPDO;

public class EL1008 extends Slave {
    private static final long vendorID = 0x00000002L;
    private static final long productCode = 0x03f03052L;


    public class Input extends TxPDO {

        protected Input(int address) {
            super(address);
        }

        Bool input = new Bool();
    }

    private final Input in1 = new Input(0x1a00);
    private final Input in2 = new Input(0x1a01);
    private final Input in3 = new Input(0x1a02);
    private final Input in4 = new Input(0x1a03);
    private final Input in5 = new Input(0x1a04);
    private final Input in6 = new Input(0x1a05);
    private final Input in7 = new Input(0x1a06);
    private final Input in8 = new Input(0x1a07);

    public EL1008(int aliasAddress, int configAddress) {
        super(vendorID, productCode, aliasAddress, configAddress);

        registerSyncManager(new SyncManager(0, false));

        sm(0).registerPDO(in1);
        sm(0).registerPDO(in2);
        sm(0).registerPDO(in3);
        sm(0).registerPDO(in4);
        sm(0).registerPDO(in4);
        sm(0).registerPDO(in6);
        sm(0).registerPDO(in7);
        sm(0).registerPDO(in8);
    }

    public boolean getInput1() {
        return in1.input.get();
    }

    public boolean getInput2() {
        return in2.input.get();
    }

    public boolean getInput3() {
        return in3.input.get();
    }

    public boolean getInput4() {
        return in4.input.get();
    }

    public boolean getInput5() {
        return in5.input.get();
    }

    public boolean getInput6() {
        return in6.input.get();
    }

    public boolean getInput7() {
        return in7.input.get();
    }

    public boolean getInput8() {
        return in8.input.get();
    }
}
