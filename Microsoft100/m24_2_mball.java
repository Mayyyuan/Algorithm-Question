package W100;
/**
 * A中包含B的最小长度，A首尾相连
 * @author myy
 *
 */
public class m24_2_mball {
	public static void main(String[] args) {
		char[] a="ABCSDFSDFD".toCharArray();
		char[] b="ABCD".toCharArray();
		System.out.println(findShortest(a,b));
	}
	public static int findShortest(char[] a,char[] b) {
		int[] hash=new int['z'+1];
		int begin=0;
		int end=0;
		int length=a.length;
		int res=length+1;
		int resBegin=-1;
		while(begin<length) {
			while(!allin(b,hash)) {
				hash[a[end%length]]++;
				if(end==length && begin==0) {
					return -1;
				}
				end++;
			}
			while(begin<length && allin(b,hash)) {
				hash[a[begin]]--;
				begin++;
			}
			if(res>end-begin+1) {
				res=end-begin+1;
				resBegin=begin-1;
			}
		}
		if(resBegin+res>length+1) {
			int i;
			for(i=resBegin;i<length;i++) {
				System.out.print(a[i]);
			}
			for(i=0;i<res-(length-resBegin);i++) {
				System.out.print(a[i]);
			}
		}
		
		else {
			for(int i=resBegin;i<resBegin+res;i++) {
				System.out.print(a[i]);
			}
		}
		return res;
	}
	
	public static boolean allin(char[] b, int[] hash) {
		for(int i=0; i < b.length; i++) {
			if(hash[b[i]] == 0) {
				return false;
			}
		}
		return true;
	}

}
