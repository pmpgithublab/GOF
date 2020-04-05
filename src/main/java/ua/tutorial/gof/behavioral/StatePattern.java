package ua.tutorial.gof.behavioral;

import lombok.Setter;

// https://refactoring.guru/design-patterns/state
public class StatePattern {
    public static void main(String[] args) {
        Activity activity = new Sleeping();
        SoftwareDeveloper developer = new SoftwareDeveloper();

        developer.setActivity(activity);

        for (int i = 0; i < 14; i++) {
            developer.justDoIt();
            developer.changeActivity();
        }
    }
}

interface Activity {
    void justDoIt();
}

class Coding implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Writing code");
    }
}

class Reading implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Reading book");
    }
}

class Sleeping implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Sleeping");
    }
}

class Training implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Training");
    }
}

class SoftwareDeveloper {
    @Setter
    private Activity activity;

    public void changeActivity() {
        if (activity instanceof Sleeping) {
            setActivity(new Training());
        } else if (activity instanceof Training) {
            setActivity(new Coding());
        } else if (activity instanceof Coding) {
            setActivity(new Reading());
        } else if (activity instanceof Reading) {
            setActivity(new Sleeping());
        }
    }

    public void justDoIt() {
        activity.justDoIt();
    }
}