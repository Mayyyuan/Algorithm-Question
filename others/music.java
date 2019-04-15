package W100;
/**
 * 阿里2019笔试题1
 * @author myy
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class music {
	public static void main(String[] args) {
		String s1="singer_周杰|周杰伦|刘德华|王力宏;song_冰雨|北京欢迎你|七里香;actor_周杰伦|孙俪";
		String s2="请播放周杰伦的七里香给我听";
		Map<String,String> map=new HashMap<>();
		String[] strr=s1.split(";");
		for(int i=0;i<strr.length;i++) {
			String[] str=strr[i].split("_");
			String[] singers=str[1].split("\\|");		
			for(String singer:singers) {
//				System.out.println(singer);	
				if(!map.containsKey(singer)) {
					map.put(singer,str[0]);
				}
				else {
					map.put(singer,map.get(singer)+","+str[0]);
				}
			}
		}
		for (Entry<String, String> entry : map.entrySet()) { 
			String value=entry.getValue();
			String vals[]=value.split(",");
			ArrayList<String> list=new ArrayList<>();
			for(String val:vals) {
				list.add(val);
			}
			Collections.sort(list);
			value="";
			for(String val:list) {
				value+=val+",";
			}
			value=value.substring(0,value.length()-1);
			map.put(entry.getKey(),value);
		}
		System.out.println(solve(s2,map));
	}
	public static String solve(String s2,Map<String,String> map) {
		String res="";
		for(int i=s2.length()-1;i>=0;) {
			int j=i;
			String str=s2.substring(j,i+1);
			while(j>0 && !map.containsKey(str)) {
				j--;
				str=s2.substring(j,i+1);
			}
			if(map.containsKey(str)) {
				res=" "+str+"/"+map.get(str)+" "+res;
				i=j-1;
			}
			else {
				res=s2.substring(i,i+1)+res;
				i--;
			}
		}
		return res;
	}
}
