package com.lchnan7.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lchnan7.modules.entity.Collect;
import com.lchnan7.modules.mapper.CollectMapper;
import com.lchnan7.modules.service.CollectService;
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
 * 收藏
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;



    /**
     *  获取所有收藏接口实现类
     * @param pageNum
     * @param pageSize
     * @param collect
     * @return
     */
    @Override
    public Result selectCollectList(Collect collect, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Collect> data = collectMapper.selectListInfo(collect);
       return ResultUtil.success(1,"成功",new PageInfo<>(data));
    }


    /**
     * 获取单个收藏接口实现类
     * @param id
     * @return
     */
    @Override
    public Result selectCollectInfo(Integer id) {
        Collect collect = collectMapper.selectById(id);
        return ResultUtil.success(1,"成功",collect);
    }

    /**
     * 保存收藏接口实现类
     * @param collect
     * @return
     */
    @Override
    public Result saveCollectInfo(Collect collect) {
        QueryWrapper<Collect> collectQueryWrapper = new QueryWrapper<>();
        collectQueryWrapper.eq("user_id",collect.getUserId()).eq("archives_id",collect.getArchivesId());
        Collect collectInfo = collectMapper.selectOne(collectQueryWrapper);
        if (collectInfo == null){
            //说明未曾收藏
         collect.setCreateTime(TimeUtil.getCurrentTime());
         collect.setUpdateTime(TimeUtil.getCurrentTime());
         collectMapper.insert(collect);
         return ResultUtil.success(1,"收藏成功",null);
        }else{
         collectMapper.delete(collectQueryWrapper);
         return ResultUtil.success(1,"取消收藏成功",null);
        }
}

    /**
     * 更新收藏接口实现类
     * @param collect
     * @return
     */
    @Override
    public Result updateCollectInfo(Collect collect) {
        collect.setUpdateTime(TimeUtil.getCurrentTime());
        collectMapper.updateById(collect);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id删除收藏删除接口实现类
     * @param id
     * @return
     */
    @Override
    public Result delCollectInfo(Integer id) {
        collectMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id集合批量删除收藏接口实现类
     * @param idList
     * @return
     */
    @Override
    public Result delBatchCollectInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        collectMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }



}