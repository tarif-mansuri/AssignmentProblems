package com.tarif.day066.dsa.dp3.knapsack;

public class FractionalKnapsack {
	
	public int solve(int[] V, int[] W, int C) {
		for(int i=0; i<V.length; i++) {
			V[i] = V[i]/W[i];
		}
		
		return 0;
    }

}
