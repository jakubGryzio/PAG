package com.pag.zad1; /**
@autor Tomasz Stępień, Jakub Gryzio
@version 1.0
@since 19-04-2021

*/
import java.util.Objects;
import java.util.Scanner;

public class Hospital extends Building{
        private String name;
        private int bedNumber;
        private int patientNumber;

    public Hospital(String material, double height, double length, double width, int buildIn, String owner, boolean rebuild,
                    String name, int bedNumber, int patientNumber) {
        super(material, height, length, width, buildIn, owner, rebuild);
        this.name = name;
        this.bedNumber = bedNumber;
        this.patientNumber = patientNumber;
    }

    @Override
    public String toString() {
        return "com.pag.zad1.Hospital {" + '\n' + "name: " + getName() + '\n' + "bedNumber: "
                + getBedNumber() + '\n' + "patientNumber: " + getPatientNumber() + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }
    /***
    * This method checks number of empty bed.
    * @return subtract between bedNumber attribute and patientNumber attribute
    */
    public int checkEmptyBedNumber() {
        if (this.bedNumber < this.patientNumber) {
            System.out.println("WARNING! ADD MORE BEDS!");
        }
        return this.bedNumber - this.patientNumber;
    }
    /***
    * This method add beds.
    * @param beds
    */
    public void addBed(int beds) {
        this.bedNumber += beds;
    }
    /***
    * This method add new patient.
    */
    public void addPatient() {
        this.patientNumber++;
    }
    /***
    * This method discharge patient.
    */
    public void dischargePatient() {
        this.patientNumber--;
        if (this.patientNumber < 0) {
            this.patientNumber = 0;
        }
    }

    public void open()
    {
        System.out.println(getName() + " hospital" + " is opened.");
    }

    public void close()
    {
        System.out.println(getName() + " hospital" + " is closed.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hospital hospital = (Hospital) o;
        return bedNumber == hospital.bedNumber && patientNumber == hospital.patientNumber && Objects.equals(name, hospital.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, bedNumber, patientNumber);
    }
    /***
    * Test for the class.
    * @param args not used.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
