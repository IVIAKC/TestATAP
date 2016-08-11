package com.company;

/**
 * Created by IVIAKC on 11.08.2016.
 */
public class Mot extends TC {


    public Mot(int num,int wheels,int prick,int load,int spead,int repair) {

        setNumWheels(wheels);
        setPrick(prick);
        setLoad(load);
        setSpeed(spead);
        setRepair(repair);


        setName("Mot "+num);
        getSett();
    }


    @Override
    public void getSett() {
        super.getSett();
        if(getNumWheels()>2){
            System.out.println("    I have a stroller");
        }else {
            System.out.println("    I do not have a stroller");
        }
    }
}
