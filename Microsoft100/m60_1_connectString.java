package W100;

public class m60_1_connectString {
	public static void main(String[] args) {
		String a="asadjksahdabcde";
		String b="abcdefkjkjfd";
		System.out.print(connect(a,b));
	}
	public static String connect(String a,String b) {
		int i=a.length()-1;
		int j=0;
		while(a.charAt(i)==b.charAt(j)) {
			i--;
			j++;
		}
		return a.substring(0,++i)+b;
	}

}
