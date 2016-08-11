package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean debug = true;
    private static boolean go=true;
    private static int distans = 1000;

    static ArrayList<TC> list = new ArrayList<TC>();
    static ArrayList<TC> listBack = new ArrayList<TC>();
    static String table="";
    public static void main(String[] args) throws IOException {
        BufferedReader readConsole = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("1)Start");
            System.out.println("2)Restart race.");
            System.out.println("3)Reload propertis.");
            int someNumber = 0;
            try {
                System.out.println("Enter number!");
                someNumber = Integer.valueOf(readConsole.readLine());

            } catch (IOException e) {
                System.out.println(e);
            }
            switch (someNumber) {

                case 1://Загружать + старт
                    System.out.println("1");
                    loadProp();
                    start();
                    break;
                case 2://перезапуск гонки
                    System.out.println("2");
                    list.clear();
                    for (int i =0;i<listBack.size();i++){
                        list.add(listBack.get(i));
                    }
                    start();
                    break;
                case 3://перезагрузка параметр
                    System.out.println("3");
                    loadProp();
                    break;
            }
        }

    }
    public static void start(){
        System.out.println("Statring");
        table="";
        int pos=1;
        go=true;
        while(go){
            System.out.println();
            go=false;
            for(int i=list.size()-1;i>=0;i--){
                if(list.get(i).Step(distans)) {

                    go = true;
                }else {
                    table += pos+")"+list.get(i).getName()+"\n";
                    list.remove(i);
                    pos++;
                }
            }
        }
        System.out.println("-----TABLE WIN-----");
        System.out.println(table);
        System.out.println("-------------------");
    }
    public static void loadProp(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/example.ini"));
            int numMot = Integer.valueOf(properties.getProperty("Mot"));

            //Как-то по другому делать!
            //Хотя вроде норм.
            //Можно переделать структуру конфига для простоты получения данных через 1-н цикл c ифами.
            //Mot = parametrs кратное 5 и усе
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
        for (int i=0;i<list.size();i++){//делаем бэк для перезапуска гонки
            listBack.add(list.get(i));
        }
    }
}
