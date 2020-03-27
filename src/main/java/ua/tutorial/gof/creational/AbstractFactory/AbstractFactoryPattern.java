package ua.tutorial.gof.creational.AbstractFactory;

// https://refactoring.guru/design-patterns/abstract-factory
// it is a factory of factories
public class AbstractFactoryPattern {

    public static void main(String[] args) {
        // changing part of code
        AbstractFactory factory = new createConcreteFactorySmallLaptop();

        // unchanging part of code
        AbstractProductLaptop laptop = factory.createConcreteProductLaptop();
        AbstractProductMouse mouse = factory.createConcreteProductMouse();

        laptop.turnOn();
        laptop.works();
        laptop.turnOff();

        mouse.doubleClick();
        mouse.scroll();


        // changing part of code
        factory = new createConcreteFactoryBigLaptop();

        // unchanging part of code
        laptop = factory.createConcreteProductLaptop();
        mouse = factory.createConcreteProductMouse();

        laptop.turnOn();
        laptop.works();
        laptop.turnOff();

        mouse.doubleClick();
        mouse.scroll();
    }
}

interface AbstractFactory {
    AbstractProductLaptop createConcreteProductLaptop();

    AbstractProductMouse createConcreteProductMouse();
}

class createConcreteFactorySmallLaptop implements AbstractFactory {
    @Override
    public AbstractProductLaptop createConcreteProductLaptop() {
        return new ConcreteProductSmallLaptop();
    }

    @Override
    public AbstractProductMouse createConcreteProductMouse() {
        return new ConcreteProductSmallMouse();
    }
}

class createConcreteFactoryBigLaptop implements AbstractFactory {
    @Override
    public AbstractProductLaptop createConcreteProductLaptop() {
        return new ConcreteProductBigLaptop();
    }

    @Override
    public AbstractProductMouse createConcreteProductMouse() {
        return new ConcreteProductBigMouse();
    }
}


interface AbstractProductLaptop {
    void turnOn();

    void works();

    void turnOff();
}

interface AbstractProductMouse {
    void doubleClick();

    void scroll();
}

class ConcreteProductSmallLaptop implements AbstractProductLaptop {

    @Override
    public void turnOn() {
        System.out.println("ConcreteSmallLaptop turnOn");
    }

    @Override
    public void works() {
        System.out.println("ConcreteSmallLaptop works");
    }

    @Override
    public void turnOff() {
        System.out.println("ConcreteSmallLaptop turnOff");
    }
}

class ConcreteProductBigLaptop implements AbstractProductLaptop {

    @Override
    public void turnOn() {
        System.out.println("ConcreteBigLaptop turnOn");
    }

    @Override
    public void works() {
        System.out.println("ConcreteBigLaptop works");
    }

    @Override
    public void turnOff() {
        System.out.println("ConcreteBigLaptop turnOff");
    }
}

class ConcreteProductSmallMouse implements AbstractProductMouse {
    @Override
    public void doubleClick() {
        System.out.println("ConcreteProductSmallMouse doubleClick");
    }

    @Override
    public void scroll() {
        System.out.println("ConcreteProductSmallMouse scroll");
    }
}

class ConcreteProductBigMouse implements AbstractProductMouse {
    @Override
    public void doubleClick() {
        System.out.println("ConcreteProductBigMouse doubleClick");
    }

    @Override
    public void scroll() {
        System.out.println("ConcreteProductBigMouse scroll");
    }
}