package shenzhen.teamway.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * @program: FTPFolder
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-23 11:15
 **/
public class PropertiesUtils {

    static Logger log = LoggerFactory.getLogger(PropertiesUtils.class);

    static Properties p = new Properties();

    public static boolean loadPropertiesFile(String path) {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(path));
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("读取properties配置文件异常", e);
            return false;
        }

        return true;
    }

    public static String getValue(String key) {
        final String property = p.getProperty(key);
        if (property == null) {
            log.error("获取到的properties值为空，key: " + key);
        }

        log.debug("读取属性文件，" + key + '/' + property);
        return property;
    }

    public static void main(String[] args) {
        String a = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "application.properties";
        System.out.println(a);
        final boolean b = PropertiesUtils.loadPropertiesFile(a);
        if (b) {
            final String aa = PropertiesUtils.getValue("aa");
            System.out.println(aa);
        }
    }
}