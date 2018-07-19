package build.dream.common;

import build.dream.common.constants.Constants;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application extends ClassLoader {
    public static void main(String[] args) throws ParseException, IOException {
//        SpringApplication.run(Application.class, args);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN);
        Date startDate = simpleDateFormat.parse("2018-01-02 12:01:59");
        Date endDate = simpleDateFormat.parse("2018-12-02 12:10:11");

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTimeInMillis(startDate.getTime());

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTimeInMillis(endDate.getTime());


        long startTime = startDate.getTime();
        long endTime = endDate.getTime();

        Date start1 = null;
        Date end1 = null;
        Date startDay = null;
        Date endDay = null;

        Date start2 = null;
        Date end2 = null;
        if (startTime % 86400000 == 0) {
            start1 = startDate;
            startDay = startDate;
            end1 = startDate;
        } else {
            start1 = startDate;
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(86400000 - (startTime % 86400000) + startTime - 1000);
            end1 = calendar.getTime();
            startDay = new Date(86400000 - (startTime % 86400000) + startTime);
        }

        if (endTime % 86400000 == 0) {
            start2 = endDate;
            end2 = endDate;
            endDay = endDate;
        } else {
            start2 = endDate;
            end2 = endDate;
            endDay = new Date(endTime - (endTime % 3600000));
        }

        System.out.println(simpleDateFormat.format(start1));
        System.out.println(simpleDateFormat.format(end1));
        System.out.println(simpleDateFormat.format(startDay));
        System.out.println(simpleDateFormat.format(endDay));
        System.out.println(simpleDateFormat.format(start2));
        System.out.println(simpleDateFormat.format(end2));
    }
}
