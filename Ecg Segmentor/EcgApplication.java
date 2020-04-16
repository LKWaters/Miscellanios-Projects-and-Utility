package bio.ecg;

import gui.ClosableJFrame;
import gui.run.RunMenu;
import gui.run.RunMenuBar;
import gui.run.RunMenuItem;

import javax.swing.*;


public class EcgApplication extends ClosableJFrame {
    EcgParam paramOb;
    EcgParamWindow paramWin;
    EcgLogWindow logWin;
    EcgPlotWindow plotWin;
    private javax.swing.JDesktopPane mainDesktop;


    /**
     * Creates new form ecgApplication
     */
    public EcgApplication() {
        initComponents();
        initClasses();
        initWindow();
    }


    private void initClasses() {
        paramOb = new EcgParam();
        logWin = new EcgLogWindow();
        paramWin = new EcgParamWindow(paramOb, logWin);
    }

    private void initWindow() {
        this.setSize(880, 600);
        mainDesktop.add(paramWin);
        mainDesktop.add(logWin);
    }

    private void initComponents() {
        mainDesktop = new javax.swing.JDesktopPane();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Java ECG Generator");
        mainDesktop.add(getMainLabel(), javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(mainDesktop, java.awt.BorderLayout.CENTER);
        setJMenuBar(getRunMenuBar());

        pack();
    }

    private JLabel getMainLabel() {
        JLabel jl = new JLabel();
        jl.setFont(new java.awt.Font("MS Sans Serif", 3, 36));
        jl.setForeground(new java.awt.Color(255, 255, 255));
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setText("Java ECG Generator");
        jl.setBounds(0, 0, 530, 260);
        return jl;
    }


    private RunMenuBar getRunMenuBar() {
        RunMenuBar rmb = new RunMenuBar();
        rmb.add(getAppMenu());
        rmb.add(getSettingsMenu());
        rmb.add(getSystemMenu());
        return rmb;
    }

    private RunMenu getSystemMenu() {
        RunMenu rm = new RunMenu("ECG");
        rm.add(new RunMenuItem("Generate ECG") {
            @Override
            public void run() {
                //GEN-FIRST:event_generateMenuActionPerformed

                plotWin = new EcgPlotWindow(paramOb, logWin);
                mainDesktop.add(plotWin);
                plotWin.show();
            }
        });
        rm.add(new RunMenuItem("PSD from csv") {
            @Override
            public void run() {
                HW8.psd();
            }
        });
        rm.add(new RunMenuItem("PSD from generated data") {
            @Override
            public void run() {
                //todo This is where your HW8 appears
                System.out.println("You must " +
                        "implement this");
                plotWin.getEcgCalc().print();

            }
        });
        rm.add(new RunMenuItem("ECG System Log") {
            @Override
            public void run() {
                //GEN-FIRST:event_sysLogMenuActionPerformed
                // TODO add your handling code here:
                logWin.show();
            }
        });
        return rm;
    }

    private RunMenu getSettingsMenu() {
        RunMenu settingsMenu = new RunMenu
                ("[Settings");
        settingsMenu.add(new RunMenuItem("[ECG" +
                " Parameters") {
            @Override
            public void run() {
                //GEN-FIRST:event_paramMenuActionPerformed
                // TODO add your handling code here:
                paramWin.show();
            }
        });
        return settingsMenu;
    }

    private RunMenu getAppMenu() {
        RunMenu appMenu = new RunMenu
                ("[Application");
        appMenu.add(new RunMenuItem
                ("[Quit") {
            @Override
            public void run() {
                System.exit(0);
            }
        });
        return appMenu;
    }


    public static void main(String args[]) {
        new EcgApplication().setVisible(true);
    }

}
