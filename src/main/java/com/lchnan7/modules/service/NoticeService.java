package com.lchnan7.modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.Notice;
import com.lchnan7.modules.utils.Result;

public interface NoticeService extends IService<Notice> {

    /**
     *  获取所有攻略接口
     * @param pageNum
     * @param pageSize
     * @param notice
     * @return
     */
    Result selectNoticeList(Notice notice, Integer pageNum, Integer pageSize);


    /**
     *  获取单个攻略接口
     * @param id
     * @return
     */
    Result selectNoticeInfo(Integer id);

    /**
     * 保存攻略接口
     * @param notice
     * @return
     */
    Result saveNoticeInfo(Notice notice);

    /**
     * 更新攻略接口
     * @param notice
     * @return
     */
    Result updateNoticeInfo(Notice notice);

    /**
     * 根据id删除攻略接口
     * @param id
     * @return
     */
    Result delNoticeInfo(Integer id);

    /**
     * 根据id集合批量删除攻略接口
     * @param idList
     * @return
     */
    Result delBatchNoticeInfo(String idList);
}
