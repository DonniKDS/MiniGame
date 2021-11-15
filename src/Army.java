import resources.Food;
import resources.Iron;
import resources.Resource;
import resources.Wood;

import java.util.ArrayList;

public class Army {
    private int maxLoot;
    private ArrayList<Resource> resources;

    public Army(int maxLoot) {
        this.maxLoot = maxLoot;
        resources = new ArrayList<>();
    }

    public int getMaxLoot() {
        return maxLoot;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }
}
