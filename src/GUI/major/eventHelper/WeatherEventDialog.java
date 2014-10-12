/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.major.eventHelper;

import DSS.DataStruct.ScenarioEvent;
import coreEngine.CEConst;
import static coreEngine.CEConst.IDS_NUM_PERIOD;
import coreEngine.Seed;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jltrask
 */
public class WeatherEventDialog extends javax.swing.JDialog {

    private Seed seed;

    private boolean status;

    /**
     * Creates new form weatherEventDialog
     */
    public WeatherEventDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
        resetPanel();
    }

    private void resetPanel() {
        startPeriodCB.setModel(periodCBModelCreator(0));
        endPeriodCB.setModel(periodCBModelCreator(1));
    }

    public ScenarioEvent getWeatherEvent() {
        ScenarioEvent wEvent = new ScenarioEvent(ScenarioEvent.WEATHER_EVENT);
        wEvent.startSegment = 0;
        wEvent.endSegment = seed.getValueInt(CEConst.IDS_NUM_SEGMENT) - 1;
        wEvent.startPeriod = startPeriodCB.getSelectedIndex();
        wEvent.endPeriod = Integer.parseInt(((String) endPeriodCB.getSelectedItem()).split(" ")[0]) - 1;
        wEvent.caf = Float.parseFloat(cafTextField.getText());
        wEvent.daf = Float.parseFloat(dafTextField.getText());
        wEvent.saf = Float.parseFloat(safTextField.getText());
        wEvent.laf = 0;
        return wEvent;

    }

    /**
     * Creates the model for the period selection combo box. The type designates
     * whether it is for start period (0) selection or end period selection (1).
     * End period selection indicates that the periods go through the end
     * period, and the clock time displayed is the time at the end of the period
     * (as opposed to clock time at the beginning of the period for start
     * times).
     *
     * @param type
     * @return
     */
    private DefaultComboBoxModel periodCBModelCreator(int type) {
        String[] tempArr = new String[seed.getValueInt(IDS_NUM_PERIOD)];
        //tempArr[0] = "<Select Period>";
        int currHour = seed.getStartTime().hour;
        int currMin = seed.getStartTime().minute;
        if (type == 1) {
            currMin += 15;
        }
        for (int perIdx = 1; perIdx <= tempArr.length - 1; perIdx++) {
            if (currMin == 60) {
                currMin = 0;
                currHour++;
            }
            if (currMin == 0) {
                tempArr[perIdx - 1] = String.valueOf(perIdx) + "  (" + currHour + ":00)";
            } else {
                tempArr[perIdx - 1] = String.valueOf(perIdx) + "  (" + currHour + ":" + currMin + ")";
            }
            currMin += 15;
        }

        return new DefaultComboBoxModel(tempArr);
    }

    /**
     * Creates the model for the period selection combo box. The type designates
     * whether it is for start period (0) selection or end period selection (1).
     * End period selection indicates that the periods go through the end
     * period, and the clock time displayed is the time at the end of the period
     * (as opposed to clock time at the beginning of the period for start
     * times).
     *
     * @param type
     * @param startPeriod
     * @return
     */
    private DefaultComboBoxModel periodCBModelCreator(int type, int startPeriod) {
        String[] tempArr = new String[seed.getValueInt(IDS_NUM_PERIOD) - (startPeriod - 1)];
        //tempArr[0] = "<Select Period>";
        int currHour = seed.getStartTime().hour;
        int currMin = seed.getStartTime().minute;
        if (type == 1) {
            currMin += 15;
        }
        int currIdx = 0;
        for (int perIdx = 1; perIdx <= tempArr.length - 1; perIdx++) {
            if (currMin == 60) {
                currMin = 0;
                currHour++;
            }
            if (perIdx >= startPeriod) {
                if (currMin == 0) {
                    tempArr[currIdx] = String.valueOf(perIdx) + "  (" + currHour + ":00)";
                } else {
                    tempArr[currIdx] = String.valueOf(perIdx) + "  (" + currHour + ":" + currMin + ")";
                }
                currIdx++;
            }
            currMin += 15;

        }

        return new DefaultComboBoxModel(tempArr);
    }

    public boolean getReturnStatus() {
        return status;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cafTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        safTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dafTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        severityCB = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        startPeriodCB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        endPeriodCB = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Weather Event");

        jPanel1.setLayout(new java.awt.GridLayout(3, 2));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Enter CAF:");
        jPanel1.add(jLabel3);

        cafTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cafTextField.setText("1.0");
        jPanel1.add(cafTextField);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Enter SAF:");
        jPanel1.add(jLabel5);

        safTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        safTextField.setText("1.0");
        jPanel1.add(safTextField);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Enter DAF:");
        jPanel1.add(jLabel4);

        dafTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dafTextField.setText("1.0");
        jPanel1.add(dafTextField);

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Weather Severity Type:");
        jPanel2.add(jLabel1);

        severityCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Select Type>", "Medium Rain", "Heavy Rain", "Light Snow", "Light Medium Snow", "Medium Heavy Snow", "Heavy Snow", "Severe Cold", "Low Visibility", "Very Low Visibility", "Minimum Visibility" }));
        jPanel2.add(severityCB);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Starting in Period:");
        jPanel2.add(jLabel6);

        startPeriodCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Select Period>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", " ", " " }));
        startPeriodCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                startPeriodCBItemStateChanged(evt);
            }
        });
        jPanel2.add(startPeriodCB);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ending in Period:");
        jPanel2.add(jLabel2);

        endPeriodCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Select Period>" }));
        jPanel2.add(endPeriodCB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        status = false;
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        status = true;
        this.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void startPeriodCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_startPeriodCBItemStateChanged
        int endCBidx = endPeriodCB.getSelectedIndex();
        int startCBidx = startPeriodCB.getSelectedIndex();
        endPeriodCB.setModel(periodCBModelCreator(1, startPeriodCB.getSelectedIndex() + 1));
        if (endCBidx >= startCBidx) {
            endPeriodCB.setSelectedIndex(endCBidx - startCBidx);
        } else {
            endPeriodCB.setSelectedIndex(0);
        }

    }//GEN-LAST:event_startPeriodCBItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cafTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dafTextField;
    private javax.swing.JComboBox endPeriodCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField safTextField;
    private javax.swing.JComboBox severityCB;
    private javax.swing.JComboBox startPeriodCB;
    // End of variables declaration//GEN-END:variables
}
