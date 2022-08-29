package czm.service.impl;

import com.github.pagehelper.PageHelper;
import czm.CommonPage;
import czm.dto.EasLessonGroupsParam;
import czm.dto.QueryVo;
import czm.mapper.EasAuthUsersMapper;
import czm.mapper.EasLessonGroupsMapper;
import czm.model.EasAuthUsers;
import czm.model.EasAuthUsersExample;
import czm.model.EasLessonGroups;
import czm.model.EasLessonGroupsExample;
import czm.service.EasLessonGroupsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class EasLessonGroupsServiceImpl implements EasLessonGroupsService {

    @Autowired
    EasLessonGroupsMapper easLessonGroupsMapper;
    @Autowired
    EasAuthUsersMapper easAuthUsersMapper;
    @Override
    public Integer add(EasLessonGroups easLessonGroups) {

        easLessonGroups.setUpdateAt(new Date());
        easLessonGroups.setCreateAt(new Date());

        return easLessonGroupsMapper.insertSelective(easLessonGroups);
    }

    @Override
    public Integer delete(Integer id) {
        return easLessonGroupsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(EasLessonGroupsParam easLessonGroupsParam) {
        EasLessonGroups easLessonGroups = new EasLessonGroups();
        BeanUtils.copyProperties(easLessonGroupsParam, easLessonGroups);//easLessonGroupsParam拷贝到easLessonGroups
        easLessonGroups.setUpdateAt(new Date());
        return easLessonGroupsMapper.updateByPrimaryKeySelective(easLessonGroups);
    }

    @Override
    public EasLessonGroups get(Integer id) {
        return easLessonGroupsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<EasAuthUsers> select(Integer teacherId) {

        EasAuthUsersExample easAuthUsersExample = new EasAuthUsersExample();
        if (null != teacherId && !teacherId.equals("")){
            easAuthUsersExample.createCriteria().andIdEqualTo(teacherId);
        }
        return easAuthUsersMapper.selectByExample(easAuthUsersExample);
    }

    @Override
    public CommonPage<EasLessonGroups> pagelist(QueryVo queryvo) {

        CommonPage<EasLessonGroups> commonPage = new CommonPage();
        EasLessonGroupsExample easLessonGroupsExample = new EasLessonGroupsExample();

        EasLessonGroupsExample.Criteria criteria = easLessonGroupsExample.createCriteria();

        if (null != queryvo){

            if (null != queryvo.getPageNum()){
                commonPage.setPageNum(queryvo.getPageNum());
            }

            if (queryvo.getTitle() != null && queryvo.getTitle() != ""){
                criteria.andTitleLike("%"+queryvo.getTitle()+"%");
            }

            if (!StringUtils.isEmpty(queryvo.getTeacherId())){
                criteria.andTeacherIdEqualTo(queryvo.getTeacherId());
            }

            commonPage.setTotal(easLessonGroupsMapper.countByExample(easLessonGroupsExample));

            commonPage.setTotalPage(queryvo.getTotalPage());

            commonPage.setPageSize(queryvo.getPageSize());

            PageHelper.startPage(commonPage.getPageNum(),commonPage.getPageSize());

            commonPage.setList(easLessonGroupsMapper.selectByExample(easLessonGroupsExample));
        }
        return CommonPage.restPage(commonPage.getList());
    }
}
