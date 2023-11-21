class Solution {
    public int rev(int n){
        int rev=0;
        while(n>0){
            rev = rev*10 + n%10;
            n/=10;           
        }
        return rev;
    }
    public int countNicePairs(int[] nums) {
    var map = new HashMap<Integer, Integer>();
    var count = 0;
    for(var n : nums)    {
        var rev = rev(n);
        var a = map.getOrDefault(n-rev, 0);
        count = (count+a)%1000000007;
        map.put(n-rev, a+1);
    }
    return count;
    }
}