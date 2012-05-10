package controller;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class HorizontalScrollListener implements AdjustmentListener
{
    // 0 = tableview, 1 = dataview
    private int myType;
    
    public HorizontalScrollListener(int type)
    {
        this.myType = type;
    }
    
    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae){
        int value = ae.getValue();
    }
}