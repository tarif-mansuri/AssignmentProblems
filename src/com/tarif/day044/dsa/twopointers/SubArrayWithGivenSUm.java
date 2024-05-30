package com.tarif.day044.dsa.twopointers;

public class SubArrayWithGivenSUm {
	public int[] solve(int[] A, int B) {
        int l=0;
        int r = 1;
        if(A[0] == B){
            int[] ans = new int[1];
            ans[0] = A[0];
            return ans;
        }
        long sum = A[0];
        while(l<=r){
            if(sum>B){
            	if(l>=A.length) {
            		break;
            	}
            	sum -=A[l];
                l++;
            }else if(sum<B){
            	if(r>=A.length) {
            		break;
            	}
            		sum += A[r];
            		r++;
            }else{
                int[] ans = new int [r-l];
                int ind =0;
                while(l<r){
                    ans[ind++] = A[l++]; 
                }
                return ans;
            }
        }
        int[] ans = new int[1];
        ans[0] = -1;
        return ans;
    }
	public static void main(String[] args) {
		SubArrayWithGivenSUm sawgs = new SubArrayWithGivenSUm();
		int[] A = {1,1000000000};
		int[] ans = sawgs.solve(A, 1000000000);
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
