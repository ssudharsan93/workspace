package src.Hard.Problem2398;

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        //chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
        int [] chargeTimes = new int[]{3,6,1,3,4};  
        int [] runningCosts = new int[]{2,1,3,4,5};  
        long budget = 25;  
        System.out.println(sol.maximumRobots(chargeTimes, runningCosts, budget));

        //chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19
        int [] chargeTimes2 = new int[]{11,12,19};  
        int [] runningCosts2 = new int[]{10,8,7};  
        long budget2 = 19;  
        System.out.println(sol.maximumRobots(chargeTimes2, runningCosts2, budget2));
    }
}