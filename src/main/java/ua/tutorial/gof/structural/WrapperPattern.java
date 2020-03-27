package ua.tutorial.gof.structural;

// https://refactoring.guru/design-patterns/decorator
public class WrapperPattern {
    public static void main(String[] args) {
        new CurveBracketDecorator(new SquareBracketDecorator(new QuotesDecorator(new Printer("Hello")))).print();
    }
}

interface PrinterInterface{
    void print();
}

class Printer implements PrinterInterface{
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class PrinterDecorator implements PrinterInterface{
    PrinterInterface printerInterface;

    public PrinterDecorator(PrinterInterface printerInterface) {
        this.printerInterface = printerInterface;
    }
}

class QuotesDecorator extends PrinterDecorator{
    public QuotesDecorator(PrinterInterface printerInterface) {
        super(printerInterface);
    }

    @Override
    public void print() {
        System.out.print("\"");
        printerInterface.print();
        System.out.print("\"");
    }
}

class SquareBracketDecorator extends PrinterDecorator{
    public SquareBracketDecorator(PrinterInterface printerInterface) {
        super(printerInterface);
    }

    @Override
    public void print() {
        System.out.print("[");
        printerInterface.print();
        System.out.print("]");
    }
}


class CurveBracketDecorator extends PrinterDecorator{
    public CurveBracketDecorator(PrinterInterface printerInterface) {
        super(printerInterface);
    }

    @Override
    public void print() {
        System.out.print("{");
        printerInterface.print();
        System.out.print("}");
    }
}

