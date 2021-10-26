package hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String homeTown = "n/a";

    public Person(String name, int id, int age, String homeTown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.homeTown = homeTown;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return String.format("Person %s: %d, " + "Age: %d, " + "Hometown: %s", name, id, age, homeTown);
    }
}


