package AeroTaxi;

import AeroTaxi.airplanes.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonList {

    private List<Airplane> list;

    public List<Airplane> getList() {
        return list;
    }

    public void setList(List<Airplane> list) {
        this.list = list;
    }

    public static void main(String[] args) throws IOException {

        Gold airplane = new Gold(900,350,900,1000, Propulsion.reaction,true);
        Bronze airplane1 = new Bronze(500,100,100,450, Propulsion.propeller);
        Silver airplane2 = new Silver(700,200,350,700,Propulsion.piston);

        List<Airplane> airplanes = new ArrayList<>();

        airplanes.add(airplane);
        airplanes.add(airplane1);
        airplanes.add(airplane2);

        JsonList test = new JsonList();

        BufferedWriter buff = new BufferedWriter(new FileWriter(new File("airplanestest.json")));

        test.setList(airplanes);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        String serialized = mapper.writeValueAsString(test);
        buff.write(serialized);
        buff.close();

        JsonList testDes = mapper.readValue(serialized, JsonList.class);

        System.out.println(testDes.getList());


        //System.out.println(testDes);




    }
}
