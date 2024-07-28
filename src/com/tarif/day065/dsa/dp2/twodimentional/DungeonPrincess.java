package com.tarif.day065.dsa.dp2.twodimentional;

public class DungeonPrincess {
	public int calculateMinimumHP(int[][] A) {
		int N = A.length;
		int M = A[0].length;
		int[][] h = new int[N][M];
		for(int i=N-1; i>=0; i--) {
			for(int j=M-1; j>=0; j--) {
				if(i==N-1 && j == M-1) {
					h[N-1][M-1] = Math.max(1, 1-A[N-1][M-1]);
				}
				else if(i==N-1) {
					h[i][j] = Math.max(1, h[i][j+1]-A[i][j]);
				}else if(j==M-1) {
					h[i][j] = Math.max(1, h[i+1][j]-A[i][j]);
				}else {
					h[i][j] = Math.max(1, Math.min(h[i+1][j]-A[i][j], h[i][j+1]-A[i][j]));
				}
			}
		}
		return h[0][0];
    }
	
	public static void main(String[] args) {
		DungeonPrincess obj = new DungeonPrincess();
		int[][] A = {
				{1, -1, 0},
				{-1, 1, -1},
				{1, 0, -1}
		};
		
		System.out.println(obj.calculateMinimumHP(A));
	}
}
