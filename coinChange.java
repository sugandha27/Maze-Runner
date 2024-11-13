public class coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        for(int i =0; i<memo.length; i++){
            memo[i] = amount+1;
            memo[0] = 0;
            for(int coin:coins){
                if(coin<=i)
                memo[i] = Math.min(memo[i], memo[i-coin]+1);
                //+1 for coin itself
            }
        }
        return memo[amount] > amount? -1:memo[amount];
    }
}
