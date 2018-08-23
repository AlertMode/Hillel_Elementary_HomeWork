package edu.palmirov.hillel.task_07.Vehicles;

public class Start {
    public static void main(String[] args){
        Car gaz2410 = new Car("sedan", "\"Volga\" GAZ-24-10",
                "FRT564RE009", 4,
                "Gasoline engine", "Steering wheel",
                1790, 25_000,
                4, 4,
                "ZMZ-402.1","GTR09U43",
                "Gasoline A93", 55,
                145);
        Train shinkansen500S = new Train("high-speed train", "Shinkansen Series 500",
                "XXXRRR777", 79,
                "Electric engine", "Stick",
                100_000, 1_000_000_000,
                "double-track", 1435,
                185);
        AirJet boeing777 = new AirJet("airlines jet", "Boeing 777-9X",
                "FRDHT574R43", 425,
                "jet engines", "Stick",
                352_000, 130_000_000,
                72, 14_750,
                13140, 945);

        Vehicle[] array = new Vehicle[]{gaz2410, shinkansen500S, boeing777};

        for(Vehicle temp : array){
            temp.move();
            temp.stop();
            System.out.println("-------------");
        }
    }
}