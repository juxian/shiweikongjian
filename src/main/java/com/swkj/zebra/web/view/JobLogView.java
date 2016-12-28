package com.swkj.zebra.web.view;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class JobLogView {
    private Integer jobId;//任务ID
    private Integer jobType;//任务类型
    private Integer state;//任务状态
    private String extra;//备注//TODO
    private String logTime;//任务时间//TODO


    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }
}
