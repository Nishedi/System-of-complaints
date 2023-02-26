package tools;

public class Solution {
    public int totalsatisfaction = 0;
    public int totaldissatisfaction = 0;
    public int[] assign = null;
    public Solution(int totalsatisfaction, int totaldissatisfaction, int[] assign){
        this.totalsatisfaction=totalsatisfaction;
        this.totaldissatisfaction=totaldissatisfaction;
        this.assign=new int[assign.length];
        for(int i = 0; i <= assign.length-1; i++){
            this.assign[i]=assign[i];
        }
    }
    public void writetoconsole(){
        for(int i = 1; i<=assign.length-1;i++){


            System.out.print(assign[i]+" ");
        }
        System.out.println("");
        System.out.println("totsat="+totalsatisfaction+" "+"totdist="+totaldissatisfaction);
    }
}
