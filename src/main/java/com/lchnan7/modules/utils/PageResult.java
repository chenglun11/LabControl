package com.lchnan7.modules.utils;
import java.util.List;

/**
 * 分页返回结果
 */
public class PageResult<T> {
    /**
     * 当前页码
     */
    private Long pageNum;
    /**
     * 每页数量
     */
    private Long pageSize;
    /**
     * 记录总数
     */
    private Long totalSize;
    /**
     * 页码总数
     */
    private Long totalPages;
    /**
     * 数据模型
     */
    private List<T> rows;
    /**
     * 图片访问路径
     */
    private String baseImageUrl;

    public Long getPageNum() {
        return pageNum;
    }
    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }
    public Long getPageSize() {
        return pageSize;
    }
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
    public Long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }
    public Long getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String getBaseImageUrl() {
        return baseImageUrl;
    }

    public void setBaseImageUrl(String baseImageUrl) {
        this.baseImageUrl = baseImageUrl;
    }
}