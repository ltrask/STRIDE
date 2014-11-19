package GUI.major;

import Toolbox.DSS.GUI.major.MainWindow;
import GUI.major.tableHelper.SegIOTableWithSetting;
import GUI.major.tableHelper.SplitTableJPanel;
import GUI.major.tableHelper.TableCellSetting;
import coreEngine.Seed;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BoundedRangeModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This is the major table display for segment inputs and outputs.
 *
 * @author Shu Liu
 */
public class TableDisplay extends javax.swing.JPanel {

    private MainWindow mainWindow;

    /**
     * Creates new form TableDisplay
     */
    public TableDisplay() {
        initComponents();
        segIOTable = new SegIOTableWithSetting();
        segIOSplitTable
                = new SplitTableJPanel(segIOTable.getFirstColumnTable(), segIOTable.getRestColumnTable());
        segIOSplitTable.setDividerLocation(270);
        add(segIOSplitTable);

        //set up for set highlight
        ListSelectionListener listener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int col = segIOTable.getRestColumnTable().getSelectedColumn();
                if (col >= 0) {
                    mainWindow.segmentSelectedByTable(col);
                }
            }
        };

        //segIOTable.getRestColumnTable().getSelectionModel().addListSelectionListener(listener);
        segIOTable.getRestColumnTable().getColumnModel().getSelectionModel().addListSelectionListener(listener);
    }

    /**
     * Show data for a particular seed, scenario and period
     *
     * @param seed seed to be displayed
     * @param scen index of scenario to be displayed
     * @param atdm
     * @param period index of period to be displayed
     */
    public void selectSeedScenATDMPeriod(Seed seed, int scen, int atdm, int period) {
        segIOTable.selectSeedScenPeriod(seed, scen, atdm, period);
    }

    /**
     * Show input
     */
    public void showInput() {
        segIOTable.showInput();
    }

    /**
     * Show output
     */
    public void showOutput() {
        segIOTable.showOutput();
    }

    /**
     * Update table
     */
    public void update() {
        segIOTable.update();
    }

    /**
     * Highlight a particular segment
     *
     * @param seg segment index (start with 0) to be highlighted
     */
    public void setHighlight(int seg) {
        //set which segment to be highlighted
        if (seg >= 0) {
            segIOTable.getRestColumnTable().setColumnSelectionInterval(seg, seg);
        }
    }

    public void showGPOnly() {
        segIOTable.showGPOnly();
    }

    public void showMLOnly() {
        segIOTable.showMLOnly();
    }

    public void showGPML() {
        segIOTable.showGPML();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="setter and getters">
    /**
     * Setter for mainWindow connection
     *
     * @param mainWindow main window instance
     */
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        segIOTable.setMainWindow(mainWindow);
    }

    /**
     * Getter for segIOTable
     *
     * @return segIOTable instance
     */
    public SegIOTableWithSetting getSegIOTable() {
        return segIOTable;
    }

    /**
     * Setter for new cell settings to be used
     *
     * @param cellSettings new cell settings to be used
     */
    public void setCellSettings(ArrayList<TableCellSetting> cellSettings) {
        segIOTable.setCellSettings(cellSettings);
    }

    /**
     * Setter for table font
     *
     * @param newTableFont new table font
     */
    public void setTableFont(Font newTableFont) {
        segIOTable.setTableFont(newTableFont);
        segIOTable.getFirstColumnTable().setFont(newTableFont);
        segIOTable.getFirstColumnTable().setRowHeight(newTableFont.getSize() + 2);
        segIOTable.getRestColumnTable().setFont(newTableFont);
        segIOTable.getRestColumnTable().setRowHeight(newTableFont.getSize() + 2);
    }

    public BoundedRangeModel getScrollModel() {
        return segIOSplitTable.getScrollModel();
    }

    // </editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private SegIOTableWithSetting segIOTable;
    private final SplitTableJPanel segIOSplitTable;
}
