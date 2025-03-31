// Tc:O(n^2)
// sc:o(n^2)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int [n][n];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        dp[0][0] = triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j]=triangle.get(i).get(j)+dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j]=triangle.get(i).get(j)+dp[i-1][j-1];
                }else{
                    dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i-1][j],dp[i-1][j-1]);         
                }
            }
        }
        int cost = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            cost = Math.min(cost,dp[n-1][j]);
        }
        return cost;
    }
}