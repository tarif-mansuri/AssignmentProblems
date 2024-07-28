package com.tarif.day068.dsa.graph1.introductiondfscycledetection;

public class NumberOfIsLands {
	
	public int solve(int[][] A) {
		int ans = 0;
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				if(A[i][j] == 1) {
					ans++;
					dfs(A,i,j);
				}
			}
		}
        return ans;
    }
	
	public void dfs(int[][] A, int x, int y) {
		int[] dx = {-1,-1,-1, 0,0, 1,1,1};
		int[] dy = {-1, 0, 1,-1,1,-1,0,1};
		A[x][y] = 2;
		for(int i=0; i<8; i++) {
			int u = x+dx[i];
			int v = y+dy[i];
			if(u>=0 && u<A.length && v>=0 && v<A[u].length && A[u][v]==1) {
				dfs(A, u, v);
			}
		}
	}
	
	public static void main(String[] args) {
		NumberOfIsLands obj = new NumberOfIsLands();
		int[][] A = {{1,1,1,1,1},{1,0,1,0,0},{1,0,1,1,0},{1,0,1,0,1},{1,1,1,0,0},{1,0,1,1,1},{1,0,1,0,1},{0,1,1,0,0}};
		//[[1,1,1,1,1],[1,0,1,0,0],[1,0,1,1,0],[1,0,1,0,1],[1,1,1,0,0],[1,0,1,1,1],[1,0,1,0,1],[0,1,1,0,0]]
		int ans = obj.solve(A);
		System.out.println(ans);
	}

}
