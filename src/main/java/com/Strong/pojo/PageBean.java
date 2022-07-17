package com.Strong.pojo;

import java.util.List;

public class PageBean<T> {
    //当前页所有数据的个数
    private long totalSize;
    //返回的是分页 查询到的数据
    private List<T> pageSizeDate;

    public List<T> getPageSizeDate() {
        return pageSizeDate;
    }

    public void setPageSizeDate(List<T> pageSizeDate) {
        this.pageSizeDate = pageSizeDate;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }


}
