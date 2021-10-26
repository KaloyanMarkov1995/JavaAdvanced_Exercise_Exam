package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public int count() {
        return this.data.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean removeRabbit(String name) {
       Rabbit rabbit = data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (rabbit != null) {
            data.remove(rabbit);
            return true;
        }
        return false;
    }

    public void removeSpecies(String species) {
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (rabbit != null) {
            rabbit.setAvailable(false);
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {

        List<Rabbit> rabbits = new ArrayList<>();

        for (Rabbit rabbit: data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbits.add(rabbit);
            }
        }
       return rabbits;
    }




    public String report() {
        return String.format("Rabbits available at: %s:%n%s", name,
                data.stream()
                        .map(Rabbit::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        ).trim();
    }
}
