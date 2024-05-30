package com.tarif.day044.dsa.twopointers;

import java.util.Arrays;

public class ThreeSumProblem {
	public int threeSumClosest(int[] A, int B) {
        long ans = Integer.MAX_VALUE;
        Arrays.sort(A);
        for(int i=0; i<A.length-2; i++){
            int j=i+1;
            int k = A.length-1;
            while(j<k){
                int temp = A[i]+A[j]+A[k];
                if(Math.abs(temp-B)<Math.abs(ans-B)){
                    ans = temp;
                }
                if(temp>B){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return (int)ans;
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3};
		ThreeSumProblem threeSum = new ThreeSumProblem();
		System.out.println(threeSum.threeSumClosest(A, 1));	
		}

}
