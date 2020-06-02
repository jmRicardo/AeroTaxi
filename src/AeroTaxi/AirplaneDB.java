package AeroTaxi;

import AeroTaxi.airplanes.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class AirplaneDB {

    public static void main(String[] args) {

        /*Bronze airplane1 = new Bronze(500,100,100,450, Propulsion.propeller);
        Silver airplane2 = new Silver(700,200,350,700,Propulsion.piston);
        Gold   airplane3 =   new Gold(900,350,900,1000,Propulsion.reaction,true);

        List<Airplane> aList = new ArrayList<>();

        aList.add(airplane1);
        aList.add(airplane2);
        aList.add(airplane3);*/

        //System.out.println(AeroTaxi.airplanes);

        User user1 = new User("Padra", "Paraz", "11.111.111", 11);
        User user2 = new User("Pedre", "Perez", "22.222.222", 22);
        User user3 = new User("Pidri", "Piriz", "33.333.333", 33);
        User user4 = new User("Podro", "Poroz", "44.444.444", 44);
        User user5 = new User("Pudru", "Puruz", "55.555.555", 55);

        List<User> uList = new LinkedList<User>();

        uList.add(user1);
        uList.add(user2);
        uList.add(user3);
        uList.add(user4);
        uList.add(user5);

        System.out.println(uList);



    }
}
