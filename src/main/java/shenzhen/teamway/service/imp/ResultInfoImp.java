package shenzhen.teamway.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shenzhen.teamway.mapper.FacedelectMapper;
import shenzhen.teamway.mapper.ResultInfoMapper;
import shenzhen.teamway.model.Facedelect;
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
    FacedelectMapper facedelectMapper;

    /**
     * @Author: Zhao Hong Ning
     * @Description:自己获取的图片路径存入数据库 和id形成关联关系
     * @Date: 2019/2/27
     * @param: facedelect
     * @return: int
     */
    @Override
    public int insertFace(Facedelect facedelect) {
        return facedelectMapper.insert(facedelect);
    }

    @Override
    public int getId() {
        return facedelectMapper.selectId();
    }
}