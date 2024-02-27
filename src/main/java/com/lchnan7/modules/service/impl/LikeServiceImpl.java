package com.lchnan7.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lchnan7.modules.entity.Like;
import com.lchnan7.modules.mapper.LikeMapper;
import com.lchnan7.modules.service.LikeService;
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
 * 点赞
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-01-05
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {

    @Autowired
    private LikeMapper likeMapper;



    /**
     *  获取所有点赞接口实现类
     * @param pageNum
     * @param pageSize
     * @param like
     * @return
     */
    @Override
    public Result selectLikeList(Like like, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Like> data = likeMapper.selectListInfo(like);
       return ResultUtil.success(1,"成功",new PageInfo<>(data));
    }


    /**
     * 获取单个点赞接口实现类
     * @param id
     * @return
     */
    @Override
    public Result selectLikeInfo(Integer id) {
        Like like = likeMapper.selectById(id);
        return ResultUtil.success(1,"成功",like);
    }

    /**
     * 保存点赞接口实现类
     * @param like
     * @return
     */
    @Override
    public Result saveLikeInfo(Like like) {
        QueryWrapper<Like> likeQueryWrapper = new QueryWrapper<>();
        likeQueryWrapper.eq("user_id",like.getUserId()).eq("archives_id",like.getArchivesId());
        Like likeInfo = likeMapper.selectOne(likeQueryWrapper);
        if (likeInfo == null){
           //说明未曾点赞
        like.setCreateTime(TimeUtil.getCurrentTime());
        like.setUpdateTime(TimeUtil.getCurrentTime());
        likeMapper.insert(like);
        return ResultUtil.success(1,"点赞成功",null);
        }else{
            likeMapper.delete(likeQueryWrapper);
            return ResultUtil.success(1,"取消点赞成功",null);
        }
}

    /**
     * 更新点赞接口实现类
     * @param like
     * @return
     */
    @Override
    public Result updateLikeInfo(Like like) {
        like.setUpdateTime(TimeUtil.getCurrentTime());
        likeMapper.updateById(like);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id删除点赞删除接口实现类
     * @param id
     * @return
     */
    @Override
    public Result delLikeInfo(Integer id) {
        likeMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id集合批量删除点赞接口实现类
     * @param idList
     * @return
     */
    @Override
    public Result delBatchLikeInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        likeMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }



}