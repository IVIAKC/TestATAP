package com.company;

/**
 * Created by IVIAKC on 11.08.2016.
 */
public class Truck extends TC {


    public Truck(int num,int wheels,int prick,int load,int spead,int repair) {
        setName("Truck "+num);
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

        System.out.println("    Workload = "+getLoad());


    }
}
