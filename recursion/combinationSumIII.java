import java.util.ArrayList;
import java.util.List;

public class combinationSumIII {
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res , new ArrayList<>(), k , n , 1);
        System.out.println(res);
    }
    private static void backtrack(List<List<Integer>> res , List<Integer>ds , int k , int n , int start){
        if (n == 0 && ds.size() == k) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = start ; i<= 9 ; i++){
            ds.add(i);
            backtrack (res , ds , k , n-i , i+1);
            ds.remove(ds.size()-1);
        }
    }
}
