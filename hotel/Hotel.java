package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.roster = new ArrayList<>();;
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public int getCount() {
        return this.roster.size();
    }

    public boolean remove(String name) {
        Person person = roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (person != null) {
            roster.remove(person);
            return true;
        }
        return false;
    }

    public Person getPerson(String name,String hometown){
           for (Person person:roster){
             if( person.getName().equals(name)&& person.getHomeTown().equals(hometown)){
                 return  person;
             }
           }
         return null;
    }

    public String getStatistics() {
        return String.format("The people in the hotel %s are:%n%s%n", name,
                roster.stream()
                        .map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        ).trim();
    }


}
