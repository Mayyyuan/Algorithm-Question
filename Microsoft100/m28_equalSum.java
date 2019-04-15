package W100;
/**
 * һ���������飬����Ϊn�������Ϊm �ݣ�ʹ���ݵĺ���ȣ�
 * ��m �����ֵ����{3��2��4��3��6} ���Էֳ�
 * {3��2��4��3��6} m=1
 * {3,6}{2,4,3} m=2
 * {3,3}{2,4}{6} m=3 
 * ����m �����ֵΪ3
 * @author myy
 *
 */
import java.util.Arrays;

/**
 * ����Ϊm��ʱ����Ҫ�߱���������
 * m��ȡֵΪ1~n
 * ÿһ����֮��Ϊ sum/m; ��sumΪ����Ԫ��֮�ͣ�
 * sum % m == 0�����򲻿���ƽ��
 * �ݹ�˼�룺
 * �����Ϊm�飬ÿһ��֮�ͼ�ΪsubSum = sum / m��subSum��Ϊÿһ��Ԫ��֮�͡�
 * ���array[i]��ĳһ�����У�����Ҫ�����������Ԫ�����ҳ���ֵΪ(subSum - array[i])����ϡ�
 * ����bool������Ԫ���Ƿ��ѷ��䵽ÿһ���С�
 */
public class m28_equalSum {
	public static void main(String[] args) {
		int[] array = {3,2,4,3,6}; 
		System.out.println(maxLength(array,array.length));
	}
	public static int maxLength(int[] array,int n) {
		if(n<=1) {
			return n>=0? n:0;
		}
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=array[i];
		}
		boolean[] flag=new boolean[n];
		int m;
		for(m=n;m>1;m--) {
			if(sum%m!=0) {
				continue;
			}
			Arrays.fill(flag,false);
			int i;
			for(i=0;i<n;i++) {
				if(flag[i]==false) {
					flag[i]=true;
					if(!divide(array,flag,n,sum/m-array[i])) {
						break;
					}
				}
			}
			break;
		}
		return m;
	}
	public static boolean divide(int[] array,boolean[] flag,int n,int sum) {
		if(sum<0) {
			return false;
		}
		if(sum==0) {
			return true;
		}
		for(int i=n-1;i>=0;i--) {
			if(flag[i]==false && array[i]<=sum) {
				flag[i]=true;
				if(divide(array,flag,n,sum-array[i])) {
					return true;
				}
				else {
					flag[i]=false;
				}
			}
		}
		return false;
	}
}
