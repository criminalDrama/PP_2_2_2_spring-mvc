package web.model;

public class Car {
    String name;
    String seria;
    int coast;

    public Car(String name, String seria, int coast) {
        this.name = name;
        this.seria = seria;
        this.coast = coast;
    }

    public String getName() {
        return name;
    }

    public String getSeria() {
        return seria;
    }

    public int getCoast() {
        return coast;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }
}
