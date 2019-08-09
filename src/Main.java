import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println( combinationSum(new int[]{5,3,2} , 8) );

    }

    // beautiful thing is "one" item can bed added miultiple times
    // with this structure using code below;
    // if it passes is statments it can be added many many times
    // with the for(i=from ...  and list.add(candidates[i])

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<>(), candidates, target, 0);
        return ans;

    }

    private static void dfs(List<List<Integer>> ans, List<Integer> list, int[] cand, int remain, int from) {

        System.out.println("dfs called; remain is " + remain + " and from is " + from  );

        System.out.println("items in list : " );

        for(int item : list){
            System.out.println("item in list is : "+ item );
        }

        System.out.println("end of printing list." );

        if (remain < 0) {
            System.out.println("remain negative, returning" );
            return;
        }

        if (remain == 0) {

            System.out.println("target matched ; adding list " +list);
            ans.add(new ArrayList<>(list));
            return;

        }

        for (int i = from; i < cand.length; ++i) {  //cand[] sorted; from is the starting point of picking elements at this level

            System.out.println("[inside for loop] i is : " + i + " and adding cand[i] to list " + cand[i] + " FROM WAS " + from  );
            list.add(cand[i]);
            dfs(ans, list, cand, remain - cand[i], i);

            System.out.println("removing " +  list.get(list.size() - 1) + " ; i is " + i + " and from was " + from );
            list.remove(list.size() - 1);

        }

    }

}



