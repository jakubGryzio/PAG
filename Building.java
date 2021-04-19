import java.util.Objects;

public class Building {
    private String material = "concrete";
    private double height = 100.0;
    private double length = 25.7;
    private double width = 35.5;
    private int buildIn = 1990;
    private String owner = "Jacek Kurski";
    private boolean rebuild = false;


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
        return "[" + getClass().getName() + ", made of " + getMaterial() +
                ", size[m]=" + getLength() + "x" + getHeight() + "x" + getWidth() +
                ", build in " + getBuildIn() + ", owner " + getOwner() + "]";
    }

    public void open()
    {
        System.out.println("Opened: " + getClass().getSimpleName());
    }

    public void owner()
    {
        System.console().printf("Owner: " + getOwner());
    }

    public void buildIn()
    {
        System.console().printf("Build in: " + getBuildIn());
    }

    public void close()
    {
        System.out.println(getClass().getSimpleName() + " is closed");
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

