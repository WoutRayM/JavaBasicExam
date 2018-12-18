package entities.plant_entities;

public abstract class Plant {

    private String name;
    private double height;

    Plant(String name) {
        setName(name);
    }

    Plant(String name, double height) {
        setName(name);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return null;
    }

}
