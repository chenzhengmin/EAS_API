package czm.service;

import czm.CommonPage;
import czm.dto.EasLessonGroupsParam;
import czm.dto.QueryVo;
import czm.model.EasAuthUsers;
import czm.model.EasLessonGroups;

import java.util.List;

public interface EasLessonGroupsService {
    Integer add(EasLessonGroups easLessonGroups);

    Integer delete(Integer id);

    Integer update(EasLessonGroupsParam easLessonGroupsParam);

    EasLessonGroups get(Integer id);

    List<EasAuthUsers> select(Integer teacherId);

    CommonPage<EasLessonGroups> pagelist(QueryVo queryvo);
}
