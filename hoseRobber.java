public class hoseRobber {
    public int rob(int[] nums) {
        int[] maxRobber = new int[nums.length+1];
        maxRobber[0] = nums[0];
        if(nums.length>1)
        maxRobber[1] = Math.max(nums[0], nums[1]);
        for(int i =2; i<nums.length; i++){
            maxRobber[i] = Math.max(maxRobber[i-2]+ nums[i], maxRobber[i-1]);
        }
        return maxRobber[nums.length-1];
    }
}
