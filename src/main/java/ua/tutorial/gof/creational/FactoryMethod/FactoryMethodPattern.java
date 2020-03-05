package ua.tutorial.gof.creational.FactoryMethod;

// https://refactoring.guru/design-patterns/factory-method
public class FactoryMethodPattern {

    public static void main(String[] args) {
        // changing part of code
                                      //  ConcreteProductBFactory();
        AbstractProductFactory productFactory = new ConcreteProductAFactory();

        // unchanging part of code
        AbstractProduct product = productFactory.createProduct();

        product.produce();
        product.use();
        product.util();
    }
}

interface AbstractProduct {
    void produce();
    void use();
    void util();
}

class ConcreteProductA implements AbstractProduct {
    public void produce() {
        System.out.println("Produce ProductA.");
    }

    public void use() {
        System.out.println("Use ProductA.");
    }

    public void util() {
        System.out.println("Util ProductA.");
    }
}

class ConcreteProductB implements AbstractProduct {
    public void produce() {
        System.out.println("Produce ProductB.");
    }

    public void use() {
        System.out.println("Use ProductB.");
    }

    public void util() {
        System.out.println("Util ProductB.");
    }
}

interface AbstractProductFactory {
    AbstractProduct createProduct();
}

class ConcreteProductAFactory implements AbstractProductFactory {
    public AbstractProduct createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteProductBFactory implements AbstractProductFactory {
    public AbstractProduct createProduct() {
        return new ConcreteProductB();
    }
}