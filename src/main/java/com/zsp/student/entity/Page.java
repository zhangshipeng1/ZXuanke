package com.zsp.student.entity;

/**
 * @Author：张世朋
 * @Date：Create in2019/18:25/2019/12/8
 * @logNmae：zsp
 * @DO:
 */
public class Page {
    private Integer pageNo;
    private Integer pageSize;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
