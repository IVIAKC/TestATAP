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
    private boolean go=false;//движется ли ТС
    private int dist=0;//пройденная дистанцияы
    private Random random = new Random();

    public static int getStep() {
        return step;
    }

    public static void setStep(int step) {
        TC.step = step;
    }

    private static int step=-1;
    public void getSett(){
        System.out.println("Hi, my name "+getName());
        System.out.println("    My speed = " + getSpeed());
        System.out.println("    My prick = " + getPrick());
    }
    public boolean  Step(int distans){
        if(distans<=dist){

            return false;
        }else {
            setStep(getStep()+1);
            
            int ran;
            ran = Math.abs(random.nextInt()%100);


            if(ran<=getPrick()){
                go = false;
                System.out.println("    "+getName()+" repair ");
            }else {
                go = true;
            }
            if(distans>dist && go){
                dist+=speed;
                System.out.println("    "+getName()+" distants = "+ getDist());
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
