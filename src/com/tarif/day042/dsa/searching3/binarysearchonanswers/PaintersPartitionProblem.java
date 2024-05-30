package com.tarif.day042.dsa.searching3.binarysearchonanswers;

public class PaintersPartitionProblem {
	public int paint(int A, int B, int[] C) {
        int MOD = 10000003;
        long[] arr = new long[C.length];
        long l = 0;
        long h =0;
        
        for(int i=0; i<C.length; i++){
            arr[i] = (long)B*(long)C[i];
            if(arr[i]>l){
                l = arr[i];
            }
            h+=arr[i];
        }
        while(l<=h){
            long mid = l+(h-l)/2;
            int peopleForMidTime = getPeople(arr, mid);
            int peopleForMid_OneTime = getPeople(arr, mid-1);

            if(peopleForMidTime<=A && peopleForMid_OneTime>A){
                return (int)(mid%MOD);
            }
            if(peopleForMidTime<=A && peopleForMid_OneTime <=A) {
            	h = mid-1;
            }else {
            	l=mid+1;
            }
        }
        return -1;
    }
    public int getPeople(long[] A, long T){
        long c=1;
        long remT = T;
        for(int i=0; i<A.length; i++){
            if(A[i]>T){
                return Integer.MAX_VALUE;
            }
            if(A[i]<=remT){
                remT = remT-A[i];
            }else{
                remT = T;
                c++;
            }
        }
        return (int)c;
    }
    public static void main(String[] args) {
    	PaintersPartitionProblem ppp = new PaintersPartitionProblem();
    	int[] C = {185,186,938,558,655,461,441,234,902,681};
    	System.out.println(ppp.paint(3, 10, C));
    }

}
