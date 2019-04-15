package W100;
/**
 * 打印1到n位数的字符串
 * @author myy
 *
 */
public class m42_PrintString {
	public static void main(String[] args) {
		print1(2);
//		print2(2);
	}
//-------------------------方法一：字符串相加--------------------------------------
	public static void print1(int n) {
		char[] number=new char[n+1];
		for(int i=0;i<number.length;i++) {
			number[i]='0';
		}
		number[n]='\0';
		while(!IncrementIsOver(number)) {
			printNum(number);
		}
	}
	public static boolean IncrementIsOver(char[] number) {
		boolean isOver=false;
		int carry=0;
		int length=number.length;
		for(int i=length-2;i>=0;i--) {
			int nsum=number[i]-'0'+carry;
			if(i==length-2) {
				nsum++;
			}
			if(nsum>=10) {
				if(i==0) {
					isOver=true;
				}
				else {
					nsum=nsum-10;
					carry=1;
					number[i]=(char) ('0'+nsum);
				}
			}
			else {
				number[i]=(char) ('0'+nsum);
				break;
			}
		}
		return isOver;
	}
//-------------------------方法二：数字全排列--------------------------------------
	public static void print2(int n) {
		char[] number=new char[n+1];
		number[n]='\0';
		for(int i=0;i<10;i++) {
			number[0]=(char) (i+'0');
			print1ToMax(number,n,0);
		}
	}
	public static void print1ToMax(char[] number,int n,int index) {
		if(index==n-1) {
			printNum(number);
			return;
		}
		for(int i=0;i<10;i++) {
			number[index+1]=(char) ('0'+i);
			print1ToMax(number,n,index+1);
		}
	}
	// 公共函数：打印字符串
	public static void printNum(char[] number) {
		boolean isBegin=true;
		int length=number.length;
		for(int i=0;i<length;i++) {
			if(isBegin && number[i]!='0') {
				isBegin=false;
			}
			if(isBegin==false) {
				System.out.print(number[i]);
			}
		}
	}
}
