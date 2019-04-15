package W100;
/**
 * ´óÊýÇó²î
 * @author myy
 *
 */
public class StringCha {
	public static void main(String[] args) {
		String s1="123";
		String s2="399";
		System.out.println(sub(s1,s2));
	}
	public static String sub(String s1,String s2) {
		char[] c1=new StringBuffer(s1).reverse().toString().toCharArray();
		char[] c2=new StringBuffer(s2).reverse().toString().toCharArray();
		int len1=c1.length;
		int len2=c2.length;
		int maxlen=Math.max(len1,len2);
		int[] result=new int[maxlen];
		char sign='+';
		if(len1<len2) {
			sign='-';
		}
		else if(len1==len2) {
			int i=len1-1;
			while(i>0 && c1[i]==c2[i]) {
				i--;
			}
			if(c1[i]<c2[i]) {
				sign='-';
			}
		}
		for(int i=0;i<maxlen;i++) {
			int num1=i<len1? c1[i]-'0':0;
			int num2=i<len2? c2[i]-'0':0;
			if(sign=='+') {
				result[i]=num1-num2;
			}
			else {
				result[i]=num2-num1;
			}
		}
		for(int i=0;i<maxlen-1;i++) {
			if(result[i]<0) {
				result[i+1]-=1;
				result[i]+=10;
			}
		}
		StringBuffer res=new StringBuffer();
		if(sign=='-') {
			res.append('-');
		}
		boolean flag=false;
		for(int i=maxlen-1;i>=0;i--) {
			if(result[i]==0 && flag==false) {
				continue;
			}
			else {
				flag=true;
			}
			res.append(result[i]);
		}
		if(res.toString().equals("")) {
			res.append(0);
		}
		return res.toString();
	}

}
