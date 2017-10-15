/**
 * Created by Hemanth on 8/15/2017.
 */
public class Solution {

    public int splitRecursion(String x){
        if(x=="" || isPalindrome(x)){
//			System.out.println(x);
            return 0;
        }else{
            int cuts = Integer.MAX_VALUE;
            for (int i = 1; i <x.length() ; i++) {
                cuts  = Math.min(1+ splitRecursion(x.substring(0, i)) + splitRecursion(x.substring(i, x.length())),cuts);
            }
            return cuts;
        }
    }
    public boolean isPalindrome(String s){
        int n = s.length();
        for (int i=0;i<(n / 2) + 1;++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.print(s.splitRecursion("abcde"));
    }
}
