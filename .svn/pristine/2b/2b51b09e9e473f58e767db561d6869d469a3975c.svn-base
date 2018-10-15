package com.blibli.academy.project.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


import static com.blibli.academy.project.codeconst.Stock.DEFAULT_TEMP_DIR;


/**
 * 定时器-----刷新 服务器临时文件夹。
 * @author baich
 */

@Slf4j
@Component
@EnableScheduling
public class TimeConfig implements SchedulingConfigurer {
    private static int fixedDelayCount = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     *每5分钟扫描一次
      */
    private static final String DEFAULT_CRON = "0 */5 * * * ?";
    private String cron = DEFAULT_CRON;

    // 文件名, 有效时间

    private Map<String, Date> fileList = new HashMap<>();

    /**
     *记录被删除的key
      */
    private List<String> delKeys = new ArrayList<>();

    /**
     * 用的 Lambda 表达式
     * @param taskRegistrar
     */

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        log.info("定时器启动");
        taskRegistrar.addTriggerTask(() -> {
            log.info("定时器执行");
            //定时业务处理
            if (!cron.equals(DEFAULT_CRON)) {
                System.out.println("定时参数修改了: " + fixedDelayCount++);
            }
            if (!fileList.isEmpty()) {
                log.info("fileList 不为空, 开始遍历map");
                //遍历map 判断时间
                for (Map.Entry<String, Date> entry :
                        fileList.entrySet()) {
                    if (System.currentTimeMillis() >= entry.getValue().getTime()) {
                        // 设置路径
                        File file = new File(DEFAULT_TEMP_DIR + entry.getKey());
                        log.info("缓存时间已到, 开始删除文件: " + file.getPath());
                        // 路径为文件且不为空则进行删除
                        if (file.isFile() && file.exists()) {
                            log.info("删除文件" + entry.getKey());
                            file.delete();
                            // 这里不能直接删除key, 因为正在遍历它,添加到list后面再删除
                            delKeys.add(entry.getKey());
                        }
                    } else {
                        log.info("还未到失效时间: " + dateFormat.format(entry.getValue()));
                    }
                }

                // 删除key
                if (!delKeys.isEmpty()) {
                    for (String key :
                            delKeys) {
                        fileList.remove(key);
                        log.info("key:" + key + "被移除");
                    }
                }
            } else {
                log.info("fileList为空");
            }
            log.info("定时器执行完毕");
        }, triggerContext -> {
            // 定时任务触发，可修改定时任务的执行周期
            CronTrigger trigger = new CronTrigger(cron);
            return trigger.nextExecutionTime(triggerContext);
        });
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Map<String, Date> getFileList() {
        return fileList;
    }

    public void setFileList(Map<String, Date> fileList) {
        this.fileList = fileList;
    }

    public void setFileList(String fileName, Date date) {
        this.fileList.put(fileName, date);
    }
}
