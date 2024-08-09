package com.tarif.day066.dsa.dp3.knapsack;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {
	
	public int solve(int[] V, int[] W, int C) {
		ArrayList<Item> list = new ArrayList<>();
		for(int i=0; i<V.length; i++) {
			//double k = (double)((double)V[i]/W[i]);
			list.add(new Item(V[i], W[i], (double)((double)V[i]/W[i])));		
			}
		Collections.sort(list, (a,b)->{
			if(a.valuePerKg-b.valuePerKg<0) {
				return 1;
			}else if(a.valuePerKg-b.valuePerKg>0) {
				return -1;
			}else {
				return 0;
			}
		});
		double sum = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).weight<=C) {
				sum +=(list.get(i).value);
				C = C - list.get(i).weight;
			}else {
				sum +=list.get(i).valuePerKg * C;
				break;
			}
		}
		//System.out.println(sum);
		return (int)(sum*1000/10);
    }
	
	public static void main(String[] args) {
		double k = 2.55;
		//System.out.println((int)(k*1000/10));
		FractionalKnapsack obj = new FractionalKnapsack();
		int[] V = {3};
		int[] W = {20};
		System.out.println(obj.solve(V, W, 17));
	}

}

class Item{
	int value;
	int weight;
	double valuePerKg;
	public Item(int value, int weight, double valuePerKg) {
		this.value = value;
		this.weight = weight;
		this.valuePerKg = valuePerKg;
	}
}
