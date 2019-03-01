package shenzhen.teamway.mapper;

import java.util.List;

import shenzhen.teamway.model.Facedelect;

public interface FacedelectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Facedelect record);

    Facedelect selectByPrimaryKey(Integer id);

    List<Facedelect> selectAll();

    int updateByPrimaryKey(Facedelect record);

    int selectId();

    int selectById(Integer id);

    int updataResult(Facedelect result);
}