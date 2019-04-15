package W100;
/**
 * 字符串逆转，不开辟任何空间
 * @author myy
 *
 */
public class m65_reverseString {
	public static void main(String[] args) {
		String str="asdada";
		char[] ch=str.toCharArray();
		reverse(ch);
		System.out.println(ch);
	}
	public static void reverse(char[] ch) {
		for(int i=0,j=ch.length-1;i<j;i++,j--) {
			ch[i]=(char) (ch[i]^ch[j]);
			ch[j]=(char) (ch[i]^ch[j]);
			ch[i]=(char) (ch[i]^ch[j]);
		}
	}
}
