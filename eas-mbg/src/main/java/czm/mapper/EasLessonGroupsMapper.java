package czm.mapper;

import java.util.List;

import czm.model.EasLessonGroups;
import czm.model.EasLessonGroupsExample;
import org.apache.ibatis.annotations.Param;

public interface EasLessonGroupsMapper {
    long countByExample(EasLessonGroupsExample example);

    int deleteByExample(EasLessonGroupsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EasLessonGroups record);

    int insertSelective(EasLessonGroups record);

    List<EasLessonGroups> selectByExample(EasLessonGroupsExample example);

    EasLessonGroups selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EasLessonGroups record, @Param("example") EasLessonGroupsExample example);

    int updateByExample(@Param("record") EasLessonGroups record, @Param("example") EasLessonGroupsExample example);

    int updateByPrimaryKeySelective(EasLessonGroups record);

    int updateByPrimaryKey(EasLessonGroups record);
}