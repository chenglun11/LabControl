package com.lchnan7.modules.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lchnan7.modules.entity.Lab;
import com.lchnan7.modules.entity.Repair;
import com.lchnan7.modules.mapper.LabMapper;
import com.lchnan7.modules.mapper.RepairMapper;
import com.lchnan7.modules.service.DingSyncService;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.TimeUtil;
import com.lchnan7.modules.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Arrays;

/**
 * 报修
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {

    @Autowired
    private RepairMapper repairMapper;



    /**
     *  获取所有报修接口实现类
     * @param pageNum
     * @param pageSize
     * @param repair
     * @return
     */
    @Override
    public Result selectRepairList(Repair repair, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Repair> data = repairMapper.selectListInfo(repair);
       return ResultUtil.success(1,"成功",new PageInfo<>(data));
    }


    /**
     * 获取单个报修接口实现类
     * @param id
     * @return
     */
    @Override
    public Result selectRepairInfo(Integer id) {
        Repair repair = repairMapper.selectById(id);
        return ResultUtil.success(1,"成功",repair);
    }

    /**
     * 保存报修接口实现类
     * @param repair
     * @return
     */
    @Autowired
    private LabMapper labMapper;
    @Autowired
    private DingSyncService dingSyncService;

    @Override
    public Result saveRepairInfo(Repair repair) {
        repair.setCreateTime(TimeUtil.getCurrentTime());
        repair.setUpdateTime(TimeUtil.getCurrentTime());
        repairMapper.insert(repair);
        Lab lab = labMapper.selectById(repair.getLabId());
        dingSyncService.SendDingFix(lab.getLabName());
        return ResultUtil.success(1,"成功",null);
}

    /**
     * 更新报修接口实现类
     * @param repair
     * @return
     */
    @Override
    public Result updateRepairInfo(Repair repair) {
        repair.setUpdateTime(TimeUtil.getCurrentTime());
        repairMapper.updateById(repair);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id删除报修删除接口实现类
     * @param id
     * @return
     */
    @Override
    public Result delRepairInfo(Integer id) {
        repairMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id集合批量删除报修接口实现类
     * @param idList
     * @return
     */
    @Override
    public Result delBatchRepairInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        repairMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }



}