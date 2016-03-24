package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

/**
 * Created by szwang on 3/23/16.
 */
@Data
public class Page {
    private int pageId;//页数
    private int prePage;//上一页
    private int nextPage;//下一页
    private String next;
    private String pre;
    private int pageSize;
    private int showContentBegin;
    private int showContendEnd;
    private int totalPage;
    public Page() {
        super();

    }
    //pageId当前页,all总记录数,num为每页显示大小
    public  void apartPage(int pageId,int all,int num){
        this.totalPage=this.computeTotal(all, num);
        this.setPageSize(num);
        this.setPageId(pageId);
        this.setNextPage(pageId);
        this.setPrePage(pageId);
        this.setNext("下一页");
        this.setPre("上一页");
        if(pageId>1){
            this.setPrePage(pageId-1);
        }else{
            this.setPre("首页");
        }
        int rest=all-pageId*num;
        if(rest>0){
            this.showContendEnd=pageId*this.pageSize;
            this.setNextPage(pageId+1);
        }
        else{
            this.showContendEnd=all;
            this.setNext("尾页");
        }
        if(this.pre.equals("首页")&&this.next.equals("尾页")){
            this.setNext("");
        }
        this.showContentBegin=(pageId-1)*this.pageSize;

    }
    //计算总页数
    private int computeTotal(int all,int num){
        int page=all/num;
        page=all%num>0?page+1:page;
        setTotalPage(page);
        return this.totalPage;
    }
}