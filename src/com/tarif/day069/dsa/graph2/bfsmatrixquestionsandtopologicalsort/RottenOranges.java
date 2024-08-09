package com.tarif.day069.dsa.graph2.bfsmatrixquestionsandtopologicalsort;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	public int solve(int[][] A) {
		Queue<OrangeCell> q = new LinkedList<>();
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(A[i][j]==2) {
					q.add(new OrangeCell(i, j, 0));
				}
			}
		}
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		int t = 0;
		while(!q.isEmpty()) {
			OrangeCell orange = q.poll();
			for(int i=0; i<4; i++) {
				int u = orange.u + dx[i];
				int v = orange.v + dy[i];
				if(u>=0 && u<A.length && v>=0 && v<A[u].length && A[u][v] == 1) {
					q.add(new OrangeCell(u, v, orange.h+1));
					if(orange.h+1>t) {
						t = orange.h+1;
					}
					A[u][v] = 2;
				}
			}
		}
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(A[i][j]==1) {
					return -1;
				}
			}
		}
		return t;
    }
	
	public static void main(String[] args) {
		int[][] A = {   {2, 1, 1},
		        		{1, 1, 0},
		                {0, 1, 1}   
		        	};
		
		RottenOranges obj = new RottenOranges();
		System.out.println(obj.solve(A));
	}
}


class OrangeCell{
	int u;
	int v;
	int h;
	public OrangeCell(int u, int v, int h) {
		super();
		this.u = u;
		this.v = v;
		this.h = h;
	}
}
