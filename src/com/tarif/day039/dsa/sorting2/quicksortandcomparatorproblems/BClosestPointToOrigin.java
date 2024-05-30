package com.tarif.day039.dsa.sorting2.quicksortandcomparatorproblems;

import java.util.ArrayList;
import java.util.Collections;

public class BClosestPointToOrigin {
	public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
			Collections.sort(A, (ArrayList<Integer> x, ArrayList<Integer> y)->{
				if((x.get(0)*x.get(0) + x.get(1)*x.get(1)) - (y.get(0)*y.get(0)+y.get(1)*y.get(1))<0) {
					return -1;
				}else if((x.get(0)*x.get(0) + x.get(1)*x.get(1)) - (y.get(0)*y.get(0)+y.get(1)*y.get(1))>0) {
					return 1;
				}else {
					return 0;
				}
			});
			ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<B;i++) {
				ans.add(A.get(i));
			}
	        return ans;
	    }

}
