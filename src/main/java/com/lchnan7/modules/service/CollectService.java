package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.Collect;
import com.lchnan7.modules.utils.Result;

/**
 * 收藏
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
public interface CollectService extends IService<Collect>{

    /**
     *  获取所有收藏接口
     * @param pageNum
     * @param pageSize
     * @param collect
     * @return
     */
    Result selectCollectList(Collect collect, Integer pageNum, Integer pageSize);


    /**
     *  获取单个收藏接口
     * @param id
     * @return
     */
    Result selectCollectInfo(Integer id);

    /**
     * 保存收藏接口
     * @param collect
     * @return
     */
    Result saveCollectInfo(Collect collect);

    /**
     * 更新收藏接口
     * @param collect
     * @return
     */
    Result updateCollectInfo(Collect collect);

    /**
     * 根据id删除收藏接口
     * @param id
     * @return
     */
    Result delCollectInfo(Integer id);

    /**
     * 根据id集合批量删除收藏接口
     * @param idList
     * @return
     */
    Result delBatchCollectInfo(String idList);




}