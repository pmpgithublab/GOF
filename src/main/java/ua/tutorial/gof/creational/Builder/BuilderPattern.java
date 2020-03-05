package ua.tutorial.gof.creational.Builder;

import lombok.ToString;

// https://refactoring.guru/design-patterns/builder
public class BuilderPattern {

    public static void main(String[] args) {

        // made by director
        Director director = new Director();
        System.out.println(director.makeHP17SDD5000());
        System.out.println(director.makeSony12HDD2000());
        System.out.println(director.makeSony154SDD6000());

        // made by builder
        Laptop laptop = new SonyLaptopBuilder().buildBattery(7000).buildDisk(DiskType.SDD).buildScreen(19).getResult();
        System.out.println(laptop);

    }
}

enum DiskType {HDD, SDD}

@ToString
class Laptop {
    String name;
    double screenSize;
    DiskType diskType;
    int batteryCapacity;
}

// Builder has to have all the necessary steps to built a product
abstract class LaptopBuilder {
    protected Laptop laptop;

    public abstract LaptopBuilder buildScreen(double screenSize);

    public abstract LaptopBuilder buildBattery(int batteryCapacity);

    public abstract LaptopBuilder buildDisk(DiskType diskType);

    public Laptop getResult() {
        return laptop;
    }
}

class HPLaptopBuilder extends LaptopBuilder {

    {
        laptop = new Laptop();
        laptop.name = "HP";
        laptop.screenSize = 15;
        laptop.batteryCapacity = 4000;
        laptop.diskType = DiskType.HDD;
    }

    @Override
    public LaptopBuilder buildScreen(double screenSize) {
        laptop.screenSize = screenSize;
        return this;
    }

    @Override
    public LaptopBuilder buildBattery(int batteryCapacity) {
        laptop.batteryCapacity = batteryCapacity;
        return this;
    }

    @Override
    public LaptopBuilder buildDisk(DiskType diskType) {
        laptop.diskType = diskType;
        return this;
    }
}

class SonyLaptopBuilder extends LaptopBuilder {

    {
        laptop = new Laptop();
        laptop.name = "Sony";
        laptop.screenSize = 15.4;
        laptop.batteryCapacity = 3000;
        laptop.diskType = DiskType.SDD;
    }

    @Override
    public LaptopBuilder buildScreen(double screenSize) {
        laptop.screenSize = screenSize;
        return this;
    }

    @Override
    public LaptopBuilder buildBattery(int batteryCapacity) {
        laptop.batteryCapacity = batteryCapacity;
        return this;
    }

    @Override
    public LaptopBuilder buildDisk(DiskType diskType) {
        laptop.diskType = diskType;
        return this;
    }
}

// class for creating the most popular models - it keeps prepared presets
class Director {

    Laptop makeHP17SDD5000(){
        LaptopBuilder builder = new HPLaptopBuilder();
        builder.buildScreen(17);
        builder.buildDisk(DiskType.SDD);
        builder.buildBattery(5000);
        return builder.getResult();
    }

    Laptop makeSony12HDD2000(){
        LaptopBuilder builder = new SonyLaptopBuilder();
        builder.buildScreen(12);
        builder.buildDisk(DiskType.HDD);
        builder.buildBattery(2000);
        return builder.getResult();
    }

    Laptop makeSony154SDD6000(){
        LaptopBuilder builder = new SonyLaptopBuilder();
        builder.buildBattery(6000);
        return builder.getResult();
    }

}