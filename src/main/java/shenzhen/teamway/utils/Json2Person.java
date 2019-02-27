package shenzhen.teamway.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import shenzhen.teamway.jsonResult.FaceResult;
import shenzhen.teamway.model.Facedelect;

import java.io.IOException;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-27 16:18
 **/
public class Json2Person {
    static org.slf4j.Logger log = LoggerFactory.getLogger(Json2Person.class);

    public static FaceResult getResult(String s) {
        final String substring = s.substring(1, s.length() - 1);
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(substring, FaceResult.class);
        } catch (IOException e) {
            log.error("json解析错误");
            e.printStackTrace();

        }
        return null;
    }
}