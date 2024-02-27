package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.entity.Like;

/**
 * 点赞
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-01-05
 */
public interface LikeService extends IService<Like>{

    /**
     *  获取所有点赞接口
     * @param pageNum
     * @param pageSize
     * @param like
     * @return
     */
    Result selectLikeList(Like like, Integer pageNum, Integer pageSize);


    /**
     *  获取单个点赞接口
     * @param id
     * @return
     */
    Result selectLikeInfo(Integer id);

    /**
     * 保存点赞接口
     * @param like
     * @return
     */
    Result saveLikeInfo(Like like);

    /**
     * 更新点赞接口
     * @param like
     * @return
     */
    Result updateLikeInfo(Like like);

    /**
     * 根据id删除点赞接口
     * @param id
     * @return
     */
    Result delLikeInfo(Integer id);

    /**
     * 根据id集合批量删除点赞接口
     * @param idList
     * @return
     */
    Result delBatchLikeInfo(String idList);




}