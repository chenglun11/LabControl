package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.User;
import com.lchnan7.modules.utils.Result;

/**
 * 用户
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2023-11-30
 */
public interface UserService extends IService<User>{

    /**
     *  获取所有用户接口
     * @param pageNum
     * @param pageSize
     * @param user
     * @return
     */
    Result selectUserList(User user, Integer pageNum, Integer pageSize);


    /**
     *  获取单个用户接口
     * @param id
     * @return
     */
    Result selectUserInfo(Integer id);

    /**
     * 保存用户接口
     * @param user
     * @return
     */
    Result saveUserInfo(User user);

    /**
     * 更新用户接口
     * @param user
     * @return
     */
    Result updateUserInfo(User user);

    /**
     * 根据id删除用户接口
     * @param id
     * @return
     */
    Result delUserInfo(Integer id);

    /**
     * 根据id集合批量删除用户接口
     * @param idList
     * @return
     */
    Result delBatchUserInfo(String idList);

    /**
    * 登录接口(根据用户名和密码)
    * @return
    */
    Result login(User user);

    /**
    * 更新密码接口
    * @param user
    * @return
    */
    Result updatePassword(User user);


    /**
     * 更新密码接口
     * @param user
     * @return
     */

}