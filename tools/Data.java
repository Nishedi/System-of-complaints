package tools;

import lab02.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Data {

    public static ArrayList<String> read_data(URL url) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader ReadF = null;

        ReadF = new BufferedReader(new InputStreamReader(url.openStream()));

        String numstring = ReadF.readLine();
        try {
            while (numstring != null) {
                list.add(numstring);
                numstring = ReadF.readLine();
            }
        }catch (Exception er) {
            return null;
        }
        ReadF.close();

        for(String i: list){
            //System.out.println(i);
        }
        return list;
    }




    public static ArrayList<Person> load_data_person(ArrayList<String> list){
        ArrayList<Person> listint = new ArrayList<>();
        return listint;
    }




}
