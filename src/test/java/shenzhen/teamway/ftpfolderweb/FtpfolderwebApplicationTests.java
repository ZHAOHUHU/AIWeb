package shenzhen.teamway.ftpfolderweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shenzhen.teamway.FtpfolderwebApplication;
import shenzhen.teamway.model.Facedelect;
import shenzhen.teamway.service.ResultInfoService;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FtpfolderwebApplication.class)
public class FtpfolderwebApplicationTests {
    @Resource
    ResultInfoService resultInfoService;

    @Test
    public void contextLoads() {
        final Facedelect f = new Facedelect();
        f.setFilepath("asdfsdagfdsgfdsgsgsgsg");
        f.setResult("ojbk");
        final int id = resultInfoService.insertFace(f);
        System.out.println("返回值是多少啊啊============"+f.getId());
    }

    @Test
    public void contextLoad() {
        System.out.println("aaaaaaaaaaaaa");
    }

}
