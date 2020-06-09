package AeroTaxi.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONUtily {

    /// Save and Load de nuestros 3 archivos en 4 funciones
    public static <T> void saveFile(String path, List<T> list)
    {
        BufferedWriter buff = null;
        try {
            buff = new BufferedWriter(new FileWriter(new File(path)));
        } catch (IOException e) {
            System.out.println("error al abrir el archivo para escritura!");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        String serialized = null;
        try {
            serialized = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            System.out.println("error al serializar!");
        }
        try {
            assert serialized != null;
            assert buff != null;
            buff.write(serialized);
        } catch (IOException e) {
            System.out.println("error al escribir el archivo!");
        }
        try {
            buff.close();
        } catch (IOException e) {
            System.out.println("error al cerrar el archivo!");
        }
    }

    public static <T> List<T> loadFile(String path){
        List<T> list = new ArrayList<>();
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(new File(path)));
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            return list;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            list = mapper.readValue(buff, new TypeReference<ArrayList<T>>(){});
        } catch (IOException e) {
            System.out.println("Error al deserializar!");;
        }
        return list;
    }
}
