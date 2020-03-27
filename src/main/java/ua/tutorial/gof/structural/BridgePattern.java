package ua.tutorial.gof.structural;

// https://refactoring.guru/design-patterns/bridge
public class BridgePattern {
    public static void main(String[] args) {
        Audi audi = new Audi(new Sedan());
        audi.printCarModel();
        audi.cartype.printCarType();
        audi.printCarType();

        BMW bmw = new BMW(new Pickup());
        bmw.printCarModel();
        bmw.cartype.printCarType();
        bmw.printCarType();
    }
}

abstract class CarModel {
    protected CarType cartype;

    abstract public void printCarModel();
    void printCarType(){
        cartype.printCarType();
    }
}

class Audi extends CarModel{
    public Audi(CarType cartype) {
        this.cartype = cartype;
    }

    @Override
    public void printCarModel() {
        System.out.println("Audi");
    }
}

class BMW extends CarModel{
    public BMW(CarType cartype) {
        this.cartype = cartype;
    }

    @Override
    public void printCarModel() {
        System.out.println("BMW");
    }
}

abstract class CarType {
    abstract public void printCarType();
}

class Sedan extends CarType{
    @Override
    public void printCarType() {
        System.out.println("Sedan");
    }
}

class Pickup extends CarType{
    @Override
    public void printCarType() {
        System.out.println("Pickup");
    }
}



