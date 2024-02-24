package com.lchnan7.modules.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lchnan7.modules.entity.Archives;
import com.lchnan7.modules.entity.Collect;
import com.lchnan7.modules.entity.User;
import com.lchnan7.modules.mapper.ArchivesMapper;
import com.lchnan7.modules.mapper.CollectMapper;
import com.lchnan7.modules.mapper.UserMapper;
import com.lchnan7.modules.utils.RecommendUtils;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/common/recommend")
public class RecommendController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private ArchivesMapper archivesMapper;

    @GetMapping("/getRecommendList")
    public Result getRecommendList(@RequestParam(value = "userId",required = true) Integer userId) {
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("user_type",2);
            List<User> userList = userMapper.selectList(wrapper);
            List<Archives> data = archivesMapper.selectList(null);
            if (data == null || data.size() == 0){
                return ResultUtil.success(1,"未曾有档案",null);
            }
//        List<Archives> data = new ArrayList<>();
            int currentUserIdIndex = -1;
            double[][] userRatings = new double[userList.size()][];
            for (int i=0;i<userList.size();i++){
                if (userId.equals(userList.get(i).getId())){
                    currentUserIdIndex = i;
                }
                double[] userRating = new double[data.size()];
                for (int j=0;j<data.size();j++){
                    QueryWrapper<Collect> wrapper1 = new QueryWrapper<>();
                    wrapper1.eq("user_id",userList.get(i).getId()).eq("archives_id",data.get(j).getId());
                    Collect collect = collectMapper.selectOne(wrapper1);
                    if (collect == null){
                        userRating[j] = 0;
                    }else {
                        userRating[j] = 1;
                    }
                }
                userRatings[i] = userRating;
            }
            System.out.println("===");
            System.out.println(Arrays.deepToString(userRatings));
            System.out.println("====");

            List<Archives> recommendList = new ArrayList<>();
            //获取到下标
            List<Integer> list = RecommendUtils.recommendItems(currentUserIdIndex, userRatings, 3);
            for (Integer userIndex:list){
                recommendList.add(data.get(userIndex-1));
            }
            System.out.println(Arrays.deepToString(userRatings));
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("data",recommendList);
            jsonObject.set("data2",Arrays.deepToString(userRatings));

            return ResultUtil.success(1,"正常",jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(-1, "异常");
        }

    }
}