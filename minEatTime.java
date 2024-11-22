import java.util.Arrays;

public class minEatTime {
     public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        if(h == piles.length)
        return piles[piles.length-1];
        int high = piles[piles.length-1];
        int low = 1;
        while(low<high){
        int mid = low + (high -low)/2;
        int hours = 0;
        for(int pile:piles){
            hours += (int) Math.ceil((double) pile/mid);
        }
        if(hours <= h)
        high = mid;
        else low = mid + 1;
        }
    return high;
    }
}
