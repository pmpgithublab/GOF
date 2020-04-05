package ua.tutorial.gof.behavioral;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// https://refactoring.guru/design-patterns/mediator
public class MediatorPattern {
    public static void main(String[] args) {
        SimpleTextChat chat = new SimpleTextChat();
        User admin = new Admin(chat, "Admin");
        User user1 = new OrdinalUser(chat, "User1");
        User user2 = new OrdinalUser(chat, "User2");

        chat.setAdmin(admin);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);

        user1.sendMessage("Hello. I'm user1");
        user2.sendMessage("Hello. I'm user2");
        admin.sendMessage("I'm admin");
    }
}

interface Chat {
    void sendMessage(String message, User user);
    void addUserToChat(User user);
}

interface User {
    void sendMessage(String message);
    void getMessage(String message);
}

abstract class AbstractUser implements User {
    protected Chat chat;
    @Getter
    @Setter
    protected String name;

    public AbstractUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receive message: " + message);
    }
}

class Admin extends AbstractUser {
    public Admin(Chat chat, String name) {
        super(chat, name);
    }
}

class OrdinalUser extends AbstractUser {
    public OrdinalUser(Chat chat, String name) {
        super(chat, name);
    }
}

class SimpleTextChat implements Chat {
    @Setter
    private User admin;
    private List<User> users = new ArrayList<>();

    @Override
    public void addUserToChat(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.getMessage(message);
            }
        }
        admin.getMessage(message);
    }
}