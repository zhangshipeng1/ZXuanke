package converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;

public class CustomerConverter implements Converter<String,Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormat = null ;
		/*System.out.println("source.length()");
		switch (source.length()) {
		
		case 10:
			dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			break;
		case 8:
			dateFormat =new SimpleDateFormat("HH:mm:ss");	
					break;
		case 19:
			dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			break;

		default:
			
			break;
		}
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;*/
		if(Pattern.matches("\\d{4}-\\d{2}-\\d{2}", source)) {
			dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(source);
			} catch (ParseException e) {
			
			}
		} 
		if(Pattern.matches("\\d{2}:\\d{2}:\\d{2}", source)) {
			dateFormat=new SimpleDateFormat("HH:mm:ss");
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(source);
			} catch (ParseException e) {
			
			}
		} 
		if(Pattern.matches("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}", source)) {
			dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(source);
			} catch (ParseException e) {
			
			}
		} 
		return null;
	}

	

}
