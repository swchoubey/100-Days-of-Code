class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();

        for(int i = 0; i < n; i++){
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }

        Collections.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();

        for(int[] r : robots){
            if(r[2] == 'R' || stack.isEmpty() || stack.peek()[2] == 'L'){
                stack.push(r);
                continue;
            }
            if(r[2] == 'L'){
                boolean add = true;
                while(!stack.isEmpty() && stack.peek()[2] == 'R' && add){
                    int last = stack.peek()[1];
                    if(r[1] > last){
                        stack.pop();
                        r[1] -= 1;
                    }
                    else if(r[1] < last){
                        stack.peek()[1] -= 1;
                        add = false;
                    }
                    else{
                        stack.pop();
                        add = false;
                    }
                }
                if(add){
                    stack.push(r);
                }
            }
        }
        List<int[]> res = new ArrayList<>(stack);
        res.sort(Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();

        for(int[] robot : res){
            result.add(robot[1]);
        }

        return result;
    }
}