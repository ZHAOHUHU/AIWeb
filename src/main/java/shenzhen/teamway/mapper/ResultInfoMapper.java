package shenzhen.teamway.mapper;

import java.util.List;

import shenzhen.teamway.model.ResultInfo;

public interface ResultInfoMapper {
    int deleteByPrimaryKey(Integer resultId);

    int insert(ResultInfo record);

    ResultInfo selectByPrimaryKey(Integer resultId);

    List<ResultInfo> selectAll();

    int updateByPrimaryKey(ResultInfo record);

    int selectId();
}