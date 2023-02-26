package tools;

import lab02.Drink;
import lab02.Person;

import java.net.URL;
import java.util.*;

public class Problem {
    private  ArrayList<Drink> listofdrinks=new ArrayList<>();
    private  ArrayList<Person> listofpersons=new ArrayList<>();
    public int numberofperson(){
        return listofpersons.size();
    }



    public Person getperson(int i){
        return listofpersons.get(i - 1);
    }

    public Drink getDrink(int i){
        return listofdrinks.get(i-1);
    }

    public int numberofdrink(){
        return listofdrinks.size();
    }

    public ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public  int totalsatisfaction(int[] assign){
        int n = listofdrinks.size();
        int sum=0;
        for(int i =1 ; i<=n; i++) {
            sum = sum + listofpersons.get(assign[i] - 1).satisfaction(listofdrinks.get(i - 1).taste, listofdrinks.get(i - 1).volume);
        }
        return sum;
    }



    public void loaddatafromfile(URL namedrinks, URL namepersons) throws Exception {
        ArrayList<String> listnonparse_drinks=Data.read_data(namedrinks);
        for(String s: listnonparse_drinks){
            listofdrinks.add(new Drink(s));
        }

        ArrayList<String> listnonparse_persons = Data.read_data(namepersons);
        for(String s: listnonparse_persons){
            listofpersons.add(new Person(s));
        }

        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        for(int i = 0; i <= listofpersons.size()-1; i++){
            for(int taste: listofpersons.get(i).preferention){
                if(map.containsKey(taste)==false) map.put(taste, new ArrayList<Integer>());
                map.get(taste).add(i+1);
            }
        }
        for(int i = 0; i<=listofdrinks.size()-1;i++){
            int taste = listofdrinks.get(i).taste;
            list.add(map.get(taste));
        }


    }

    public int totaldissatisfaction(int[] assign){
        int n = listofdrinks.size();
        int sum = 0;
        int[] firsttastefullfill= new int[listofpersons.size()+1];
        for(int i = 1; i<=listofpersons.size(); i++){
            firsttastefullfill[i]=0;
        }
        for(int i = 1; i<=n;i++) {
            int person = assign[i];
            int preferention =listofpersons.get(assign[i]-1).preferention.get(0);
            int taste = listofdrinks.get(i-1).taste;
            int volume = listofdrinks.get(i-1).volume;
            if(preferention==taste) firsttastefullfill[person]=volume;
        }


        for(int i = 1 ; i<=listofpersons.size();i++){
            sum= sum+Math.max(400- firsttastefullfill[i], 0);

        }
        return sum;
    }

    public boolean admissibility(int[] assign){
        boolean difftaste = checkdifferencesoftasteforall(assign);
        boolean ifallgetdrink = ifallgetdrink(assign,listofpersons.size(), listofdrinks.size() );
        return (difftaste && ifallgetdrink);
    }


    public boolean ifallgetdrink(int[] assign, int numberofpersons, int numberofdrinks){
        int[] didget = new int[numberofpersons+1];
        for(int i = 1; i<=8; i++){
            didget[i-1]=0;
        }
        for(int i = 1; i <= numberofdrinks; i++){
            didget[assign[i]]=1;

        }
        for(int i = 1; i<= numberofpersons; i++){
            if(didget[i]==0)return false;
        }
        return true;
    }
    public boolean checkdifferencesoftasteforall(int[] assign){
        int n = listofdrinks.size();

        Set<Integer> set = new HashSet<>();
        for(int i =1; i<=n;i++ ){
            int person = assign[i];
            int taste = listofdrinks.get(i-1).taste;
            int x = person *1000 + taste;
            if(set.contains(x))
                return false;
            set.add(x);
        }
        return true;
    }

}
