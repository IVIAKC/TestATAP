package com.company;

/**
 * Created by IVIAKC on 11.08.2016.
 */
public class Car extends TC {
    public Car(int num,int wheels,int prick,int load,int spead,int repair) {
        setName("Car "+num);
        setNumWheels(wheels);
        setPrick(prick);
        setLoad(load);
        setSpeed(spead);
        setRepair(repair);

        setNumWheels(3);
        getSett();
    }


    @Override
    public void getSett() {
        super.getSett();
        System.out.println("    Number of passengers = " + getLoad());
    }
}
