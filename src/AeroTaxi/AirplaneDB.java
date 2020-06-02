package AeroTaxi;

import AeroTaxi.airplanes.*;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AirplaneDB {

    public static void main(String[] args) {

        Bronze airplane1 = new Bronze(500,100,100,450, Propulsion.propeller);
        Silver airplane2 = new Silver(700,200,350,700,Propulsion.piston);
        Gold   airplane3 =   new Gold(900,350,900,1000,Propulsion.reaction,true);

        List<Airplane> aList = new ArrayList<>();

        aList.add(airplane1);
        aList.add(airplane2);
        aList.add(airplane3);

        try {
            BufferedWriter bair = new BufferedWriter(new FileWriter(new File("airplanes.json")));
            Gson gson = new Gson();
            String serialized = gson.toJson(aList,List.class);
            bair.write(serialized);
            bair.close();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}