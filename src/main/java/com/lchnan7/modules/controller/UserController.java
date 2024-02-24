package com.lchnan7.modules.controller;;
import com.lchnan7.modules.service.UserService;
import com.lchnan7.modules.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-11-30
 */
@RestController
@RequestMapping("/common/user")
@Api(tags="用户")
public class UserController {
    @Autowired
    private UserService userService;

    /**
    *  获取所有用户
    * @param pageNum
    * @param pageSize
    * @param user
    * @return
    */

    @GetMapping("/getUserList")
    @ApiOperation("获取所有用户")
    public Result getUserList(User user, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return userService.selectUserList(user,pageNum,pageSize);
    }


    @GetMapping("/getUserInfo")
    @ApiOperation("根据id获取单个用户")
    public Result getUserInfo(Integer id){
        return userService.selectUserInfo(id);
    }

    /**
    * 保存用户
    * @param user
    * @return
    */
    @PostMapping("/saveUserInfo")
    @ApiOperation("保存用户")
    public Result saveUserInfo(@RequestBody User user){
        return userService.saveUserInfo(user);
    }


    /**
     * 更新用户
     * @param user
     * @return
     */

    @PutMapping("/updateUserInfo")
    @ApiOperation("更新用户")
    public Result updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delUserInfo")
    @ApiOperation("根据id删除用户")
    public Result delUserInfo(Integer id){
        return userService.delUserInfo(id);
    }

    /**
     * 根据id集合批量删除用户
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchUserInfo")
    @ApiOperation("根据id集合批量删除用户")
    public Result delBatchUserInfo(String idList){
        return userService.delBatchUserInfo(idList);
    }

    /**
     * 登录接口(根据用户名和密码)
     * @return
     */

    @PostMapping("/login")
    @ApiOperation("用户登录接口")
    public Result login(User user){
        return userService.login(user);
    }



    /**
    *
    * @param user
    * @return
     */
    @PostMapping("/updatePassword")
    @ApiOperation("用户更新密码接口")
    public Result updatePassword(@RequestBody User user){
       return userService.updatePassword(user);
    }








}