package tools;

public class BestSolution {
    int best = 0;
    public Solution bestsolution = null;
    public void update(int dissatisfaction, int satisfaction, Solution solution){

        int x = satisfaction-dissatisfaction;
        if(x>best) {
            best = x;
            bestsolution = solution;
        }
    }

    public int[] restoreassigment(){
        if(bestsolution == null) return null;
        int[] assigntemp = new int[bestsolution.assign.length];

        for(int i = 0; i<= bestsolution.assign.length-1;i++){
            assigntemp[i]=bestsolution.assign[i];
        }
        return assigntemp;
    }
}
