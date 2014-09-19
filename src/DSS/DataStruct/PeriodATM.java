/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSS.DataStruct;

import coreEngine.CEConst;
import coreEngine.Seed;
import java.util.Arrays;

/**
 *
 * @author jltrask
 */
public class PeriodATM {

    //Instance Specific variables
    private final int period;

    // Adjustment factors
    private final float[] caf;
    private final float[] saf;

    // Other ATM
    private final int[] rampMetering;
    private final Boolean[] rampMeteringUsed;

    // <editor-fold defaultstate="collapsed" desc="Indentifier Constants">
    private static final String ID_AFTYPE_CAF = "ID_AFTYPE_CAF";
    private static final String ID_AFTYPE_SAF = "ID_AFTYPE_SAF";
    private static final String ID_RAMP_METERING_USED = "ID_RAMP_METERING_USED";
    private static final String ID_RAMP_METERING = "ID_RAMP_METERING";
    // </editor-fold>

    public PeriodATM(Seed seed, int period) {
        // Settting period
        this.period = period;
        int numSeg = seed.getValueInt(CEConst.IDS_NUM_SEGMENT);

        // Initializing adjustment factor arrays
        caf = new float[numSeg];
        Arrays.fill(caf, 1.0f);
        saf = new float[numSeg];
        Arrays.fill(saf, 1.0f);

        //Initializing other arrays
        rampMeteringUsed = new Boolean[numSeg];
        Arrays.fill(rampMeteringUsed, false);
        rampMetering = new int[numSeg];
        Arrays.fill(rampMetering, -1);

    }

//<editor-fold defaultstate="collapsed" desc="Universal Getter">
    public float getValueFloat(String identifier, int period) {
        switch (identifier) {
            case ID_AFTYPE_CAF:
                return caf[period];
            case ID_AFTYPE_SAF:
                return saf[period];
            default:
                throw new RuntimeException("Invalid Identifier");
        }
    }

    public int getValueInt(String identifier, int period) {
        switch (identifier) {
            case ID_RAMP_METERING:
                return rampMetering[period];
            default:
                throw new RuntimeException("Invalid Identifier");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Universal Setter">
    public void setValueFloat(String identifier, float value, int period) {
        switch (identifier) {
            case ID_AFTYPE_CAF:
                caf[period] = value;
                break;
            case ID_AFTYPE_SAF:
                saf[period] = value;
                break;
            default:
                throw new RuntimeException("Invalid Identifier");
        }
    }

    public void setValueInt(String identifier, int value, int period) {
        switch (identifier) {
            case ID_RAMP_METERING:
                rampMetering[period] = value;
                break;
            default:
                throw new RuntimeException("Invalid Identifier");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Setters">
    public void setCAF(float value, int seg) {
        caf[seg] = value;
    }

    public void setSAF(float value, int seg) {
        saf[seg] = value;
    }

    public void setRMUsed(Boolean value, int seg) {
        rampMeteringUsed[seg] = value;
    }

    public void setRMRate(int value, int seg) {
        rampMetering[seg] = value;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters">
    public int getPeriod() {
        return period;
    }

    public float getCAF(int seg) {
        return caf[seg];
    }

    public float getSAF(int seg) {
        return saf[seg];
    }

    public Boolean getRMUsed(int seg) {
        return rampMeteringUsed[seg];
    }

    public int getRMRate(int period) {
        return rampMetering[period];
    }
//</editor-fold>

}