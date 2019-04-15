package W100;
/**
 * 字符串下一个大的数字
 * @author myy
 *
 */
public class nextLargeNum {
	public static void main(String[] args) {
		System.out.println(next("12321"));
	}
	public static String next(String str) {
		char[] ch=str.toCharArray();
		int n=ch.length;
		int j=n-1;
		for(;j>0;j--) {
			if(ch[j]>ch[j-1]) {
				int min=j;
				for(int k=j+1;k<n;k++) {
					if(ch[min]>ch[k] && ch[j-1]<ch[k]) {
						min=k;
					}
				}
				swap(ch,j-1,min);
				break;
			}
		}
		for(int i=j;i<n-1;i++){
			for(int k=j;k<n-1-(i-j);k++) {
				if(ch[k]>ch[k+1]) {
					swap(ch,k,k+1);
				}
			}
		}
		return new String(ch);
	}
	public static void swap(char[] ch,int i,int j) {
		char temp=ch[i];
		ch[i]=ch[j];
		ch[j]=temp;
	}
}
