class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer,Integer> blooming = new TreeMap<>();
        int[] arr=new int[people.length];
        int count=0;
        for(int i=0;i<flowers.length;i++){
            int start=flowers[i][0];
            int end=flowers[i][1];
            blooming.put(start,blooming.getOrDefault(start,0)+1);
            blooming.put(end+1,blooming.getOrDefault(end+1,0)-1);
        }
        for(int key:blooming.keySet()){
            count+=blooming.get(key);
            blooming.put(key,count);
        }
        for(int i=0;i<people.length;i++){
            Integer key=blooming.floorKey(people[i]);
            arr[i]=(key==null)?0:blooming.get(key);
        }
        return arr;
    }
}