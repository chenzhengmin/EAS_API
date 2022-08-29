package czm.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import czm.CommonPage;
import czm.CommonResult;
import czm.dto.EasLessonGroupsParam;
import czm.dto.QueryVo;
import czm.model.EasAuthUsers;
import czm.model.EasLessonGroups;
import czm.service.EasLessonGroupsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "EasLessonGroupsController",description = "排课系统-班级管理页面接口")
@RequestMapping("/lesson")
public class EasLessonGroupsController {

    @Autowired
    EasLessonGroupsService easLessonGroupsService;

    @ApiOperation("添加")
    @PostMapping("/add")
    public CommonResult add(@RequestBody EasLessonGroups easLessonGroups) {

        Integer rows = easLessonGroupsService.add(easLessonGroups);
        if (rows > 0) return CommonResult.success("添加成功!");
        else return CommonResult.failed();

    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("id") Integer id) {

        Integer rows = easLessonGroupsService.delete(id);
        if (rows > 0) return CommonResult.success("删除成功!");
        else return CommonResult.failed();
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public CommonResult update(@RequestBody EasLessonGroupsParam easLessonGroupsParam) {

        Integer rows = easLessonGroupsService.update(easLessonGroupsParam);
        if (rows > 0) return CommonResult.success("更新成功!");
        else return CommonResult.failed();
    }

    @ApiOperation("获取")
    @PostMapping("/get")
    public CommonResult get(@RequestParam("id") Integer id) {

        EasLessonGroups easLessonGroups = easLessonGroupsService.get(id);
        return CommonResult.success(easLessonGroups);
    }

    @ApiOperation("根据teacherId获取班主任列表")
    @PostMapping("/select")
    public CommonResult select(@RequestParam("teacherId") Integer teacherId) {

        List<EasAuthUsers> easAuthUsersList = easLessonGroupsService.select(teacherId);
        return CommonResult.success(easAuthUsersList);
    }

    @ApiOperation("分页查询获取列表数据")
    @PostMapping("/page")
    public CommonResult pagelist(@RequestBody QueryVo queryvo) {

        CommonPage<EasLessonGroups> easLessonGroupsCommonPage= easLessonGroupsService.pagelist(queryvo);
        return CommonResult.success(easLessonGroupsCommonPage);
    }
}
