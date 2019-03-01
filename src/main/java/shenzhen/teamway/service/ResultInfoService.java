package shenzhen.teamway.service;

import org.springframework.beans.factory.annotation.Autowired;
import shenzhen.teamway.mapper.FacedelectMapper;
import shenzhen.teamway.model.Facedelect;
import shenzhen.teamway.model.ResultInfo;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-25 15:59
 **/
public interface ResultInfoService {

    int insertFace(Facedelect facedelect);

    int getId();

    int getCountById(int id);

    int updateResult(Facedelect facedelect);
}