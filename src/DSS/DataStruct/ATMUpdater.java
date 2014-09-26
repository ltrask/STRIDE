/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSS.DataStruct;

import atdm.DataStruct.ATDMScenario;
import coreEngine.CEConst;
import static coreEngine.CEConst.IDS_MAIN_NUM_LANES_IN;
import coreEngine.Seed;

/**
 *
 * @author jltrask
 */
public class ATMUpdater {
    private final Seed seed;
    private final ATDMScenario atm;
    private final PeriodATM[] periodATM;
    /**
     * Constructor for the ATM Updater
     * @param seed Seed for to which the updater is attached
     * @param atmScenario ATDMScenario datastruct to hold applied ATM adjustments
     * @param periodATM Contains period by period specification of ATM strategies
     */
    public ATMUpdater(Seed seed, ATDMScenario atmScenario, PeriodATM[] periodATM) {
        this.seed = seed;
        this.atm = atmScenario;  //x = segment, y = period
        this.periodATM = periodATM;
    }
   
    public int update(int startPeriod) {
        PeriodATM currPeriodATM = periodATM[startPeriod];
        int periodJump = currPeriodATM.getPeriodJump();
        
        for (int period = startPeriod; period < startPeriod+periodJump; period++) {
            for (int seg = 0; seg < seed.getValueInt(CEConst.IDS_NUM_SEGMENT); seg++) {
                
                // Assigning Ramp Metering
                if (currPeriodATM.getRMUsed(seg)) {
                    atm.RM().set(currPeriodATM.getRMRate(seg), seg, period);
                }
                
                // Assigning Hard Shoulder Running
                int numLanesSegment = seed.getValueInt(IDS_MAIN_NUM_LANES_IN, seg);
                if (currPeriodATM.getHSRUsed(seg)) {
                    atm.LAF().add(1, seg, period); // Adding lane
                        
                    // Calculating new segment CAF using shoulder CAF
                    float initCAF = seed.getValueFloat(CEConst.IDS_U_CAF_GP,seg,period);
                    float newCAF = ((numLanesSegment * initCAF * atm.CAF().get(seg, period)) + currPeriodATM.getHSRCapacity(seg)) / (numLanesSegment + 1);
                    atm.CAF().set((newCAF / initCAF), seg, period);
                    }
                }
            currPeriodATM = periodATM[period];
        }
        
        return periodJump;
    }
    
    public PeriodATM[] getAllPeriodATM() {
        return periodATM;
    }
}