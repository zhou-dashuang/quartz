package com.example.demoquartz2.quartz2;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface QuartzService{
    /**
     * 新增一个定时任务
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param tName 触发器名称
     * @param tGroup 触发器组
     * @param cron cron表达式
     */
    void addJob(String jName, String jGroup, String tName, String tGroup, String cron,String className);

    /**
     * 暂停定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void pauseJob(String jName, String jGroup);

    /**
     * 继续定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void resumeJob(String jName, String jGroup);

    /**
     * 删除定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void deleteJob(String jName, String jGroup);


    /**
     * 获取所有正在运行的job
     *
     * @return
     */
    List<Map<String, Object>>  queryRunJob();



    /**
     * 获取所有计划中的任务列表
     *
     * @return
     */
    List<Map<String, Object>> queryAllJob();

}
