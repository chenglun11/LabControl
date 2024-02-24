package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.Archives;
import com.lchnan7.modules.utils.Result;

/**
 * 攻略
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
public interface ArchivesService extends IService<Archives>{

    /**
     *  获取所有攻略接口
     * @param pageNum
     * @param pageSize
     * @param archives
     * @return
     */
    Result selectArchivesList(Archives archives, Integer pageNum, Integer pageSize);


    /**
     *  获取单个攻略接口
     * @param id
     * @return
     */
    Result selectArchivesInfo(Integer id);

    /**
     * 保存攻略接口
     * @param archives
     * @return
     */
    Result saveArchivesInfo(Archives archives);

    /**
     * 更新攻略接口
     * @param archives
     * @return
     */
    Result updateArchivesInfo(Archives archives);

    /**
     * 根据id删除攻略接口
     * @param id
     * @return
     */
    Result delArchivesInfo(Integer id);

    /**
     * 根据id集合批量删除攻略接口
     * @param idList
     * @return
     */
    Result delBatchArchivesInfo(String idList);


    Result updateArchivesReadCount(Archives archives);

    Result updateArchivesScoreInfo(Archives archives);
}