import java.util.Objects;

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
        return "Hospital {" + '\n' + "name: " + getName() + '\n' + "bedNumber: "
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

    public int checkEmptyBedNumber() {
        if (this.bedNumber < this.patientNumber) {
            System.out.println("WARNING! ADD MORE BEDS!");
        }
        return this.bedNumber - this.patientNumber;
    }

    public void addBed() {
        if (checkEmptyBedNumber() < 0) {
            this.bedNumber += -checkEmptyBedNumber();
        }
    }

    public void addBed(int beds) {
        this.bedNumber += beds;
    }

    public void addPatient() {
        this.patientNumber++;
    }

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
}
