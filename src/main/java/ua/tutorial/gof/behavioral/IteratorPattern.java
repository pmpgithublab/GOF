package ua.tutorial.gof.behavioral;

import lombok.Getter;
import lombok.Setter;

// https://refactoring.guru/design-patterns/iterator
public class IteratorPattern {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Hibernate", "Maven", "MySQL"};

        JavaDeveloper javaDeveloper = new JavaDeveloper("John Dow", skills);

        Iterator iterator = javaDeveloper.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Collection {
    Iterator getIterator();
}

@Getter
@Setter
class JavaDeveloper implements Collection {
    private String name;
    private String[] skills;

    public JavaDeveloper(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    @Override
    public Iterator getIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements Iterator{
        private int index;

        @Override
        public boolean hasNext() {
            return index < skills.length;
        }

        @Override
        public Object next() {
            return skills[index++];
        }
    }
}