package ua.tutorial.gof.behavioral;

// https://refactoring.guru/design-patterns/command
public class CommandPattern {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        Developer developer = new Developer(
                new InsertCommand(dataBase),
                new SelectCommand(dataBase),
                new UpdateCommand(dataBase),
                new DeleteCommand(dataBase));

        developer.insertRecord();
        developer.selectRecord();
        developer.updateRecord();
        developer.deleteRecord();
    }
}

class DataBase {
    public void insert() {
        System.out.println("Insert into Db");
    }

    public void select() {
        System.out.println("Select into Db");
    }

    public void update() {
        System.out.println("Update into Db");
    }

    public void delete() {
        System.out.println("Delete into Db");
    }
}

interface Command {
    void execute();
}

class InsertCommand implements Command {
    private DataBase dataBase;

    public InsertCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.insert();
    }
}

class SelectCommand implements Command {
    private DataBase dataBase;

    public SelectCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.select();
    }
}

class UpdateCommand implements Command {
    private DataBase dataBase;

    public UpdateCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.update();
    }
}

class DeleteCommand implements Command {
    private DataBase dataBase;

    public DeleteCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.delete();
    }
}

class Developer {
    private Command insert;
    private Command select;
    private Command update;
    private Command delete;

    public Developer(Command insert, Command select, Command update, Command delete) {
        this.insert = insert;
        this.select = select;
        this.update = update;
        this.delete = delete;
    }

    public void insertRecord() {
        insert.execute();
    }

    public void selectRecord() {
        select.execute();
    }

    public void updateRecord() {
        update.execute();
    }

    public void deleteRecord() {
        delete.execute();
    }
}