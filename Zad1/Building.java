/**
@autor Tomasz Stępień, Jakub Gryzio
@version 1.0
@since 19-04-2021
*/


import java.util.Objects;

public class Building {
    private String material = "concrete";
    private double height = 0.0;
    private double length = 0.0;
    private double width = 0.0;
    private int buildIn = 1990;
    private String owner = "Jacek Kurski";
    private boolean rebuild = false;

    public Building() {
    }

    public Building(String material, double height, double length, double width, int buildIn, String owner, boolean rebuild) {
        this.material = material;
        this.height = height;
        this.length = length;
        this.width = width;
        this.buildIn = buildIn;
        this.owner = owner;
        this.rebuild = rebuild;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setBuildIn(int buildIn) {
        this.buildIn = buildIn;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setRebuild(boolean rebuild) {
        this.rebuild = rebuild;
    }
    public String getMaterial() {
        return material;
    }
    public double getHeight() {
        return height;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public int getBuildIn() {
        return buildIn;
    }
    public String getOwner() {
        return owner;
    }
    public boolean isRebuild(){
        return rebuild;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + ", made of " + getMaterial() +
                ", size[m]=" + getLength() + "x" + getHeight() + "x" + getWidth() +
                ", build in " + getBuildIn() + ", owner " + getOwner() + "]";
    }

    public void open()
    {
        System.out.println("Opened " + getClass().getSimpleName());
    }

    public void owner()
    {
        System.out.println("Owner: " + this.getOwner());
    }

    public void buildIn()
    {
        System.out.println("Build in: " + this.getBuildIn());
    }

    public void close()
    {
        System.out.println(getClass().getSimpleName() + " closed");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Double.compare(building.height, height) == 0 && Double.compare(building.length, length) == 0 && Double.compare(building.width, width) == 0 &&
                buildIn == building.buildIn && rebuild == building.rebuild && Objects.equals(material, building.material) &&
                Objects.equals(owner, building.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, height, length, width, buildIn, owner, rebuild);
    }
} 