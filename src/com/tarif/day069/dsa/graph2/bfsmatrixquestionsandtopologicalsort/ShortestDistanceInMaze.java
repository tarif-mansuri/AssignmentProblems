package com.tarif.day069.dsa.graph2.bfsmatrixquestionsandtopologicalsort;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInMaze {
	public int solve(int[][] A, int[] B, int[] C) {
		//B --> source points
		//C --> destination points
		Queue<Cell> q = new LinkedList<>();
		boolean[][][] visited = new boolean[A.length][A[0].length][4];
		explore(q, visited, B[0], B[1], A, 0);
		
		while(!q.isEmpty()) {
			Cell cell = q.poll();
			int direction = cell.direction;
			//check if its the destination
			if(direction == 0) {// From Left
				if(isWall(cell.u, cell.v+1, A) && cell.u == C[0] && cell.v == C[1]) {
					return cell.h;
				}else if(isWall(cell.u, cell.v+1, A)) {
					explore(q, visited, cell.u, cell.v, A, cell.h);
				}else {
					visit(q, visited, cell.u, cell.v+1, direction, A, cell.h+1);
				}
			}else if(direction==1) {// From Up
				if(isWall(cell.u+1, cell.v, A) && cell.u == C[0] && cell.v == C[1]) {
					return cell.h;
				}else if(isWall(cell.u+1, cell.v, A)) {
					explore(q, visited, cell.u, cell.v, A, cell.h);
				}else {
					visit(q, visited, cell.u+1, cell.v, direction, A, cell.h+1);
				}
			}else if(direction==2) {// From Right
				if(isWall(cell.u, cell.v-1, A) && cell.u == C[0] && cell.v == C[1]) {
					return cell.h;
				}else if(isWall(cell.u, cell.v-1, A)) {
					explore(q, visited, cell.u, cell.v, A, cell.h);
				}else {
					visit(q, visited, cell.u, cell.v-1, direction, A, cell.h+1);
				}
			}else{// From Down
				if(isWall(cell.u-1, cell.v, A) && cell.u == C[0] && cell.v == C[1]) {
					return cell.h;
				}else if(isWall(cell.u-1, cell.v, A)) {
					explore(q, visited, cell.u, cell.v, A, cell.h);
				}else {
					visit(q, visited, cell.u-1, cell.v, direction, A, cell.h+1);
				}
			}
			
		}
		return -1;
    }
	
	public void explore(Queue<Cell> q, boolean[][][] visited, int u, int v, int[][] A, int h) {
		//Going from left to right, coming From left
		visit(q, visited, u, v+1, 0, A, h+1);
		
		//Going from Up to Down, coming From Up
		visit(q, visited, u+1, v, 1, A, h+1);
		
		//Going from Right to Left, From Right
		visit(q, visited, u, v-1, 2, A, h+1);
		
		//Going from Down to Up, From Down
		visit(q, visited, u-1, v, 3, A, h+1);
	}
	
	public void visit(Queue<Cell> q, boolean[][][] visited, int u, int v, int direction, int[][] A, int h) {
		if(u>=0 && u<A.length && v>=0 && v<A[u].length && A[u][v] == 0 && visited[u][v][direction]==false) {
			q.add(new Cell(u,v,h,direction));
			visited[u][v][direction] = true;
		}
	}
	
	public boolean isWall(int u, int v, int[][]A) {
		if(u>=0 && u<A.length && v>=0 && v<A[u].length && A[u][v] == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		int[][] A = {{0,0,0},{0,1,0},{0,0,0},{1,0,0}};
		int[] B = {1,0};
		int[] C = {2,1};
		ShortestDistanceInMaze obj = new ShortestDistanceInMaze();
		System.out.println(obj.solve(A, B, C));
	}
}

class Cell{
	int u;
	int v;
	int h;
	int direction;//0-> from Left, 1-> from Up 2-> from Right, 3-> from Down
	Cell(int x, int y, int h, int direction){
		this.u = x;
		this.v = y;
		this.h = h;
		this.direction = direction;
		}
}
