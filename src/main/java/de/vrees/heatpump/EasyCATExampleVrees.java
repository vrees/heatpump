package de.vrees.heatpump;

import de.vrees.heatpump.slaves.beckhoff.EL1008;
import de.vrees.heatpump.slaves.beckhoff.EL2008;
import de.vrees.heatpump.slaves.beckhoff.EL3122;
import us.ihmc.etherCAT.master.EtherCATRealtimeThread;
import us.ihmc.etherCAT.slaves.beckhoff.EK1100;
import us.ihmc.realtime.MonotonicTime;
import us.ihmc.realtime.PriorityParameters;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This is an example for testing an EasyCAT module with the IHMC etherCAT
 * Master code stack. The EasyCAT module must be coupled with an arduino board
 * running the standard easyCAT demo (32 byte frames). Make sure the arduino is
 * powered and the etherCAT cable properly connected.
 * <p>
 * This demo will attempt to read 4 different digital bytes and 1 analog byte
 * from two different easyCat slaves and display the results graphically through
 * a simple swing-based UI. If only one slave is desired comment out the code
 * appropriately.
 *
 * @author dduran
 */
public class EasyCATExampleVrees extends EtherCATRealtimeThread {

    private final EK1100 ek1100 = new EK1100(0, 0); // Coupler
    private final EL1008 el1008 = new EL1008(0, 1); // 8-fach Digital Input
    private final EL2008 el2008 = new EL2008(0, 2); // 8-fach Digital Output
    private final EL3122 el3122 = new EL3122(0, 3); // EL3122 | 2-Kanal-Analog-Eingangsklemme 4…20 mA, Differenzeingang, 16 Bit

    private static String networkCard = "enp3s0";
    private int counter = 0;


    private JFrame frame;
    private JLabel button1Label;
    private static volatile boolean button1 = false;
    private Thread uiButtonsThread;


    public static void main(String args[]) throws IOException {
        /*
         * Enumeration<NetworkInterface> nets; try { nets =
         * NetworkInterface.getNetworkInterfaces(); for (NetworkInterface netint :
         * Collections.list(nets)) displayInterfaceInformation(netint);
         *
         * } catch (SocketException e) { // TODO Auto-generated catch block
         * e.printStackTrace(); }
         */
        EasyCATExampleVrees easyCat = new EasyCATExampleVrees();
        easyCat.start();
        easyCat.join();

    }

    public EasyCATExampleVrees() throws IOException {
        super(networkCard, new PriorityParameters(PriorityParameters.getMaximumPriority()),
                new MonotonicTime(0, 1000000), true, 100000);

        System.out.println("Starting EtherCAT");
        System.out.println("Registering Slave...");

        registerSlave(ek1100);
        registerSlave(el1008);
        registerSlave(el2008);
        registerSlave(el3122);

        // Run the UI on its own thread
        Thread thread = new Thread("UI Thread") {
            public void run() {
                setupUI();
            }

        };

        thread.start();
    }

    @Override
    protected void workingCounterMismatch(int expected, int actual) {
        System.out.println("Working counter mismatch!!!");
    }


    @Override
    protected void deadlineMissed() {
        System.out.println("Deadlines missed so far: " + counter);
        counter++;
    }

    @Override
    protected void doControl() {
        if (counter++ % 2000 == 0) {

            System.out.println(el3122 + ": " + el3122.toProcessdataString());
        }
    }

    @Override
    protected void doReporting() {

    }

    @Override
    protected void datagramLost() {
        System.out.println("DATAGRAM Lost!!");

    }


    public void setupUI() {

        frame = new JFrame("CED - EtherCAT Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        button1Label = new JLabel("  Button 1  ");
        panel.add(button1Label);

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

        button1Label.setOpaque((true));

        button1Label.setBackground(Color.GRAY);

        uiButtonsThread = new Thread("UI Buttons") {

            public void run() {

                while (true) {

                    synchronized (uiButtonsThread) {

                        try {
                            uiButtonsThread.wait();
                            updateUI();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }

        };

        uiButtonsThread.start();
    }

    public void updateUI() {

        button1Label.updateUI();

        if (button1) {
            button1Label.setBackground(Color.GREEN);

        } else {
            button1Label.setBackground(Color.GRAY);
        }

        frame.pack();

    }
}
