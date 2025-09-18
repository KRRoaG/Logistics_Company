package com.solvd.logistic.singleton;
import com.solvd.logistic.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrinterManager {
    private static final Logger LOGGER = LogManager.getLogger(PrinterManager.class);
    private static final PrinterManager instance = new PrinterManager();
    private PrinterManager(){};
    public static PrinterManager getInstance(){
        return instance;
    }
    public void printMessage(String message) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
        LOGGER.info("{}: {}", Thread.currentThread().getName(), message);
    }
}
