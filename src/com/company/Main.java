package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int distans;

    static ArrayList<TC> list = new ArrayList<TC>();
    static ArrayList<TC> listBack = new ArrayList<TC>();
    public static void main(String[] args) throws IOException {
        BufferedReader readConsole = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("");
            System.out.println("1)Start");
            System.out.println("2)Restart race.");
            String someNumber = "";
            try {
                System.out.println("Enter number!");
                someNumber = readConsole.readLine();

            } catch (IOException e) {
                System.out.println(e);
            }
            switch (someNumber) {

                case "1"://Загружать + старт
                    loadProp();
                    start();
                    break;
                case "2"://перезапуск гонки
                    list.clear();
                    for (int i =0;i<listBack.size();i++){
                        list.add(listBack.get(i));
                        list.get(i).setDist(0);
                    }
                    start();
                    break;
                default:
                    System.out.println("Enter the correct number");
                    break;
            }
        }

    }
    public static void start(){

        String table="";
        int pos=1;
        boolean go=true;
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
        list.clear();
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/example.ini"));
            int numMot = Integer.valueOf(properties.getProperty("Mot"));
            distans = Integer.valueOf(properties.getProperty("Distance"));
            //Как-то по другому делать!
            //Хотя вроде норм.
            //Можно переделать структуру конфига для простоты получения данных через 1-н цикл c ифами.
            //Mot = parametrs кратное 5 и усе
            //Хотя смотря как будет быстрее...

            for(int i=0;i<numMot;i++){
                String[] propMot = properties.getProperty("Mot"+(i+1)).split(";");
                list.add(new Mot(i+1,Integer.valueOf(propMot[0]),Integer.valueOf(propMot[1]),Integer.valueOf(propMot[2]),Integer.valueOf(propMot[3]),Integer.valueOf(propMot[4])));
            }


            int numCar = Integer.valueOf(properties.getProperty("Car"));
            for(int i=0;i<numCar;i++){
                String[] propCar = properties.getProperty("Car"+(i+1)).split(";");
                list.add(new Car(i+1,Integer.valueOf(propCar[0]),Integer.valueOf(propCar[1]),Integer.valueOf(propCar[2]),Integer.valueOf(propCar[3]),Integer.valueOf(propCar[4])));
            }


            int numTruck = Integer.valueOf(properties.getProperty("Truck"));
            for(int i =0;i<numTruck;i++){
                String[] propTruck = properties.getProperty("Truck"+(i+1)).split(";");
                list.add(new Truck(i+1,Integer.valueOf(propTruck[0]),Integer.valueOf(propTruck[1]),Integer.valueOf(propTruck[2]),Integer.valueOf(propTruck[3]),Integer.valueOf(propTruck[4])));
            }
            //-----
        }catch (Exception e){//Можно расширить.
            System.out.println(e);
        }
        listBack.clear();
        for (int i=0;i<list.size();i++){//делаем бэк для перезапуска гонки
            listBack.add(list.get(i));
        }
    }
}
