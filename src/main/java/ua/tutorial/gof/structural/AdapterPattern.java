package ua.tutorial.gof.structural;

// https://refactoring.guru/ru/design-patterns/adapter
public class AdapterPattern {
    public static void main(String[] args) {
        // 1. inheritance
        new DrawerAdapterByInheritance().drawLine(1, 1, 300, 300);
        new DrawerAdapterByInheritance().drawCircle( 250, 250, 100);

        // 2. composition
        new DrawerAdapterByComposition().drawLine(1, 1, 300, 300);
        new DrawerAdapterByComposition().drawCircle(250, 250, 100);
    }
}

interface DrawShape{
    void drawLine(int x1, int y1, int x2, int y2);
    void drawCircle(int x, int y, int radius);
}

class ShapeDrawer{
    public void DrawBlackLine(int x1, int y1, int x2, int y2){
        System.out.println("ShapeDrawer DrawBlackLine");
    }
    public void DrawBlackCircle(int x, int y, int radius){
        System.out.println("ShapeDrawer DrawBlackCircle");
    }
}

class DrawerAdapterByInheritance extends ShapeDrawer implements DrawShape{
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        DrawBlackLine(x1, y1, x2, y2);
    }

    @Override
    public void drawCircle(int x, int y, int radius) {
        DrawBlackCircle(x, y, radius);
    }
}

class DrawerAdapterByComposition implements DrawShape{
    ShapeDrawer shapeDrawer = new ShapeDrawer();

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        shapeDrawer.DrawBlackLine(x1, y1, x2, y2);
    }

    @Override
    public void drawCircle(int x, int y, int radius) {
        shapeDrawer.DrawBlackCircle(x, y, radius);
    }
}