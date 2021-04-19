import java.util.Scanner;
public class Main {

    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    Building house = new Building();
    house.setMaterial("wood");
    house.setHeight(10.0);
    house.setLength(20.0);
    house.setWidth(15.0);
    house.setBuildIn(2000);
    house.setOwner("Jacek Sasin");
    house.setRebuild(false);

    Building department = new Building("concrete", 60.0, 100.0, 80.0, 2010, "Adam Niedzielski", false);

    Building school = new Building("concrete", 30.0, 20.0, 50.0, 2011, "Przemysław Czarnek", true);

    school.open();
    department.close();

    System.out.println(house.equals(school));
    System.out.println(department.equals(department));

    System.out.println(house.hashCode());

    System.out.println(house.getMaterial() + " " + house.getHeight() + " " + house.getLength() + " " + house.getWidth() + " "
            + house.getBuildIn() + " " + house.getOwner() + " " + house.isRebuild());
    System.out.println(house);

    Hospital hospital = new Hospital("concrete", 60.0, 100.0, 80.0, 2010, "Adam Niedzielski", false,
                                    "public", 20, 150);
    hospital.open();
    hospital.owner();
    System.out.println(hospital);
        
    System.out.println("How many are new COVID patients?");
    int numberNewPatient = scanner.nextInt();
    for (int i = 0; i < numberNewPatient; i++) {
        hospital.addPatient();
    }
    System.out.println(hospital);
        
    hospital.checkEmptyBedNumber();
    hospital.addBed(100);
        
    System.out.println("How many patients have recovered?");
    int numberRecoveredPatient = scanner.nextInt();
    for (int i = 0; i < numberRecoveredPatient; i++) {
        hospital.dischargePatient();
    }
    System.out.println(hospital);
        
    hospital.close();

        
    Hospital hospital2 = new Hospital("concrete", 60.0, 100.0, 80.0, 2010, "Adam Niedzielski", false,
            "private", 20, 150);

    System.out.println(hospital.equals(hospital2));

    if (hospital.hashCode() != hospital2.hashCode()){
        System.out.println(true);
    } else {
        System.out.println("hashCode does not work!");
    }

    }
}
