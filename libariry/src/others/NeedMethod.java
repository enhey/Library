package others;

import java.util.Date;
import java.util.Vector;

public class NeedMethod {
	public boolean isNum(String data) {
		int flag=0;
		for (int i = 0; i < data.length(); i++) {
			if((data.charAt(i)<'0'||data.charAt(i)>'9')&&data.charAt(i)!='.') {				
				return false;
			}
			if(data.charAt(i)=='.')
				flag++;	
		}
		if(flag>1)
			return false;
		return true;
	}

}
