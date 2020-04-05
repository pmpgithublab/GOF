package ua.tutorial.gof.behavioral;

// https://refactoring.guru/design-patterns/visitor
public class VisitorPattern {
    public static void main(String[] args) {
        JavaProject project = new JavaProject();
        DeveloperType junior = new JuniorDeveloper();
        DeveloperType senior = new SeniorDeveloper();

        System.out.println("Junior in action...");
        project.beWritten(junior);
        System.out.println("Senior in action...");
        project.beWritten(senior);
    }
}

interface ProjectElement {
    void beWritten(DeveloperType developerType);
}

class ProjectClass implements ProjectElement {
    @Override
    public void beWritten(DeveloperType developerType) {
        developerType.create(this);
    }
}

class Database implements ProjectElement {
    @Override
    public void beWritten(DeveloperType developerType) {
        developerType.create(this);
    }
}

class Test implements ProjectElement {
    @Override
    public void beWritten(DeveloperType developerType) {
        developerType.create(this);
    }
}

class JavaProject implements ProjectElement {
    private ProjectElement[] projectElements;

    public JavaProject() {
        this.projectElements = new ProjectElement[]{
                new ProjectClass(),
                new Database(),
                new Test()
        };
    }

    @Override
    public void beWritten(DeveloperType developerType) {
        for (ProjectElement element : projectElements) {
            element.beWritten(developerType);
        }
    }
}

interface DeveloperType {
    void create(ProjectClass projectClass);

    void create(Database database);

    void create(Test test);
}

class JuniorDeveloper implements DeveloperType {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Writing poor class");
    }

    @Override
    public void create(Database database) {
        System.out.println("Drop database");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating not reliable test");
    }
}

class SeniorDeveloper implements DeveloperType {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Rewriting class after junior");
    }

    @Override
    public void create(Database database) {
        System.out.println("Fixing database");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating reliable test");
    }
}