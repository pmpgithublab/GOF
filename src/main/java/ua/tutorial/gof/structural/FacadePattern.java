package ua.tutorial.gof.structural;

// https://refactoring.guru/design-patterns/facade
public class FacadePattern {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copyDataFromDVDtoHDD();

        Computer2 computer2 = new Computer2();
        computer2.copyDataFromDVDtoHDD();
    }
}

class Power {
    void powerOn() {
        System.out.println("Power on");
    }

    void powerOff() {
        System.out.println("Power off");
    }
}

class DVDRom {
    private boolean data;

    public boolean hasData() {
        return data;
    }

    public void load() {
        data = true;
    }

    public void unLoad() {
        data = false;
    }
}

class HDD {
    public void copyDataFromDVD(DVDRom dvdRom) {
        if (dvdRom.hasData()) {
            System.out.println("Coping data from DVD to HDD...");
        } else {
            System.out.println("Insert DVD disk.");
        }
    }
}

class Computer {
    public void copyDataFromDVDtoHDD() {
        Power power = new Power();
        power.powerOn();
        DVDRom dvdRom = new DVDRom();
        dvdRom.load();
        HDD hdd = new HDD();
        hdd.copyDataFromDVD(dvdRom);
        dvdRom.unLoad();
        power.powerOff();
    }
}

class Computer2 {
    private Power power = new Power();
    private DVDRom dvdRom = new DVDRom();
    private HDD hdd = new HDD();

    public void copyDataFromDVDtoHDD() {
        power.powerOn();
        dvdRom.load();
        hdd.copyDataFromDVD(dvdRom);
        dvdRom.unLoad();
        power.powerOff();
    }
}
