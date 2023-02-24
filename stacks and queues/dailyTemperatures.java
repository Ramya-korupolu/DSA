import java.util.Stack;  

class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] index = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--){
            int val = temperatures[i];
            while(!s.isEmpty() && temperatures[s.peek()] <= val){
                s.pop();
            }
            if(s.isEmpty()){
                index[i] = -1;
            } else {
                index[i] = s.peek();
            }
            s.push(i);
        }

        for(int i = 0; i < index.length; i++){
            if(index[i] == -1){
                index[i] = 0;
            } else {
                index[i] -= i;
            }
        }

        return index;
    }

    public static void main(String[] args){
        int temperatures[] = {73,74,75,71,69,72,76,73};
        int ans[] = dailyTemperatures(temperatures);
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
