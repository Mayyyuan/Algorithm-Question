package W100;

import java.util.Arrays;
/**
 * ª ∫ÛŒ Ã‚
 * @author myy
 *
 */
public class countQueen {
	public static void main(String[] args) {
		System.out.println(countQueen(10));
	}
	public static int countQueen(int n) {
		int[][] chess=new int[n][n];
		return putQueueAtRow(chess,0,0);
	}
	public static int putQueueAtRow(int[][] chess,int row,int count) {
		int n=chess.length;
		if(row==n) {
			count++;
			return count;
		}
		int[][] temp=chess.clone();
		for(int i=0;i<n;i++) {
			Arrays.fill(temp[row],0);
			temp[row][i]=1;
			if(isOK(temp,row,i)) {
				count=putQueueAtRow(temp,row+1,count);
			}
		}
		return count;
	}
	public static boolean isOK(int[][] chess,int row,int col) {
		int step=1;
		while(step<=row) {
			if(chess[row-step][col]==1) {
				return false;
			}
			if(col-step>=0 && chess[row-step][col-step]==1) {
				return false;
			}
			if(col+step<chess.length && chess[row-step][col+step]==1) {
				return false;
			}
			step++;
		}
		return true;
	}
}
