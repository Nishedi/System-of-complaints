package lab02;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Drink {
    public final int id;
    public final int taste;
    public int volume;


    public Drink(int id, int taste, int volume) {
        this.id = id;
        this.taste = taste;
        this.volume = volume;
    }
    public Drink(String str){
        var tosplit=str.split(";");

        this.id =parseInt(tosplit[0].trim());
        this.taste = parseInt(tosplit[1].trim());;
        this.volume = parseInt(tosplit[2].trim());
    }



}
