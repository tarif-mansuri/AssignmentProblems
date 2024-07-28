package com.tarif.day062.dsa.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class FinishMaximumJobs {
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Pair> pairList = new ArrayList<>();
		for(int i=0; i<A.size(); i++) {
			pairList.add(new Pair(A.get(i), B.get(i)));
		}
		Collections.sort(pairList);
		int ans = 1;
		int end = pairList.get(0).end;
		for(int i=1; i<pairList.size(); i++) {
			Pair p = pairList.get(i);
			if(p.start>=end) {
				ans++;
				end = p.end;
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		FinishMaximumJobs obj = new FinishMaximumJobs();
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(3);
		A.add(2);
		A.add(6);
		//A.add(1);
		
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(9);
		B.add(8);
		B.add(9);
		//B.add(8);
		
		int ans = obj.solve(A, B);
		System.out.println(ans);
	}
}

class Pair implements Comparable<Pair>{
	int start;
	int end;
	Pair(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Pair p) {
		return this.end - p.end;
	}
}
