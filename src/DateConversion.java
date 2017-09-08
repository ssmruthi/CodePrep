import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {

	public static void convert(String time) throws ParseException{
		Date date= new SimpleDateFormat("hh:mm:ssa").parse("19:12:12PM");
		System.out.println();
		System.out.println(new SimpleDateFormat("H:mm:ss").format(date));
	}
}
