public class binarySearch {
    public int search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        while(low<high){
            if(nums[(high+low)/2] == target)
            return (high+low)/2;
            else if(nums[(high+low)/2] < target)
            low = (high+low)/2 +1;
            else high = (high+low)/2 ;
        }
        if(low == high && nums[low]==target)
        return low;
        return -1;
    }
}
