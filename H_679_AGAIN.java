package LeetCode_Mid.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_679_AGAIN {
    public boolean judgePoint24(int[] nums) {
        List<Double> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add( (double)nums[i]);
        }
            return dfs(temp);
    }
    private boolean dfs(List<Double> list) {
        if(list.size()==1) {
            if(Math.abs(list.get(0)-24)<0.001) return true;
            else return false;
        }
        for(int i =0;i<list.size();i++) {
            for(int j = i+1;j<list.size();j++) {
                for(double c:compute(list.get(i),list.get(j))) {
                    List<Double> temp = new ArrayList<>();
                    temp.add(c);
                    for( int k=0;k<list.size();k++) {
                        if(k==i||k==j) continue;
                        temp.add(list.get(k));
                    }
                    return dfs(temp);
                }

            }
        }
        return false;

    }
    private List<Double> compute(double a, double b) {
        List<Double> temp = Arrays.asList(a+b,a-b,b-a,a*b,a/b,b/a);
        return temp;
    }
}
