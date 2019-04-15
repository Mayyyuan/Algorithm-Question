package W100;
/**
 * �ȸ����n ֧����������ֱ���Ϊ0��1��2��������n-1��
 * ��֪����֮���ʵ���Աȹ�ϵ���洢��һ����ά����w[n][n]�У�
 * w[i][j] ��ֵ������Ϊi��j �Ķ����и�ǿ��һ֧������w[i][j]=i ����j��
 * ���ڸ������ǵĳ���˳�򣬲��洢������order[n]�У�
 * ����order[n] = {4,3,5,8,1......}����ô��һ�ֱ�������4 ��3�� 5 ��8��
 * .......
 * ʤ�߽�����������̭��ͬһ����̭�����ж�����������ϸ�֣�����������ţ���һ������һ�ֵ�ʤ�߰���˳�������������ȣ�
 * ���������4 ��5,ֱ�����ֵ�һ�����ʵ�֣�
 * ������ά����w��һά����order ����������������ε�����result[n]�����result����
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
