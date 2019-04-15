package W100;
/**
 * 谷歌笔试n 支队伍比赛，分别编号为0，1，2。。。。n-1，
 * 已知它们之间的实力对比关系，存储在一个二维数组w[n][n]中，
 * w[i][j] 的值代表编号为i，j 的队伍中更强的一支。所以w[i][j]=i 或者j，
 * 现在给出它们的出场顺序，并存储在数组order[n]中，
 * 比如order[n] = {4,3,5,8,1......}，那么第一轮比赛就是4 对3， 5 对8。
 * .......
 * 胜者晋级，败者淘汰，同一轮淘汰的所有队伍排名不再细分，即可以随便排，下一轮由上一轮的胜者按照顺序，再依次两两比，
 * 比如可能是4 对5,直至出现第一名编程实现，
 * 给出二维数组w，一维数组order 和用于输出比赛名次的数组result[n]，求出result。。
 * @author myy
 *
 */
import java.util.ArrayList;

public class m21_googleTeam {
	public static void main(String[] args) {
//		int[][] array={{0,0,0,0},{0,1,1,1},{0,1,2,2},{0,1,2,3}};
//		int[] order={1,2,3,0};
		int[][] array={{0,1,2,3,4},{1,1,2,3,4},{2,2,2,3,4},{3,3,3,3,4},{4,4,4,4,4}};
		int[] order={4,3,1,2,0};
		int[] result=GetResult(array,order);
		for(int r:result) {
			System.out.println(r+",");
		}
	}
	public static int[] GetResult(int[][] array, int[] order) {
		int n=order.length;
		int[] result=new int[n];
	    int i = 0;
	    int k = 1;
	    int j = n -1;
	    while(true) {
	    	i = 0;
	        if(i + k > n -1) {
	        	result[j] = order[0];
	        	break;
	        }
	        while(i + k <= n-1) {
	        	int ii = order[i];
	        	int kk = order[i+k];
	            if(array[ii][kk] == ii) {
	            	result[j--] = kk;
	            }
	            else {
	            	result[j--] = ii;
	                order[i]= kk;
	                order[i+k] = ii;
	            }
	            i=i+2*k;
	        }
	        k*=2;
	    }
	    return result;
	}
}
