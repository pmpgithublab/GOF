package ua.tutorial.gof.structural;

import java.util.*;

// https://refactoring.guru/design-patterns/flyweight
public class FlyweightPattern {
    public static void main(String[] args) {
        BuildingFactory buildingFactory = new BuildingFactory();
        List<Building> buildings = new LinkedList<>();

        buildings.add(buildingFactory.getBuilding("Small house"));
        buildings.add(buildingFactory.getBuilding("Big house"));
        buildings.add(buildingFactory.getBuilding("Big house"));
        buildings.add(buildingFactory.getBuilding("Small house"));
        buildings.add(buildingFactory.getBuilding("Small house"));
        buildings.add(buildingFactory.getBuilding("Big house"));
        buildings.add(buildingFactory.getBuilding("Small house"));
        buildings.add(buildingFactory.getBuilding("Big house"));

        Random random = new Random(System.currentTimeMillis());
        buildings.forEach(e->e.drawPosition(random.nextInt(100), random.nextInt(100)));
    }
}

interface Building {
    void drawPosition(int x, int y);
}

class BigHouse implements Building {
    @Override
    public void drawPosition(int x, int y) {
        System.out.println("Big house at " + x + ", " + y);
    }
}

class SmallHouse implements Building {
    @Override
    public void drawPosition(int x, int y) {
        System.out.println("Small house at " + x + ", " + y);
    }
}

class BuildingFactory {
    private Map<String, Building> buildingMap = new HashMap<>();

    public Building getBuilding(String buildingName) {
        Building building = buildingMap.get(buildingName);
        if (building == null) {
            switch (buildingName) {
                case "Small house":
                    building = new SmallHouse();
                    break;
                case "Big house":
                    building = new BigHouse();
                    break;
            }
            buildingMap.put(buildingName, building);
        }
        return building;
    }
}
