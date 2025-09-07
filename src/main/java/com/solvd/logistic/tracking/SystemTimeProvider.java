package com.solvd.logistic.tracking;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SystemTimeProvider  implements ITimeProvider{
    @Override
    public String getCurrentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
