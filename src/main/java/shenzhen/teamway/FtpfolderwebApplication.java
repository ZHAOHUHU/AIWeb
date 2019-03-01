package shenzhen.teamway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shenzhen.teamway.nettyTcp.NettyClient;
import shenzhen.teamway.service.ResultInfoService;

@SpringBootApplication
@MapperScan("shenzhen.teamway.mapper")
public class FtpfolderwebApplication implements CommandLineRunner {
    @Autowired
    NettyClient nettyClient;

    public static void main(String[] args) {
        SpringApplication.run(FtpfolderwebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        nettyClient.connect("192.168.200.239", 6666);
    }
}
