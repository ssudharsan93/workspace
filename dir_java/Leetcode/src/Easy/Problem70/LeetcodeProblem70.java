package src.Easy.Problem70;

class Solution {
    //This looks like a fibonacci problem. or a recurrence relation problem
    // How do we write a recurrence relation for this problem?
    // Base case is 1
    // n = 2 case is 2 (11, 2)
    // n = 3 case is 3 (111, 12, 21)
    // n = 4 case is 5 ( 1111, 22, 211, 112, 121 )
    // n = 5 case is 8 ( 11111, 221, 122, 212, 1112, 2111, 1211, 1121 )
    // n = 6 case is 13 (111111, 222, 2211, 1122, 2112, 2121, 1212, 1221, 21111, 11112, 12111, 11211, 11121)

    public int climbStairs(int n) {
        //return recursiveSolution(n);
        return dynamicProgrammingSolution(n);

    }

    public int dynamicProgrammingSolution(int n){
        int prev = 1;
        int curr = 2;
        int tmp;

        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;

        for ( int dpIdx = 3; dpIdx <= n; dpIdx++ ){
            tmp = curr;
            curr = prev + curr;
            prev = tmp;
        }

        return curr;
    }

    public int recursiveSolution(int n){
        if ( n == 1 )  return 1;
        if ( n == 2 )  return 2;
        return recursiveSolution(n-1) + recursiveSolution(n-2);
    }

    public static void main(String[] args){
        System.out.println(new Solution().climbStairs(6));
        System.out.println(new Solution().climbStairs(10));
    } 
}