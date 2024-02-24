package com.lchnan7.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lchnan7.modules.entity.Archives;
import com.lchnan7.modules.entity.Collect;
import com.lchnan7.modules.entity.Comment;
import com.lchnan7.modules.entity.Like;
import com.lchnan7.modules.mapper.ArchivesMapper;
import com.lchnan7.modules.mapper.CollectMapper;
import com.lchnan7.modules.mapper.CommentMapper;
import com.lchnan7.modules.mapper.LikeMapper;
import com.lchnan7.modules.service.ArchivesService;
import com.lchnan7.modules.utils.IpUtils;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.TimeUtil;
import com.lchnan7.modules.entity.*;
import com.lchnan7.modules.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * 攻略
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@Service
public class ArchivesServiceImpl extends ServiceImpl<ArchivesMapper, Archives> implements ArchivesService {

    @Autowired
    private ArchivesMapper archivesMapper;



    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private HttpServletRequest request;
    /**
     *  获取所有攻略接口实现类
     * @param pageNum
     * @param pageSize
     * @param archives
     * @return
     */
    @Override
    public Result selectArchivesList(Archives archives, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Archives> data = archivesMapper.selectListInfo(archives);
        for (Archives archives1 :data){
            if (archives.getLoginUserId() !=null){
                QueryWrapper<Like> wrapper = new QueryWrapper<>();
                wrapper.eq("user_id", archives.getLoginUserId()).eq("archives_id", archives1.getId());
                Like like = likeMapper.selectOne(wrapper);
                archives1.setIsLike(like !=null);

                QueryWrapper<Collect> wrapper2 = new QueryWrapper<>();
                wrapper2.eq("user_id", archives.getLoginUserId()).eq("archives_id", archives1.getId());
                Collect collect = collectMapper.selectOne(wrapper2);
                archives1.setIsCollect(collect !=null);

            }
            QueryWrapper<Like> wrapper = new QueryWrapper<>();
            wrapper.eq("archives_id", archives1.getId());
            Integer likeCount = likeMapper.selectCount(wrapper);
            archives1.setLikeCount(likeCount==null?0:likeCount);

            QueryWrapper<Comment> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("archives_id", archives1.getId());
            Integer commentCount = commentMapper.selectCount(wrapper1);
            archives1.setCommentCount(commentCount);

            QueryWrapper<Collect> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("archives_id", archives1.getId());
            Integer collectCount = collectMapper.selectCount(wrapper2);
            archives1.setCollectCount(collectCount);


        }

        //Collections类的sort方法对对象集合排序，要传集合和Comparator接口两个参数
        data.sort(new Comparator<Archives>() {
            @Override
            public int compare(Archives o1, Archives o2) {
                Integer sex1 = o1.getLikeCount();
                Integer sex2 = o2.getLikeCount();
                return sex2.compareTo(sex1);
            }
        });
       return ResultUtil.successForDataAndImage(1,"成功",new PageInfo<>(data), IpUtils.getBaseUrl(request));
    }


    /**
     * 获取单个攻略接口实现类
     * @param id
     * @return
     */
    @Override
    public Result selectArchivesInfo(Integer id) {
        Archives archives = archivesMapper.selectById(id);
        return ResultUtil.success(1,"成功", archives);
    }


    /**
     * 保存攻略接口实现类
     * @param archives
     * @return
     */
    @Override
    @Transactional
    public Result saveArchivesInfo(Archives archives) {
        archives.setCreateTime(TimeUtil.getCurrentTime());
        archives.setUpdateTime(TimeUtil.getCurrentTime());
        archives.setReadCount(0);
        archives.setScore(0.0);
        archivesMapper.insert(archives);

        return ResultUtil.success(1,"成功",null);
}

    /**
     * 更新攻略接口实现类
     * @param archives
     * @return
     */
    @Override
    @Transactional
    public Result updateArchivesInfo(Archives archives) {
        archives.setUpdateTime(TimeUtil.getCurrentTime());
        archivesMapper.updateById(archives);
        return ResultUtil.success(1,"成功",null);
    }


    /**
     * 根据id删除攻略删除接口实现类
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Result delArchivesInfo(Integer id) {
        archivesMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id集合批量删除攻略接口实现类
     * @param idList
     * @return
     */
    @Override
    public Result delBatchArchivesInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        archivesMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }

    @Override
    public Result updateArchivesReadCount(Archives archives) {
        Archives archives1 = archivesMapper.selectById(archives.getId());
        archives1.setReadCount(archives1.getReadCount() + 1);
        archivesMapper.updateById(archives1);
        return ResultUtil.success(1,"正常",null);
    }

    @Override
    public Result updateArchivesScoreInfo(Archives archives) {
        Archives archives1 = archivesMapper.selectById(archives.getId());
        if (archives1.getScore() == 0){
            archives1.setScore((archives1.getScore() + archives.getScore()));
        }else {
            archives1.setScore((archives1.getScore() + archives.getScore())/2);
        }
        archivesMapper.updateById(archives1);
        return ResultUtil.success(1,"正常",null);
    }


}