package com.lchnan7.modules.controller;;
import com.lchnan7.modules.service.LabService;
import com.lchnan7.modules.entity.Lab;
import com.lchnan7.modules.utils.TimeUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实验室
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
@RestController
@RequestMapping("/common/lab")
@Api(tags="实验室")
public class LabController {
    @Autowired
    private LabService labService;

    /**
    *  获取所有实验室
    * @param pageNum
    * @param pageSize
    * @param lab
    * @return
    */

    @GetMapping("/getLabList")
    @ApiOperation("获取所有实验室")
    public Result getLabList(Lab lab, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return labService.selectLabList(lab,pageNum,pageSize);
    }


    @GetMapping("/getLabInfo")
    @ApiOperation("根据id获取单个实验室")
    public Result getLabInfo(Integer id){
        return labService.selectLabInfo(id);
    }

    /**
    * 保存实验室
    * @param lab
    * @return
    */
    @PostMapping("/saveLabInfo")
    @ApiOperation("保存实验室")
    public Result saveLabInfo(@RequestBody Lab lab){
        return labService.saveLabInfo(lab);
    }


    /**
     * 更新实验室
     * @param lab
     * @return
     */

    @PutMapping("/updateLabInfo")
    @ApiOperation("更新实验室")
    public Result updateLabInfo(@RequestBody Lab lab){
        return labService.updateLabInfo(lab);
    }

    /**
     * 根据id删除实验室
     * @param id
     * @return
     */
    @DeleteMapping("/delLabInfo")
    @ApiOperation("根据id删除实验室")
    public Result delLabInfo(Integer id){
        return labService.delLabInfo(id);
    }

    /**
     * 根据id集合批量删除实验室
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchLabInfo")
    @ApiOperation("根据id集合批量删除实验室")
    public Result delBatchLabInfo(String idList){
        return labService.delBatchLabInfo(idList);
    }








    @PostMapping("/createLabData")
    public Result createLabData(){

        List<String> imageList = new ArrayList<>();
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-10-25//242357c9-08c4-4c4f-854d-67de9b271dbe_u=1996284881,1109846881&fm=253&fmt=auto&app=138&f=JPEG.webp");
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-10-30//0d09b8e2-e66d-4231-8d35-5c4552a48f2a_2dd8fe9b59774c7ca160bb2d5741c763.jpg");
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-11-02//d5f5276d-07bb-435c-8b83-6673fed5f22d_Snipaste_2023-03-13_19-49-26.png");
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2022-12-13//22400dd3-cc8e-4477-823b-b3fb698ef9d5_25.png");
        imageList.add("http://yjy-xiaotuxian-dev.oss-cn-beijing.aliyuncs.com/picture/2021-04-05/7f483771-6831-4a7a-abdb-2625acb755f3.png");
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-10-30//0d09b8e2-e66d-4231-8d35-5c4552a48f2a_2dd8fe9b59774c7ca160bb2d5741c763.jpg");
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-11-02//d5f5276d-07bb-435c-8b83-6673fed5f22d_Snipaste_2023-03-13_19-49-26.png");
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-10-25//5aeb86e4-5c96-433a-8180-2ef50443dd5c_d0176b163973961ed01818d04ee94a06 (1).png");
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-10-25//7f50ce5d-04ab-4db6-88a5-c721e0256256_7f6a7b20-7902-4b43-b9c5-f33151ef1334.jpg");
        imageList.add("https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2021-05-04//0bed6c30-d19f-4771-8fcd-7de722195643_2016121809101738-480x300.jpg");
        for (int i=1;i<11;i++) {
            Lab lab = new Lab();
            lab.setCreateTime(TimeUtil.getCurrentTime());
            lab.setUpdateTime(TimeUtil.getCurrentTime());
            lab.setLabName("实验室名"+i);

            lab.setSortId(i);

            lab.setLocation("位置"+i);

            lab.setDesc("简介"+i);

            lab.setContent("内容"+i);

            lab.setStatus(1);

            lab.setImageUrl( imageList.get(i-1) );

            lab.setIsBanner(1);

            labService.saveLabInfo(lab);
        }
        return ResultUtil.success(1,"生成成功",null);
    }


}