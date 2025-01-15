import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> items;

    public StorageFacility() {
        this.items = new HashMap<>();
    }

    public void add(String unit,String item) {
        if(!items.containsKey(unit)) {
            items.put(unit,new ArrayList<>());
        }
        items.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        ArrayList<String> result = new ArrayList<>();
        if(items.containsKey(storageUnit)) {
            result.addAll(items.get(storageUnit));
        }
        return result;
    }

    public void remove(String storageUnit, String item) {
        if(items.containsKey(storageUnit)){
            ArrayList<String> unitItems = items.get(storageUnit);
            unitItems.remove(item);
            if(unitItems.isEmpty()){
                items.remove(storageUnit);
            }
        }

    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> result = new ArrayList<>();
            for(String one : items.keySet()) {
                if (!items.get(one).isEmpty()) {
                    result.add(one);
                }
            }

            return result;
    }

}
