package web.model;

public class Car {
    private String model;
    private int speed;
    private String color;

    public Car(String model, int speed, String color) {
        this.model = model;
        this.speed = speed;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }
}
