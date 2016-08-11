package com.company;

/**
 * Created by IVIAKC on 11.08.2016.
 */
public class TC {
    String name="name";
    int numWheels; //кол-во колес
    int prick; //вероятность прокола
    int load; //груз
    int speed; // Скорость
    int repair; //время ремонта
    boolean go=false;//движется ли ТС
    int dist=0;//пройденная дистанцияы

    public TC() {

    }
    public void getSett(){

        System.out.println("Hi, my name "+getName());
        System.out.println("    My speed = " + getSpeed());
        System.out.println("    My prick = " + getPrick());

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

    public int getRepair() {
        return repair;
    }

    public void setRepair(int repair) {
        this.repair = repair;
    }

    public boolean isGo() {
        return go;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }
}
