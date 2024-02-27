package com.lchnan7.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lchnan7.modules.entity.Sort;
import com.lchnan7.modules.mapper.SortMapper;
import com.lchnan7.modules.service.SortService;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Arrays;
import com.lchnan7.modules.utils.TimeUtil;
/**
 * 分类
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-01-05
 */
@Service
public class SortServiceImpl extends ServiceImpl<SortMapper, Sort> implements SortService {

    @Autowired
    private SortMapper sortMapper;



    /**
     *  获取所有分类接口实现类
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    @Override
    public Result selectSortList(Sort sort, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Sort> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        if (sort.getSortName() !=null){
            wrapper.like("sort_name",sort.getSortName());
        }
        List<Sort> data = sortMapper.selectList(wrapper);
        return ResultUtil.success(1,"成功",new PageInfo<>(data));
    }


    /**
     * 获取单个分类接口实现类
     * @param id
     * @return
     */
    @Override
    public Result selectSortInfo(Integer id) {
        Sort sort = sortMapper.selectById(id);
        return ResultUtil.success(1,"成功",sort);
    }

    /**
     * 保存分类接口实现类
     * @param sort
     * @return
     */
    @Override
    public Result saveSortInfo(Sort sort) {
        sort.setCreateTime(TimeUtil.getCurrentTime());
        sort.setUpdateTime(TimeUtil.getCurrentTime());
        sortMapper.insert(sort);
        return ResultUtil.success(1,"成功",null);
}

    /**
     * 更新分类接口实现类
     * @param sort
     * @return
     */
    @Override
    public Result updateSortInfo(Sort sort) {
        sort.setUpdateTime(TimeUtil.getCurrentTime());
        sortMapper.updateById(sort);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id删除分类删除接口实现类
     * @param id
     * @return
     */
    @Override
    public Result delSortInfo(Integer id) {
        sortMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id集合批量删除分类接口实现类
     * @param idList
     * @return
     */
    @Override
    public Result delBatchSortInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        sortMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }



}