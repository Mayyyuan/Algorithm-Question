package W100;
/**
 * 12 个高矮不同的人,排成两排,每排必须是从矮到高排列
 * 而且第二排比对应的第一排的人高,问排列方式有多少种?
 * @author myy
 *
 */
public class m56_12short {
	public static void main(String[] args) {
		int[] F=new int[6];
		int[] B=new int[6];
		int res=0;
		int ok;
		for(int state=0;state<(1<<12);state++) {
			if(bit(state)==6) {
				int i=0;
				int j=0;
				for(int k=0;k<12;k++) {
					if((state&(1<<k))!=0) {
						B[j++]=k;
					}
					else {
						F[i++]=k;
					}
				}
				ok=1;
				for(int k=0;k<6;k++) {
					if(B[k]<F[k]) {
						ok=0;
						break;
					}
				}
				res+=ok;
			}
		}
		System.out.println(res);
	}
	public static int bit(int n) {
		int res=0;
		while(n>0) {
			n&=(n-1);
			res++;
		}
		return res;
	}
}
