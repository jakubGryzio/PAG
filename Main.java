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

    Building hospital = new Building();
    hospital.setMaterial("concrete");
    hospital.setHeight(60.0);
    hospital.setLength(100.0);
    hospital.setWidth(80.0);
    hospital.setBuildIn(2010);
    hospital.setOwner("Adam Niedzielski");
    hospital.setRebuild(false);

    Building school = new Building();
    school.setMaterial("concrete");
    school.setHeight(30.0);
    school.setLength(20.0);
    school.setWidth(50.0);
    school.setBuildIn(2011);
    school.setOwner("Przemysław Czarnek");
    school.setRebuild(true);

    System.out.println(house.equals(school));
    System.out.println(hospital.equals(school));
    System.out.println(hospital.equals(hospital));

    System.out.println(house.hashCode());
    System.out.println(school.hashCode());
    System.out.println(hospital.hashCode());

    System.out.println(house);
    System.out.println(hospital);
    System.out.println(school);





    }
}

