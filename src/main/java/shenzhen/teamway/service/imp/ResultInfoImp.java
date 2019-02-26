package shenzhen.teamway.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shenzhen.teamway.mapper.ResultInfoMapper;
import shenzhen.teamway.model.ResultInfo;
import shenzhen.teamway.service.ResultInfoService;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-25 15:59
 **/
@Service
public class ResultInfoImp implements ResultInfoService {
    @Autowired
    ResultInfoMapper resultInfoMapper;

    public int insertIntoResult(ResultInfo r) {
        return resultInfoMapper.insert(r);
    }

    @Override
    public int getId() {
        return resultInfoMapper.selectId();
    }
}