package com.le.jr.solr.client;

import com.le.jr.solr.client.annotation.PageField;
import com.le.jr.solr.client.annotation.ScopeField;
import com.le.jr.solr.client.common.enums.ScopeFiledEnum;

import java.util.Date;

/**
 * TODO
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-06-23
 */
public class Test {

    @PageField(name="pageSize")
    private int pageSize;

    @PageField(name="start")
    private int start;

    @ScopeField(name="createTime",mode= ScopeFiledEnum.GT)
    private Date startTime;

    @ScopeField(name="createTime",mode= ScopeFiledEnum.LT)
    private Date endTime;

    private String letvUserId;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getLetvUserId() {
        return letvUserId;
    }

    public void setLetvUserId(String letvUserId) {
        this.letvUserId = letvUserId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
