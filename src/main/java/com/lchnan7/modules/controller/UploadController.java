package com.lchnan7.modules.controller;

import com.lchnan7.modules.utils.IpUtils;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.TimeUtil;
import com.lchnan7.modules.utils.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/common/file")
@Slf4j
public class UploadController {



    @Value("${file.path}")
    private String filePath;
    /**
     * 批量上传图片
     *
     * @return
     */
    @PostMapping("/batchUploadFile")
    @ApiOperation(value="批量图片base64上传")
    public Result uploadImgBase64(@RequestBody MultipartFile[] fileList) {
        List<String> fileNameList = new ArrayList<>();
        try {
            String fileName = "";
            if (fileList.length == 0){
                return ResultUtil.error(-1,"请选择文件");
            }
            for (MultipartFile file:fileList){
                if (!file.isEmpty()){
                    File newFile = new File(filePath);
                    if (!newFile.exists()) {
                        newFile.mkdirs();
                    }
                    // 获取原始文件名
                    String originalFilename = file.getOriginalFilename();
                    // 获取文件扩展名
//                    String fileExt = originalFilename.substring(originalFilename.lastIndexOf("."));
                    // 生成新的文件名
                    fileName = TimeUtil.dateRandom18()+"_"+originalFilename;
                    File imageFile = new File(newFile,fileName);
                    BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(imageFile));
                    out.write(file.getBytes());
                    out.flush();
                    out.close();
                    fileNameList.add(fileName);
                }
            }
            return ResultUtil.success(1,"上传成功",fileNameList);
        }catch (Exception e){
            e.printStackTrace();
            e.printStackTrace();
//            return Result.success(CodeMsg.SERVER_ERROR);
            return ResultUtil.error(-1,"服务异常");
        }

    }

    @PostMapping("//singleUploadFile")
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


}
