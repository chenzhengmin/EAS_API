package czm.mapper;

import java.util.List;

import czm.model.EasAuthUsers;
import czm.model.EasAuthUsersExample;
import org.apache.ibatis.annotations.Param;

public interface EasAuthUsersMapper {
    long countByExample(EasAuthUsersExample example);

    int deleteByExample(EasAuthUsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EasAuthUsers record);

    int insertSelective(EasAuthUsers record);

    List<EasAuthUsers> selectByExample(EasAuthUsersExample example);

    EasAuthUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EasAuthUsers record, @Param("example") EasAuthUsersExample example);

    int updateByExample(@Param("record") EasAuthUsers record, @Param("example") EasAuthUsersExample example);

    int updateByPrimaryKeySelective(EasAuthUsers record);

    int updateByPrimaryKey(EasAuthUsers record);
}