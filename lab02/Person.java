package lab02;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Person {
    public final int id;
    public final ArrayList<Integer> preferention;
    public Person(int id, ArrayList<Integer> preferention){
        this.id=id;
        this.preferention = preferention;

    }

    public Person(String str){
        var tosplit=str.split(";");
        this.id=parseInt(tosplit[0].trim());
        var x =  tosplit[1].trim().split(",");


        this.preferention = new ArrayList<>();
        for(String s: x){
            this.preferention.add(parseInt(s));
        }

    }

    public int getId(){
        return id;
    }
    public int satisfaction(int numberoftaste/*numer smaku*/, int volume /*pojemność*/){
        int k =-1 ;
        for(int i = 0;i<=preferention.size()-1;i++){
            if(numberoftaste==preferention.get(i)){
                k=i;
            }
        }
        int wk;
        if(k==-1) return -1;
        else  wk = preferention.size()-k;


        return wk*volume;
    }


}
