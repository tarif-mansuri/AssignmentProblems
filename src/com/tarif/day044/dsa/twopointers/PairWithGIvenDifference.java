package com.tarif.day044.dsa.twopointers;

import java.util.Arrays;
import java.util.HashSet;

public class PairWithGIvenDifference {
	public int solve(int[] A, int B) {
        HashSet<String> set= new HashSet<>();
        Arrays.sort(A);
        int i=0; 
        int j=1;
        while(j<A.length){
            if(A[j] - A[i] == B){
                set.add(""+A[j]+A[i]);
                i++;
                j++;
            }else if(A[j] - A[i]>B){
                i++;
                if(i==j) {
                	j++;
                }
            }else{
                j++;
            }
        }
        return set.size();
    }
	
	public static void main(String[] args) {
		PairWithGIvenDifference pwgd = new PairWithGIvenDifference();
		int[] A = {1,2};
		System.out.println(pwgd.solve(A, 0));
	}

}
