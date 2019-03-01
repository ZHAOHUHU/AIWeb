package shenzhen.teamway.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shenzhen.teamway.mapper.FacedelectMapper;
import shenzhen.teamway.model.Facedelect;
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
   /**
    * @Author: Zhao Hong Ning
    * @Description:获取当前插入的最大id
    * @Date:  2019/2/28 
    * @param:  
    * @return: int
   */
    @Override
    public int getId() {
        return facedelectMapper.selectId();
    }

    @Override
    public int getCountById(int id) {
        return facedelectMapper.selectById(id);
    }

    @Override
    public int updateResult(Facedelect facedelect) {
        return facedelectMapper.updataResult(facedelect);
    }
}