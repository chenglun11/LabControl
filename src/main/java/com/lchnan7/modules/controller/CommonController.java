package com.lchnan7.modules.controller;
import com.lchnan7.modules.utils.IpUtils;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PSW
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/common/file")
@Slf4j
public class CommonController {


    @Value("${file.path}")
    private String filePath;

    @PostMapping("/uploadFileInfo")
    public Result uploadImage(@RequestParam(name = "file",required = true) MultipartFile file, HttpServletRequest request) {
        String fileName = "";
        if (!file.isEmpty()) {
            try {
                //图片命名
//                fileName = file.getOriginalFilename();
                File newFile = new File(filePath);
                if (!newFile.exists()) {
                    newFile.mkdirs();
                }
                // 获取原始文件名
                String originalFilename = file.getOriginalFilename();
                // 获取文件扩展名
                String fileExt = originalFilename.substring(originalFilename.lastIndexOf("."));
                // 生成新的文件名
                fileName = TimeUtil.dateRandom18()+"_"+originalFilename;
                File imageFile = new File(newFile,fileName);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(imageFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return  ResultUtil.error(-1,"路径为空");
            } catch (IOException e) {
                e.printStackTrace();
                log.info("上传底图接口/uploadBaseImage出现异常,异常信息如下====>{}",e.getMessage());
                return  ResultUtil.error(-1,"上传文件异常");
            }
        }
//        return  ResultUtil.success(1,"图片上传成功！","文件名称"+fileName+"==="+"文件路径==>/search/compare/"+  fileName);

        return  ResultUtil.successForDataAndImage(1,"上传文件成功",fileName, IpUtils.getBaseUrl(request));
    }

    @PostMapping("/upload")
    public Result upCqltjtCustomer(@RequestParam("files") MultipartFile[] files,
                                   HttpServletRequest request) throws Exception {
//        ReslutData reslutData = new ReslutData();
        List<String> fileNameList = new ArrayList<>();
        for (MultipartFile file:files){
            String fileName = "";
            if (!file.isEmpty()) {
                try {
                    //图片命名
                    fileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll(".+\\.", System.currentTimeMillis()+".");
                    File newFile = new File(filePath);
                    if (!newFile.exists()) {
                        newFile.mkdirs();
                    }
                    File imageFile = new File(newFile,fileName);
                    BufferedOutputStream out = new BufferedOutputStream(
                            new FileOutputStream(imageFile));
                    out.write(file.getBytes());
                    out.flush();
                    out.close();
                    fileNameList.add(fileName);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.info("上传底图接口/uploadBaseImage出现异常,异常信息如下====>{}",e.getMessage());
                }
            }
        }
        //具体代码逻辑实现功能区，由读者完善吧。
        return ResultUtil.successForDataAndImage(1,"正常",fileNameList, IpUtils.getBaseUrl(request));
    }

    public static void main(String[] args) {
        String imgName = "1.jpg";
        imgName = imgName.replaceAll(".+\\.", System.currentTimeMillis()+".");
        System.out.println(imgName);
    }
}

