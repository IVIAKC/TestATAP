package com.company;


import java.util.Random;

/**
 * Created by IVIAKC on 11.08.2016.
 */
public class TC {
    String name="name";
    private int numWheels; //кол-во колес
    private int prick; //вероятность прокола
    private int load; //груз
    private int speed; // Скорость
    private int repair; //время ремонта
    private int dist=0;//пройденная дистанцияы
    private int drive=0;
    private Random random = new Random();


    public void getSett(){
        System.out.println("Hi, my name "+getName());
        System.out.println("    My speed = " + getSpeed());
        System.out.println("    My prick = " + getPrick());
    }
    public boolean  Step(int distans){


        if(distans<=getDist()){
            return false;
        }else {
            if(drive==0) {
                if (Math.abs(random.nextInt() % 100) <= getPrick()) {
                    System.out.println("    " + getName() + " repair ");
                    drive+=repair;
                } else {
                    dist += speed;
                    System.out.println("    " + getName() + " distants = " + getDist());
                }
            }else {
                drive--;
                System.out.println("    " + getName() + " repair ");
            }
            return true;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public int getPrick() {
        return prick;
    }

    public void setPrick(int prick) {
        this.prick = prick;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public void setRepair(int repair) {
        this.repair = repair;
    }

    public int getDist() {
        return dist;
    }


}
