package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.entity.Appoint;

/**
 * 预约
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
public interface AppointService extends IService<Appoint>{

    /**
     *  获取所有预约接口
     * @param pageNum
     * @param pageSize
     * @param appoint
     * @return
     */
    Result selectAppointList(Appoint appoint, Integer pageNum, Integer pageSize);


    /**
     *  获取单个预约接口
     * @param id
     * @return
     */
    Result selectAppointInfo(Integer id);

    /**
     * 保存预约接口
     * @param appoint
     * @return
     */
    Result saveAppointInfo(Appoint appoint);

    /**
     * 更新预约接口
     * @param appoint
     * @return
     */
    Result updateAppointInfo(Appoint appoint);

    /**
     * 根据id删除预约接口
     * @param id
     * @return
     */
    Result delAppointInfo(Integer id);

    /**
     * 根据id集合批量删除预约接口
     * @param idList
     * @return
     */
    Result delBatchAppointInfo(String idList);


    Result selectAll();
}