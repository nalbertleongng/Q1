import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// part a: modify the Person class to implement Comparable<Person>
class Person implements Comparable<Person> {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return name + " (" + age + ')';
    }

    @Override
    public int compareTo(Person people) {

            var ageDiff = this.getAge() - people.getAge();
            if (ageDiff != 0) {
                return ageDiff;
            } else {
                return this.getName().compareTo(people.getName());
            }
        }
    }



