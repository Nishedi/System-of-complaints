package tools;

import java.util.ArrayList;

public class Systemofcalculating {
    public static int[] numbers = null;
    public static int[] ranges = null;
    public static int n = 0;
    public Systemofcalculating(ArrayList<ArrayList<Integer>> list){
        this.n=list.size();
        this.numbers=new int[n+1];
        for(int i = 1; i<=n;i++){
           numbers[i]=0;
        }
        this.ranges = new int[n+1];
        for(int i = 1; i<=n; i++){
            ranges[i]=list.get(i-1).size();
        }

    }
    public static int numberofsolutions(){//funkcja zwraca liczbę rozwiązań dla metody bruteforce lub 1 000 000 000 gdy ta liczba jest większa od tej wartości
        int z = 1;
        for(int i = 1; i<=n; i++) {
            z = z * ranges[i];
            if(z>1000000000) return z;//Zabezpieczenie przed przekroczeniem zakresu int
        }
        return z;
    }

    public static void nextsolution(){
        for(int i = 1; i<=n; i++){
            numbers[i]++;
            if(numbers[i]<ranges[i])return;
            numbers[i]=0;
        }
    }


}
