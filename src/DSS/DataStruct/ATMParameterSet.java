/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSS.DataStruct;

import coreEngine.Helper.CEConst;
import coreEngine.Seed;
import java.util.Arrays;

/**
 *
 * @author jltrask
 */
public class ATMParameterSet {

    public float hsrCapacity[];
    public Boolean[] diversionAtSeg;

    public final static String ID_HSR_TYPE_PERCENT_OF_MAINLINE_LANE = "ID_HSR_TYPE_PERCENT_OF_MAINLINE_LANE";
    public final static String ID_HSR_TYPE_VPH = "ID_HSR_TYPE_VPH";

    private final static float[] HSR_Capacities = new float[]{0.82f, 0.88f, 0.89f, 1.0f};

    public ATMParameterSet(Seed seed) {
        hsrCapacity = new float[5];
        diversionAtSeg = new Boolean[seed.getValueInt(CEConst.IDS_NUM_SEGMENT)];
        useDefaults();
    }

    public Object getHSRCapacity(String type) {
        switch (type) {
            default:
            case (ID_HSR_TYPE_VPH):
                return hsrCapacity;
        }
    }

    private void useDefaults() {
        hsrCapacity[0] = HSR_Capacities[0];
        hsrCapacity[1] = HSR_Capacities[1];
        hsrCapacity[2] = HSR_Capacities[2];
        hsrCapacity[3] = HSR_Capacities[3];
        hsrCapacity[4] = HSR_Capacities[3];

        Arrays.fill(diversionAtSeg, Boolean.FALSE);
    }
}
