package W100;
/**
 * ×îĞ¡ÏàËÆ×Ö·û´®
 * @author myy
 *
 */
public class sameString {
	public static void main(String[] args) {
		System.out.println(samestring("ezte".toCharArray()));
	}
	public static String samestring(char[] s) {
		char index='a';
		char[] b=new char[s.length];
		for(int i=0;i<s.length;i++) {
			if(s[i]>='a' && s[i]<='z') {
				b[i]=index++;
				for(int j=i+1;j<s.length;j++) {
					if(s[i]==s[j]) {
						b[j]=b[i];
						s[j]='0';
					}
				}
			}
		}
		return new String(b);
	}
}
