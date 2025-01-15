import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class VehicleRegistry {
    private HashMap<LicensePlate,String> plates;

    public VehicleRegistry() {
        this.plates = new HashMap<>();
    }
    public boolean add(LicensePlate licensePlate, String owner) {
        if(!plates.containsKey(licensePlate)){
            plates.put(licensePlate,owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate licensePlate) {
        if (plates.containsKey(licensePlate)) {
            return plates.get(licensePlate);
        }
        return null;
    }

    public boolean remove(LicensePlate licensePlate) {
        if (plates.containsKey(licensePlate)){
            plates.remove(licensePlate);
            return true;
        }
        return false;
    }
    public void printLicensePlates(){
        for(LicensePlate one : plates.keySet()) {
            System.out.println(one);
        }
    }

    public void printOwners() {
        HashSet<String> unique = new HashSet<>(plates.values());
        for (String one : unique) {
            System.out.println(one);
        }

    }

}
