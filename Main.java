public class Main {

    public static void main(String[] args){

    Building house = new Building();
    house.setMaterial("wood");
    house.setHeight(10.0);
    house.setLength(20.0);
    house.setWidth(15.0);
    house.setBuildIn(2000);
    house.setOwner("Jacek Sasin");
    house.setRebuild(false);
    System.out.println(house.getMaterial() + " " + house.getHeight() + " " + house.getLength() + " " + house.getWidth() + " "
            + house.getBuildIn() + " " + house.getOwner() + " " + house.isRebuild());

    Building department = new Building();
    department.setMaterial("concrete");
    department.setHeight(60.0);
    department.setLength(100.0);
    department.setWidth(80.0);
    department.setBuildIn(2010);
    department.setOwner("Adam Niedzielski");
    department.setRebuild(false);

    Building school = new Building();
    school.setMaterial("concrete");
    school.setHeight(30.0);
    school.setLength(20.0);
    school.setWidth(50.0);
    school.setBuildIn(2011);
    school.setOwner("Przemysław Czarnek");
    school.setRebuild(true);

    System.out.println(house.equals(school));
    System.out.println(department.equals(school));
    System.out.println(department.equals(department));

    System.out.println(house.hashCode());
    System.out.println(school.hashCode());
    System.out.println(department.hashCode());

    System.out.println(house);
    System.out.println(department);
    System.out.println(school);
    }
}

