package Controller;

import entity.PricingChart;
import handler.DataHandler;
import handler.HandlerInterface;

import java.util.ArrayList;

public class PricingChartController {
    private HandlerInterface handlerInterface;
    private ArrayList<PricingChart> pricingChartArrayList;

    public PricingChartController()
    {
        handlerInterface = new DataHandler();
        pricingChartArrayList = (ArrayList<PricingChart>) handlerInterface.readSerializedObject("PricingChart");
    }
}
