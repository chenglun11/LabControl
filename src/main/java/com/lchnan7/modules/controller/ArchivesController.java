package com.lchnan7.modules.controller;;
import com.lchnan7.modules.service.ArchivesService;
import com.lchnan7.modules.entity.Archives;
import com.lchnan7.modules.utils.TimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.*;

/**
 * 攻略
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@RestController
@RequestMapping("/common/archives")
@Api(tags="攻略")
public class ArchivesController {
    @Autowired
    private ArchivesService archivesService;

    /**
    *  获取所有攻略
    * @param pageNum
    * @param pageSize
    * @param archives
    * @return
    */

    @GetMapping("/getArchivesList")
    @ApiOperation("获取所有攻略")
    public Result getArchivesList(Archives archives, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                  @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return archivesService.selectArchivesList(archives,pageNum,pageSize);
    }


    @GetMapping("/getArchivesInfo")
    @ApiOperation("根据id获取单个攻略")
    public Result getArchivesInfo(Integer id){
        return archivesService.selectArchivesInfo(id);
    }

    /**
    * 保存攻略
    * @param archives
    * @return
    */
    @PostMapping("/saveArchivesInfo")
    @ApiOperation("保存攻略")
    public Result saveArchivesInfo(@RequestBody Archives archives){
        return archivesService.saveArchivesInfo(archives);
    }


    /**
     * 更新攻略
     * @param archives
     * @return
     */

    @PutMapping("/updateArchivesInfo")
    @ApiOperation("更新攻略")
    public Result updateArchivesInfo(@RequestBody Archives archives){
        return archivesService.updateArchivesInfo(archives);
    }


    @PutMapping("/updateArchivesScoreInfo")
    @ApiOperation("更新分数")
    public Result updateArchivesScoreInfo(@RequestBody Archives archives){
        return archivesService.updateArchivesScoreInfo(archives);
    }

    @PutMapping("/updateArchivesReadCount")
    @ApiOperation("更新攻略")
    public Result updateArchivesReadCount(@RequestBody Archives archives){
        return archivesService.updateArchivesReadCount(archives);
    }



    /**
     * 根据id删除攻略
     * @param id
     * @return
     */
    @DeleteMapping("/delArchivesInfo")
    @ApiOperation("根据id删除攻略")
    public Result delArchivesInfo(Integer id){
        return archivesService.delArchivesInfo(id);
    }

    /**
     * 根据id集合批量删除攻略
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchArchivesInfo")
    @ApiOperation("根据id集合批量删除攻略")
    public Result delBatchArchivesInfo(String idList){
        return archivesService.delBatchArchivesInfo(idList);
    }








    @PostMapping("/createArchivesData")
    public Result createArchivesData(){

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
            Archives archives = new Archives();
            archives.setCreateTime(TimeUtil.getCurrentTime());
            archives.setUpdateTime(TimeUtil.getCurrentTime());
            archives.setTitle("攻略标题"+i);

            archives.setSummary("攻略简介"+i);

            archives.setSortId(i);

            archives.setContent("详细内容"+i);

            archives.setAddress("所在城市"+i);

            archives.setIsBanner(1);

            archives.setImageUrl( imageList.get(i-1) );

            archives.setUserId(i);


            archivesService.saveArchivesInfo(archives);
        }
        return ResultUtil.success(1,"生成成功",null);
    }


}