package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.Repair;
import com.lchnan7.modules.utils.Result;

/**
 * 报修
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
public interface RepairService extends IService<Repair>{

    /**
     *  获取所有报修接口
     * @param pageNum
     * @param pageSize
     * @param repair
     * @return
     */
    Result selectRepairList(Repair repair, Integer pageNum, Integer pageSize);


    /**
     *  获取单个报修接口
     * @param id
     * @return
     */
    Result selectRepairInfo(Integer id);

    /**
     * 保存报修接口
     * @param repair
     * @return
     */
    Result saveRepairInfo(Repair repair);

    /**
     * 更新报修接口
     * @param repair
     * @return
     */
    Result updateRepairInfo(Repair repair);

    /**
     * 根据id删除报修接口
     * @param id
     * @return
     */
    Result delRepairInfo(Integer id);

    /**
     * 根据id集合批量删除报修接口
     * @param idList
     * @return
     */
    Result delBatchRepairInfo(String idList);




}