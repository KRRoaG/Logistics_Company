package com.solvd.logistic.tracking;

public interface ITrackable {
        String getTrackId();
        String getPackageStatus();
        void updateStatus (String status);
    }

