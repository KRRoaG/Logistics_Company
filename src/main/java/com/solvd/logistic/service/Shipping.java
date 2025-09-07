package com.solvd.logistic.service;

import com.solvd.logistic.enums.ShippingStatus;
import com.solvd.logistic.model.Client;
import com.solvd.logistic.model.StandartPackage;
import com.solvd.logistic.model.Vehicle;

import jdk.jshell.Snippet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shipping extends LogisticOperation {
    private static final Logger LOGGER = LogManager.getLogger(Shipping.class);
    private Client sender;
    private Client receiver;
    private StandartPackage pack;
    private Vehicle vehicle;
    private ShippingStatus status;

    public Shipping(String date, Client sender, Client receiver, StandartPackage pack, Vehicle vehicle, ShippingStatus status) {
        super(date);
        this.sender = sender;
        this.receiver = receiver;
        this.pack = pack;
        this.vehicle = vehicle;
        this.status = status;
    }

    public Client getSender() {
        return sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public StandartPackage getPack() {
        return pack;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    public void setPack(StandartPackage pack) {
        this.pack = pack;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }

    @Override
    public void executeOperation() {
        LOGGER.info("Executing shipping operation ID:  from {} to {} using vehicle: {}", sender.getName(), receiver.getName(), vehicle.getPlateNumber());
    }

    @Override
    public String toString() {
        return "Shipping "+
                ", Date: " + getDate() +
                ", Sender: " + sender.getName() +
                ", Receiver: " + receiver.getName() +
                ", Package: " + pack.getDescription() +
                ", Vehicle: " + vehicle.getPlateNumber() +
                ", Status: " + status + "]";
    }
}
