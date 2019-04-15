package W100;
/**
 * 实现平方根函数
 * @author myy
 *
 */
import java.util.ArrayList;

public class Sqrt {
	public static void main(String[] args) {
		System.out.println(Math.sqrt(65));
		System.out.println(sqrt(65));
	}
	public static double sqrt(double n) {
		if(n<0) {
			throw new RuntimeException("Negetive number cannot have a sqrt root.");
		}
		double low=0;
		double high=n;
		double mid=(low+high)/2;
		double prec=1e-9;
		while(high-low>prec) {
			if(mid*mid>n) {
				high=mid;
			}
			else if(mid*mid<n) {
				low=mid;
			}
			else {
				return mid;
			}
			mid=(low+high)/2;
		}
		return mid;
	}
}
