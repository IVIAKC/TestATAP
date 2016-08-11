package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Main {

    private static boolean debug = true;
    private static boolean go=true;

    private int distans = 100;


    static ArrayList<Mot> listMot = new ArrayList<Mot>();
    static ArrayList<Car> listCar = new ArrayList<Car>();
    static ArrayList<Truck> listTruck = new ArrayList<Truck>();

    public static void main(String[] args) throws IOException {

        loadProp();

        while(go){
            System.out.println("Go to road!!!");
            go=false;
        }

    }
    public static void loadProp(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/example.ini"));
            int numMot = Integer.valueOf(properties.getProperty("Mot"));
            int numCar = Integer.valueOf(properties.getProperty("Car"));
            int numTruck = Integer.valueOf(properties.getProperty("Truck"));

            //Как-то по другому делать!
            if(debug) System.out.println("1");
            for(int i=0;i<numMot;i++){
                String[] propMot = properties.getProperty("Mot"+(i+1)).split(";");
                listMot.add(new Mot(i+1,Integer.valueOf(propMot[0]),Integer.valueOf(propMot[1]),Integer.valueOf(propMot[2]),Integer.valueOf(propMot[3]),Integer.valueOf(propMot[4])));
            }
            if(debug) System.out.println("2");
            for(int i=0;i<numCar;i++){
                String[] propCar = properties.getProperty("Car"+(i+1)).split(";");
                listCar.add(new Car(i+1,Integer.valueOf(propCar[0]),Integer.valueOf(propCar[1]),Integer.valueOf(propCar[2]),Integer.valueOf(propCar[3]),Integer.valueOf(propCar[4])));
            }
            if(debug) System.out.println("3");
            for(int i =0;i<numTruck;i++){
                String[] propTruck = properties.getProperty("Truck"+(i+1)).split(";");
                listTruck.add(new Truck(i+1,Integer.valueOf(propTruck[0]),Integer.valueOf(propTruck[1]),Integer.valueOf(propTruck[2]),Integer.valueOf(propTruck[3]),Integer.valueOf(propTruck[4])));
            }
            //-----
        }catch (Exception e){//Можно расширить.
            System.out.println(e);
        }
    }
}
