class Solution {
    private static class JobDetails {
        int start;
        int end;
        int profit;
        
        public JobDetails(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int numOfJobs = profit.length;
        JobDetails[] job = new JobDetails[numOfJobs];

        for(int i = 0; i < numOfJobs; ++i){
            job[i] = new JobDetails(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(job, Comparator.comparingInt(jobD -> jobD.end));
        int[] dp = new int[numOfJobs + 1];
        for(int i = 0; i < numOfJobs; ++i){
            int eTVal = job[i].end;
            int sTVal = job[i].start;
            int pVal = job[i].profit;

            int nonConflict = upper(job, i, sTVal);
            dp[i+1] = Math.max(dp[i], dp[nonConflict] + pVal);
        }

        return dp[numOfJobs];
    }

    private int upper(JobDetails[] job, int endI, int targetT){
        int low = 0;
        int high = endI;

        while(low < high){
            int mid = (low+high)/2;
            if(job[mid].end <= targetT){
                low = mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}