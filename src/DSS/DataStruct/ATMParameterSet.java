/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSS.DataStruct;

/**
 *
 * @author jltrask
 */
public class ATMParameterSet {
    public float hsrCapacity[];
    
    public final static String ID_HSR_TYPE_PERCENT_OF_MAINLINE_LANE = "ID_HSR_TYPE_PERCENT_OF_MAINLINE_LANE";
    public final static String ID_HSR_TYPE_VPH = "ID_HSR_TYPE_VPH";
    
    public ATMParameterSet() {
        hsrCapacity = new float[5];
        useDefaults();
    }
    
    public Object getHSRCapacity(String type) {
        switch (type) {
            default:
            case (ID_HSR_TYPE_VPH):
                return hsrCapacity;
        }
    }
    
    public void useDefaults() {
        hsrCapacity[0] = 0.7f;
        hsrCapacity[1] = 0.75f;
        hsrCapacity[2] = 0.8f;
        hsrCapacity[3] = 0.85f;
        hsrCapacity[4] = 0.9f;
    }
}
