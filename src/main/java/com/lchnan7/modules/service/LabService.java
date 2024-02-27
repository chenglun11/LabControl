package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.Lab;
import com.lchnan7.modules.utils.Result;

/**
 * 实验室
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
public interface LabService extends IService<Lab>{

    /**
     *  获取所有实验室接口
     * @param pageNum
     * @param pageSize
     * @param lab
     * @return
     */
    Result selectLabList(Lab lab, Integer pageNum, Integer pageSize);


    /**
     *  获取单个实验室接口
     * @param id
     * @return
     */
    Result selectLabInfo(Integer id);

    /**
     * 保存实验室接口
     * @param lab
     * @return
     */
    Result saveLabInfo(Lab lab);

    /**
     * 更新实验室接口
     * @param lab
     * @return
     */
    Result updateLabInfo(Lab lab);

    /**
     * 根据id删除实验室接口
     * @param id
     * @return
     */
    Result delLabInfo(Integer id);

    /**
     * 根据id集合批量删除实验室接口
     * @param idList
     * @return
     */
    Result delBatchLabInfo(String idList);




}