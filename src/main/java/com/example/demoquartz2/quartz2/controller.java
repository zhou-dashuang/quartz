package com.example.demoquartz2.quartz2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class controller {
    @Autowired
    private QuartzService quartzService;

    /**
     * 新增任务
     */
    @GetMapping("/insert")
    public String insertTask(String jName, String jGroup, String tName, String tGroup, String cron,String className) {
        quartzService.addJob(jName, jGroup, tName, tGroup, cron,className);
        return "添加成功！";
    }

    /**
     * 暂停任务
     */
    @GetMapping("/pause")
    public String pauseTask(String jName, String jGroup) {
        quartzService.pauseJob(jName, jGroup);
        return "暂停成功！";
    }

    /**
     * 继续任务
     */
    @GetMapping("/resume")
    public String resumeTask(String jName, String jGroup) {
        quartzService.resumeJob(jName, jGroup);
        return "继续成功！";
    }

    /**
     * 删除任务
     */
    @GetMapping("/delete")
    public String deleteTask(String jName, String jGroup) {
        quartzService.deleteJob(jName, jGroup);
        return "删除成功！";
    }

    /**
     * 获取所有正在运行的job
     */
    @GetMapping("/queryRunJob")
    public  List<Map<String, Object>> queryRunJob() {
        List<Map<String, Object>> list= quartzService.queryRunJob();
        return list;
    }

    /**
     * 获取所有job
     */
    @GetMapping("/queryAllJob")
    public  List<Map<String, Object>> queryAllJob() {
        List<Map<String, Object>> list= quartzService.queryAllJob();
        return list;
    }
}
