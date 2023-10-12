/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak=findPeak(mountainArr);
        //Since we want the lowest index
        int res=binarySearchUp(mountainArr, target, peak);
        if(res!=-1)
            return res;
        return binarySearchDown(mountainArr, target, peak);
    }
    private int findPeak(MountainArray mountainArr){
        int left=0, right=mountainArr.length()-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
    private int binarySearchUp(MountainArray mountainArr, int target, int peak){
        int left=0,right=peak;
        while(left<=right){
            int mid=left+(right-left)/2;
            int midVal=mountainArr.get(mid);
            if(midVal==target)
                return mid;
            else if(midVal<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
    private int binarySearchDown(MountainArray mountainArr, int target, int peak){
        int left=peak, right=mountainArr.length()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int midVal=mountainArr.get(mid);
            if(midVal==target)
                return mid;
            else if(midVal<target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
}