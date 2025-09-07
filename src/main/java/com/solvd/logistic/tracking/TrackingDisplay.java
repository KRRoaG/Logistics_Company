package com.solvd.logistic.tracking;

import com.solvd.logistic.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrackingDisplay implements IDisplayable {
    private static final Logger LOGGER = LogManager.getLogger(TrackingDisplay.class);
    @Override
    public void display(String info) {
        LOGGER.info(info);
    }
}
