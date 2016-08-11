package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {

    private static boolean debug = true;
    private static boolean go=true;
    private static int distans = 1000;

    static ArrayList<TC> list = new ArrayList<TC>();
    static ArrayList<TC> table = new ArrayList<TC>();
    public static void main(String[] args) throws IOException {

        loadProp();
        while(go){
            go=false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).Step(distans)) {

                    go = true;
                }else {
                    table.add(list.get(i));
                    list.remove(i);
                }
            }
        }
        System.out.println();
        for (int i=0;i<table.size();i++){
            System.out.println(table.get(i).getName());
        }



    }
    public static void loadProp(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/example.ini"));
            int numMot = Integer.valueOf(properties.getProperty("Mot"));

            //Как-то по другому делать!
            //Хотя вроде норм.
            //Можно переделать структуру конфига для простоты получения данных через 1-н цикл.
            if(debug) System.out.println("1");
            for(int i=0;i<numMot;i++){
                String[] propMot = properties.getProperty("Mot"+(i+1)).split(";");
                list.add(new Mot(i+1,Integer.valueOf(propMot[0]),Integer.valueOf(propMot[1]),Integer.valueOf(propMot[2]),Integer.valueOf(propMot[3]),Integer.valueOf(propMot[4])));
            }

            if(debug) System.out.println("2");
            int numCar = Integer.valueOf(properties.getProperty("Car"));
            for(int i=0;i<numCar;i++){
                String[] propCar = properties.getProperty("Car"+(i+1)).split(";");
                list.add(new Car(i+1,Integer.valueOf(propCar[0]),Integer.valueOf(propCar[1]),Integer.valueOf(propCar[2]),Integer.valueOf(propCar[3]),Integer.valueOf(propCar[4])));
            }

            if(debug) System.out.println("3");
            int numTruck = Integer.valueOf(properties.getProperty("Truck"));
            for(int i =0;i<numTruck;i++){
                String[] propTruck = properties.getProperty("Truck"+(i+1)).split(";");
                list.add(new Truck(i+1,Integer.valueOf(propTruck[0]),Integer.valueOf(propTruck[1]),Integer.valueOf(propTruck[2]),Integer.valueOf(propTruck[3]),Integer.valueOf(propTruck[4])));
            }
            //-----
        }catch (Exception e){//Можно расширить.
            System.out.println(e);
        }
    }
}
