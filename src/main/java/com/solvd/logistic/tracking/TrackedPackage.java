package com.solvd.logistic.tracking;

public class TrackedPackage implements ITrackable {
    private final String trackingId;
    private String status;

    public TrackedPackage(String trackingId){
        this.trackingId = trackingId;
        this.status = "In transit";
    }

    @Override
    public String getTrackId() {
        return trackingId;
    }

    @Override
    public String getPackageStatus() {
        return status;
    }

    @Override
    public void updateStatus(String status) {
        this.status= status;
    }
}
