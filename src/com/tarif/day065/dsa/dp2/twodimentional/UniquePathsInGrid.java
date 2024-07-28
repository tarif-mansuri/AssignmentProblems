package com.tarif.day065.dsa.dp2.twodimentional;

public class UniquePathsInGrid {
	public int uniquePathsWithObstacles(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int[][]dp = new int[n][m];
		for(int i=0; i<n; i++) {
			if(A[i][0]==0) {
				dp[i][0]=1;
			}else {
				break;
			}
		}
		for(int i=0; i<m; i++) {
			if(A[0][i]==0) {
				dp[0][i]=1;
			}else {
				break;
			}
		}
		for(int i=1; i<n; i++) {
			for(int j = 1; j<m; j++) {
				{
					if(A[i][j]!=1) {
						dp[i][j] = dp[i-1][j]+dp[i][j-1];
					}
				}
			}
		}
		return dp[n-1][m-1];
    }
	
	public static void main(String[] args) {
		UniquePathsInGrid obj = new UniquePathsInGrid();
		int[][] A = {{1,0}};
		System.out.println(obj.uniquePathsWithObstacles(A));
	}
}
