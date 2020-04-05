package ua.tutorial.gof.behavioral;

import java.util.ArrayList;
import java.util.List;

// https://refactoring.guru/design-patterns/observer
public class ObserverPattern {
    public static void main(String[] args) {
        JavaDeveloperJobSite site = new JavaDeveloperJobSite();

        Subscriber subscriber = new Subscriber("First subscriber");
        site.addObserver(subscriber);

        site.addVacancy("Junior java se.");
        site.addVacancy("Middle java se.");
        site.addVacancy("Senior java se.");

        Subscriber subscriber1 = new Subscriber("John Dow");
        Subscriber subscriber2 = new Subscriber("John Dow's brother");
        site.addObserver(subscriber1);
        site.addObserver(subscriber2);

        site.notifyObservers();

        site.addVacancy("Python se.");

        site.removeVacancy("Python se.");

        site.removeObserver(subscriber);

        site.notifyObservers();
    }
}

interface Observer {
    void handleEvent(List<String> vacancies);
}

interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Notify: dear " + name + ". We have new vacancies: " + vacancies);
    }
}

class JavaDeveloperJobSite implements Observed {
    private List<String> vacancies = new ArrayList<>();
    private List<Observer> subscribes = new ArrayList<>();


    public void addVacancy(String vacancy) {
        vacancies.add(vacancy);
        notifyObservers();
    }

    public void removeVacancy(String vacancy) {
        vacancies.remove(vacancy);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        subscribes.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribes.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribes) {
            observer.handleEvent(vacancies);
        }
        System.out.println("-------------------------------------");
    }
}