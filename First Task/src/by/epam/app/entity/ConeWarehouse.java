package by.epam.app.entity;

import java.util.HashMap;
import java.util.Map;

public class ConeWarehouse {

    private static ConeWarehouse instance = null;

    private Map<Integer, Double> areas;
    private Map<Integer, Double> volumes;
    private Map<Integer, Double> volumeCompares;
    private Map<Integer, Boolean> isCones;

    private ConeWarehouse() {
        areas = new HashMap<>();
        volumes = new HashMap<>();
        volumeCompares = new HashMap<>();
        isCones = new HashMap<>();
    }

    public static ConeWarehouse getInstance() {
        if (instance == null) {
            instance = new ConeWarehouse();
        }

        return instance;
    }

    public void setArea(Cone cone, double area) {
        areas.put(cone.getId(), area);
    }

    public void setVolumes(Cone cone, double volume) {
        volumes.put(cone.getId(), volume);
    }

    public void setVolumeCompares(Cone cone, double volumeCompare) {
        volumeCompares.put(cone.getId(), volumeCompare);
    }

    public void setIsCones(Cone cone, boolean isCone) {
        isCones.put(cone.getId(), isCone);
    }

    public double getArea(int id) {
        return areas.get(id);
    }

    public double getVolume(int id) {
        return volumes.get(id);
    }

    public double getVolumeCompare(int id) {
        return volumeCompares.get(id);
    }

    public boolean isCone(int id) {
        return isCones.get(id);
    }
}
