/**
 @autor Tomasz Stępień, Jakub Gryzio
 @version 1.0
 @since 19-04-2021
 */


package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        /**
         * This is the main method which makes Building class.
         * @param args Unused.
         * @return Nothing.
         *
         */
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

    }
}
