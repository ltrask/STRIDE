/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.major;

import DSS.DataStruct.PeriodATM;
import GUI.major.tableHelper.FREEVAL_DSS_TableModel;
import coreEngine.CEConst;
import coreEngine.Seed;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jltrask
 */
public class UserIOTableDisplay extends javax.swing.JPanel {

    private Seed seed;

    /**
     * Creates new form UserIOTableDisplay
     */
    public UserIOTableDisplay() {
        initComponents();

    }

    public void activate(MainWindowUser mainWindow) {
        seed = mainWindow.getActiveSeed();
        PeriodATM[] periodATM = new PeriodATM[seed.getValueInt(CEConst.IDS_NUM_PERIOD)];
        for (int per = 0; per < periodATM.length; per++) {
            periodATM[per] = new PeriodATM(seed, per);
        }
        FREEVAL_DSS_TableModel userInputModel = new FREEVAL_DSS_TableModel(seed, periodATM, userInputTable);
        userInputTable.setModel(userInputModel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        userInputTable.setDefaultRenderer(Object.class, centerRenderer);
        userInputTable.setDefaultRenderer(String.class, centerRenderer);
        userInputTable.setDefaultRenderer(Float.class, centerRenderer);
        userInputTable.setDefaultRenderer(Integer.class, centerRenderer);
        userInputTable.setFont(MainWindowUser.getTableFont());
        userInputTable.setRowHeight(MainWindowUser.getTableFont().getSize() + 4);
        userInputTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        userInputTable.getColumnModel().getColumn(0).setPreferredWidth(275);
        for (int colIdx = 1; colIdx < userInputModel.getColumnCount(); colIdx++) {
            userInputTable.getColumnModel().getColumn(colIdx).setPreferredWidth(75);
        }
        jScrollPane2.getHorizontalScrollBar().setModel(tableDisplay1.getScrollModel());

    }

    public TableDisplay getTableDisplay() {
        return this.tableDisplay1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        userInputTable = new javax.swing.JTable();
        tableDisplay1 = new GUI.major.TableDisplay();

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        userInputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(userInputTable);

        jSplitPane1.setRightComponent(jScrollPane2);
        jSplitPane1.setLeftComponent(tableDisplay1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private GUI.major.TableDisplay tableDisplay1;
    private javax.swing.JTable userInputTable;
    // End of variables declaration//GEN-END:variables
}
