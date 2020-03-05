package ua.tutorial.gof.creational.Prototype;


import java.util.ArrayList;

// https://refactoring.guru/design-patterns/prototype  // gist - clone()
public class PrototypePattern {

    public static void main(String[] args) throws Throwable {
        Human dad = new Human("Ivan", 40, new ArrayList<Human>());
        dad.children.add(new Human("Elder son", 10, new ArrayList<Human>()));
        dad.children.add(new Human("Junior son", 7, new ArrayList<Human>()));


        Human dad2 = dad.clone();
        System.out.println(dad);
        System.out.println(dad2);
    }

}

class Human implements Cloneable {
    private String name;
    private int age;
    public ArrayList<Human> children;

    public Human(String name, int age, ArrayList<Human> children) {
        this.name = name;
        this.age = age;
        this.children = children;
    }

    @Override
    public Human clone() throws CloneNotSupportedException {
        Human newHuman = (Human) super.clone();
        newHuman.age++;
        newHuman.children = new ArrayList<>();
        for (Human human : children) {
            newHuman.children.add(human.clone());
        }
        return newHuman;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Human {name='");
        builder.append(name);
        builder.append('\'');
        builder.append(", age=");
        builder.append(age);
        builder.append(", children {");
        if (children != null) {
            for (Human child : children) {
                builder.append(child);
                builder.append(", ");
            }
            builder.delete(builder.length() - 2, builder.length());
            builder.append("}}");
        } else {
            builder.append("}");
        }
        return builder.toString();
    }
}
