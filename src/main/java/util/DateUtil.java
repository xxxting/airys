package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类
 * @author 何晓庭
 *
 */
public class DateUtil {
	public static Date toDate(String dateFormat,String date){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String dateToString(String dateFormat,Date date) {
		
		return new SimpleDateFormat(dateFormat).format(date);
	}

}

