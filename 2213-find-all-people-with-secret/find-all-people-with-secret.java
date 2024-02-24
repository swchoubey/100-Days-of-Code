class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int[] groups = new int[100000];
        List<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            groups[i] = i;
        }
        groups[firstPerson] = 0;
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
        int i = 0;
        while(i < meetings.length){
            int currTime = meetings[i][2];
            list.clear();
            while(i < meetings.length && meetings[i][2] == currTime){
                int g1 = find(groups, meetings[i][0]);
                int g2 = find(groups, meetings[i][1]);
                groups[Math.max(g1, g2)] = Math.min(g1, g2);
                list.add(meetings[i][0]);
                list.add(meetings[i][1]);
                ++i;
            }
            for(int j = 0; j < list.size(); ++j){
                if(find(groups, list.get(j)) != 0){
                    groups[list.get(j)] = list.get(j);
                }
            }
        }
        for(int j = 0; j < n; ++j){
            if(find(groups, j) == 0) res.add(j);
        }
        return res;
    }
    private int find(int[] groups, int index){
        while(index!=groups[index]) index = groups[index];
        return index;
    }
}