package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date ObterDataDiferencaDias(int dias){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, dias);
        return cal.getTime();
    }

}
