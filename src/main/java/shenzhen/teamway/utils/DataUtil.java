package shenzhen.teamway.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: NettyTimeClient
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2018-09-03 09:31
 **/
public class DataUtil {

    public static String getDate2String(Date date){
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String s = format.format(date);
        return s;

    }

    public static void main(String[] args) {
        final LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

}