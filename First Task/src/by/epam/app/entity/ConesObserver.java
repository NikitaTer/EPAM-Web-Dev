package by.epam.app.entity;

import by.epam.app.action.Calculator;
import by.epam.app.interfaces.ConeObserver;
import by.epam.app.validations.DataValidator;

public class ConesObserver implements ConeObserver {

    public ConesObserver() {
    }

    @Override
    public void update(ConeEvent event) {
        Cone cone = event.getSource();
        ConeWarehouse.getInstance().setArea(cone, Calculator.area(cone));
        ConeWarehouse.getInstance().setVolumes(cone, Calculator.volume(cone));
        ConeWarehouse.getInstance().setVolumeCompares(cone, Calculator.volumeCompare(cone));
        ConeWarehouse.getInstance().setIsCones(cone, DataValidator.isCone(cone));
    }
}