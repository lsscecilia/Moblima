package Controller;

import Entity.PricingChart;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class PricingChartController {
    private HandlerInterface database;
    private ArrayList<PricingChart> pricingChartArrayList;

    public PricingChartController()
    {
        database = new DataHandler();
        pricingChartArrayList = database.readSerializedObject("PricingChart");
    }
}
