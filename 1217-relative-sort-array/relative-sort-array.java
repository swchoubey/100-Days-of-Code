class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : arr1){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }
            else{
                map.put(n, 1);
            }
        }
        int[] res = new int[arr1.length];
        int count = 0;
        for(int n : arr2){
            while(map.get(n) > 0){
                res[count] = n;
                count++;
                map.put(n, map.get(n) - 1);
            }
            map.remove(n);
        }
        int[] rem = new int[arr1.length - count];
        int i = 0;
        for(int n : arr1){
            if(map.containsKey(n)){
                while(map.get(n) > 0){
                    rem[i] = n;
                    i++;
                    map.put(n, map.get(n) - 1);
                }
                map.remove(n);
            }
        }
        Arrays.sort(rem);
        for(int n : rem){
            res[count] = n;
            count++;
        }

        return res;
    }
}