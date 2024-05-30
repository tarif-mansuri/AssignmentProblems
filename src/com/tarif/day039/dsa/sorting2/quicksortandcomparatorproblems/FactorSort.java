package com.tarif.day039.dsa.sorting2.quicksortandcomparatorproblems;

import java.util.Arrays;

public class FactorSort {
	private static final int LIMIT = 10001;
	private static int[] factorCountOf = new int[LIMIT];
	private static int[] spfOf = new int[LIMIT];
	static {
		
		//populate spf
		for(int i=1; i<LIMIT; i++) {
			spfOf[i] = i;
		}
		for(int i=2; i*i<LIMIT; i++) {
			for(int j=i*i; j<LIMIT; j +=i) {
				if(spfOf[j] == j && j%i==0) {
					spfOf[j] = i;
				}
			}
		}
		
		//populate factors
		for(int i = 2; i<LIMIT; i++) {
			int n = i;
			int ans = 1;
			while(n>1) {
				int spf = spfOf[n];
				int count =0;
				while(n%spf ==0) {
					count++;
					n = n/spf;
				}
				ans = ans*(count+1);
			}
			factorCountOf[i] = ans;
		}
	}
	public int[] solve(int[] A) {
		Integer[] arr = new Integer[A.length];
		for(int i=0; i<A.length; i++) {
			arr[i] = A[i];
		}
		Arrays.sort(arr,(Integer x, Integer y)->{
            if(factorCountOf[x]-factorCountOf[y]<0){
                return -1;
            }else if(factorCountOf[x]-factorCountOf[y]>0){
                return 1;
            }else{
                return 0;
            }
        });
		for(int i=0; i<A.length; i++) {
			A[i] = arr[i];
		}
		return A;
    }
	public static void main(String[] args) {
		int[] A = {36,13,13,26,37,28,27,43,7};
		FactorSort fs = new FactorSort();
		fs.solve(A);
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}

}
