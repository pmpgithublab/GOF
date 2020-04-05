package ua.tutorial.gof.behavioral;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// https://refactoring.guru/design-patterns/memento
public class MementoPattern {
    public static void main(String[] args) {
        Project project = new Project();
        GitHubRepo gitHubRepo = new GitHubRepo();

        System.out.println("Creating new project ver 1.0");
        project.setVersionAndDate("Ver 1.0");
        System.out.println(project);
        System.out.println("Saving project on github");
        gitHubRepo.setSave(project.save());
        System.out.println("Update to ver 1.1");
        project.setVersionAndDate("Ver 1.1");
        System.out.println(project);
        System.out.println("Something went wrong...");
        System.out.println("Loading project ver 1.0 from github");
        project.load(gitHubRepo.getSave());
        System.out.println("Project after restore");
        System.out.println(project);
    }
}

class Project {
    private String version;
    private Date date;

    public void setVersionAndDate(String version) {
        this.version = version;
        date = new Date();
    }

    public Save save() {
        return new Save(version);
    }

    public void load(Save save) {
        version = save.getVersion();
        date = save.getDate();
    }

    @Override
    public String toString() {
        return "Project:" +
                "\nversion: " + version +
                "\ndate: " + date + "\n";
    }
}

@Getter
class Save {
    private final String version;
    private final Date date;

    public Save(String version) {
        this.version = version;
        this.date = new Date();
    }
}

@Getter
@Setter
class GitHubRepo {
    private Save save;
}