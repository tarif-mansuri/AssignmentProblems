package com.tarif.day059.heap1.introduction;

public class ConnectRopes {
	public int solve(int[] A) {
		if(A.length<=1) {
			return 0;
		}
		buildHeap(A);
		int size = A.length;
		int ans = 0;
		while(size>1) {
			int x = getMin(A, size--);
			int y = getMin(A, size--);
			ans = ans + x+y;
			insert(A, size++, x+y);
		}
		return ans;
    }

    public void buildHeap(int[] A){
        int nonLeaph = (A.length - (A.length+1)/2)-1;
        for(int x = nonLeaph; x>=0; x--) {
        	int i = x;
        	while(i<A.length) {
        		int lc = 2*i + 1;
        		int rc = 2*i + 2;
        		if(lc<A.length && rc<A.length) {
        			if(A[lc]<A[i] && A[lc]<=A[rc]) {
            			swap(A, lc, i);
            			i = lc;
            		}else if(A[rc]<A[i] && A[rc]<=A[lc]) {
            			swap(A, rc, i);
            			i = rc;
            		}else {
            			break;
            		}       
        		}else if(lc<A.length) {
        			if(A[lc]<A[i]) {
        				swap(A, lc, i);
        				i = lc;
        			}else {
        				break;
        			}
        		}else {
        			break;
        		}
        	}
        }
    }
    
    public int getMin(int[] A, int N) {
    	int ans = A[0];
    	A[0] = A[N-1];
    	N--;
    	int i=0;
    	while(i<N) {
    		int lc = 2*i+1;
    		int rc = 2*i+2;
    		if(lc<N && rc <N) {
    			if(A[lc]<A[i] && A[lc]<=A[rc]) {
    				swap(A, lc, i);
    				i = lc;
    			}else if(A[rc]<A[i] && A[rc]<=A[lc]) {
    				swap(A, rc, i);
    				i = rc;
    			}else {
    				break;
    			}
    		}else if(lc<N) {
    			if(A[lc]<A[i]) {
    				swap(A, lc, i);
    				i = lc;
    			}else {
    				break;
    			}
    		}else {
    			break;
    		}
    	}
    	return ans;
    }
    
    public void insert(int[] A, int N, int ele) {
    	if(A.length == N) {
    		System.out.println("Heap Overflow");
    		return;
    	}
    	A[N] = ele;
    	while(N>0) {
    		int p = (N-1)/2;
    		if(A[p]>A[N]) {
    			swap(A, p, N);
    			N = p;
    		}else {
    			break;
    		}
    	}
    	
    }
    
    public void swap(int[] A, int i, int j) {
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
    
    public static void main(String[] args) {
    	ConnectRopes obj = new ConnectRopes();
    	int[] A = {16,7,3,5,9,8,6,15};
    	System.out.println(obj.solve(A));
    }

}
