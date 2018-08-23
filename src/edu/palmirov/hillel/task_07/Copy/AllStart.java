package edu.palmirov.hillel.task_07.Copy;

public class AllStart {
    public static void main(String[] args){
        Automobile gaz2410 = new Automobile("sedan", "\"Volga\" GAZ-24-10",
                "FRT564RE009", 4,
                "Gasoline engine", "Steering wheel",
                1790, 25_000,
                4, 4,
                "ZMZ-402.1","GTR09U43",
                "Gasoline A93", 55,
                145);
        System.out.println(gaz2410.getEngineID());
        gaz2410.setEngineID("375346FTFS4");
        System.out.println(gaz2410.getEngineID());
    }
}