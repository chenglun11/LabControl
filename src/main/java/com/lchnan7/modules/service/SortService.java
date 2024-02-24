package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.Sort;
import com.lchnan7.modules.utils.Result;

/**
 * 分类
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
public interface SortService extends IService<Sort>{

    /**
     *  获取所有分类接口
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    Result selectSortList(Sort sort, Integer pageNum, Integer pageSize);


    /**
     *  获取单个分类接口
     * @param id
     * @return
     */
    Result selectSortInfo(Integer id);

    /**
     * 保存分类接口
     * @param sort
     * @return
     */
    Result saveSortInfo(Sort sort);

    /**
     * 更新分类接口
     * @param sort
     * @return
     */
    Result updateSortInfo(Sort sort);

    /**
     * 根据id删除分类接口
     * @param id
     * @return
     */
    Result delSortInfo(Integer id);

    /**
     * 根据id集合批量删除分类接口
     * @param idList
     * @return
     */
    Result delBatchSortInfo(String idList);




}