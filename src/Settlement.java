import resources.Food;
import resources.Iron;
import resources.Resource;
import resources.Wood;

import java.util.ArrayList;

public class Settlement {

    private ArrayList<Resource> resources;

    public Settlement(Food food, Iron iron, Wood wood) {
        resources = new ArrayList<>();
        resources.add(food);
        resources.add(iron);
        resources.add(wood);
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }
}
