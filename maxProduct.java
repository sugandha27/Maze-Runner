public class maxProduct {
    public int maxProduct(int[] nums) {
        int i = 0, leftProd = 1, rightProd = 1, ans = nums[0];
        while(i<nums.length){
            leftProd = leftProd == 0 ? 1 : leftProd;
            rightProd = rightProd == 0 ? 1: rightProd;

            leftProd *= nums[i];
            rightProd *= nums[nums.length-i-1];

            ans = Math.max(ans, Math.max(leftProd, rightProd));
            i++;
        }
        return ans;
        
    }
}
