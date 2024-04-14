package com.lchnan7.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lchnan7.modules.entity.Lab;
import com.lchnan7.modules.mapper.AppointMapper;
import com.lchnan7.modules.mapper.LabMapper;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.service.LabService;
import com.lchnan7.modules.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.*;

import com.lchnan7.modules.utils.TimeUtil;
/**
 * 实验室
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
@Service
public class LabServiceImpl extends ServiceImpl<LabMapper, Lab> implements LabService {

    @Autowired
    private LabMapper labMapper;

    @Autowired
    private AppointMapper appointMapper;


    /**
     *  获取所有实验室接口实现类
     * @param pageNum
     * @param pageSize
     * @param lab
     * @return
     */
    @Override
    public Result selectLabList(Lab lab, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Lab> data = labMapper.selectListInfo(lab);
       return ResultUtil.success(1,"成功",new PageInfo<>(data));
    }


    /**
     * 获取单个实验室接口实现类
     * @param id
     * @return
     */
    @Override
    public Result selectLabInfo(Integer id) {
        Lab lab = labMapper.selectById(id);
        return ResultUtil.success(1,"成功",lab);
    }

    /**
     * 保存实验室接口实现类
     * @param lab
     * @return
     */
    @Override
    public Result saveLabInfo(Lab lab) {
        lab.setStatus(1);
        QueryWrapper<Lab> labNameWrapper = new QueryWrapper<>();
        labNameWrapper.eq("lab_name",lab.getLabName());
        Lab labNameInfo = labMapper.selectOne(labNameWrapper);
        if (labNameInfo != null){
            return ResultUtil.error(-1,"实验室名重复");
        }
        lab.setCreateTime(TimeUtil.getCurrentTime());
        lab.setUpdateTime(TimeUtil.getCurrentTime());
        labMapper.insert(lab);
        return ResultUtil.success(1,"成功",null);
}

    /**
     * 更新实验室接口实现类
     * @param lab
     * @return
     */
    @Override
    public Result updateLabInfo(Lab lab) {
        QueryWrapper<Lab> labNameWrapper = new QueryWrapper<>();
        labNameWrapper.eq("lab_name",lab.getLabName()).ne("id",lab.getId());
        Lab labNameInfo = labMapper.selectOne(labNameWrapper);
        if (labNameInfo != null){
            return ResultUtil.error(-1,"实验室名重复");
        }
        lab.setUpdateTime(TimeUtil.getCurrentTime());
        labMapper.updateById(lab);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id删除实验室删除接口实现类
     * @param id
     * @return
     */
    @Override
    public Result delLabInfo(Integer id) {
        labMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id集合批量删除实验室接口实现类
     * @param idList
     * @return
     */
    @Override
    public Result delBatchLabInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        labMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }

}