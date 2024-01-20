class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < n; ++i){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                left[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i >= 0; --i){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                right[i] = st.peek();
            }
            st.push(i);
        }
        int mod = (int) 1e9 + 7;
        long res = 0;
        for(int i = 0;i < n;++i){
            res+= (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            res%=mod;
        }
        return (int) res;
    }
}