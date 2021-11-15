import resources.Food;
import resources.Iron;
import resources.Resource;
import resources.Wood;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Resource> raid(ArrayList<Resource> settlementResources, int armyMaxLoot) {
        ArrayList<Resource> armyLoot = new ArrayList<>();
        int allResourcesInSettlement = getResourcesCount(settlementResources); // метод написан ниже (часто повторяющийся код)

        // Если ресурсов в деревне меньше, чем может унести армия, то забираем все
        if (allResourcesInSettlement < armyMaxLoot) {
            System.out.println("Забрали все");
            return settlementResources;
        }

        double coefficient = (double) allResourcesInSettlement/armyMaxLoot;
        System.out.println("Коэффициент           = " + coefficient);

        // Определяем вид ресурса и забираем его согласно коэффициенту
        for (Resource resource : settlementResources) {
            if (resource instanceof Food) {
                System.out.println("Food до округления    = " + (resource.getCount()/coefficient));
                System.out.println("Food после округления = " + Math.round(resource.getCount()/coefficient));
                armyLoot.add(new Food((int)Math.round(resource.getCount()/coefficient)));
            }
            if (resource instanceof Iron) {
                System.out.println("Iron до округления    = " + (resource.getCount()/coefficient));
                System.out.println("Iron после округления = " + Math.round(resource.getCount()/coefficient));
                armyLoot.add(new Iron((int)Math.round(resource.getCount()/coefficient)));
            }
            if (resource instanceof Wood) {
                System.out.println("Wood до округления    = " + (resource.getCount()/coefficient));
                System.out.println("Wood после округления = " + Math.round(resource.getCount()/coefficient));
                armyLoot.add(new Wood((int)Math.round(resource.getCount()/coefficient)));
            }
        }

        // Может быть на одну единицу ресурсов больше или на одну меньше, из-за округления
        // например Еды получили    56,527590847913864  округленно  57
        //          Железа получили 43,606998654104984  округленно  44
        //          Дерева получили 19,86541049798116   округленно  20
        //          Всего           120                 Всего       121
        // Поэтому проверяем, и, ресурс, которого больше всего, уменьшаем или увеличиваем соответственно на 1
        while (getResourcesCount(armyLoot) != armyMaxLoot) {
            // определяем какого ресурса больше
            int max = 0;
            for (Resource resource : armyLoot) {
                if (resource.getCount() > max) {
                    max = resource.getCount();
                }
            }
            if (getResourcesCount(armyLoot) > armyMaxLoot) {
                for (Resource resource : armyLoot) {
                    if (resource.getCount() == max) {
                        resource.setCount(max - 1);
                    }
                }
            } else if (getResourcesCount(armyLoot) < armyMaxLoot) {
                for (Resource resource : armyLoot) {
                    if (resource.getCount() == max) {
                        resource.setCount(max + 1);
                    }
                }
            }
        }
        return armyLoot;
    }

    // метод для подсчета всех ресурсов у армии или деревни
    public static int getResourcesCount(ArrayList<Resource> resources) {
        int count = 0;
        for (Resource resource : resources) {
            count += resource.getCount();
        }
        return count;
    }

    //Ниже тестовый метод
    public static void main(String[] args) {
        Settlement settlement1 = new Settlement(new Food(123), new Iron(12), new Wood(254));
        Settlement settlement2 = new Settlement(new Food(350), new Iron(270), new Wood(123));
        Settlement settlement3 = new Settlement(new Food(670), new Iron(432), new Wood(233));
        Settlement settlement4 = new Settlement(new Food(777), new Iron(888), new Wood(999));
        Settlement settlement5 = new Settlement(new Food(212), new Iron(444), new Wood(555));
        Settlement settlement6 = new Settlement(new Food(432), new Iron(5676), new Wood(564));
        Settlement settlement7 = new Settlement(new Food(34534), new Iron(124324), new Wood(1231));
        Settlement settlement8 = new Settlement(new Food(2345), new Iron(12321), new Wood(54568));
        Settlement settlement9 = new Settlement(new Food(356432), new Iron(15435), new Wood(23));
        Settlement settlement10 = new Settlement(new Food(14), new Iron(23), new Wood(54));
        Army army = new Army(120);

        army.setResources(raid(settlement1.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement2.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement3.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement4.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement5.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement6.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement7.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement8.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement9.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();

        army.setResources(raid(settlement10.getResources(), army.getMaxLoot()));
        System.out.println("Всего ресурсов        = " + getResourcesCount(army.getResources()));
        System.out.println();
    }
}
