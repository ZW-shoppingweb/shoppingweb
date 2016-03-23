package com.thoughtworks.shoppingweb.domain;

/**
 * Created by szwang on 3/23/16.
 */
public class Page {
    private int pageidid;//页数
    private int prepage;//上一页
    private int nextpage;//下一页
    private String next;
    private String pre;
    private int pagesize;
    private int showcontentbegin;
    private int showcontentend;
    private int totalpage;

    public int getShowcontentbegin() {
        return showcontentbegin;
    }

    public void setShowcontentbegin(int showcontentbegin) {
        this.showcontentbegin = showcontentbegin;
    }

    public int getShowcontentend() {
        return showcontentend;
    }

    public void setShowcontentend(int showcontentend) {
        this.showcontentend = showcontentend;
    }

    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }


    public int getTotalpage() {
        return totalpage;
    }
    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }
    public int getPageidid() {
        return pageidid;
    }
    public void setPageidid(int pageidid) {
        this.pageidid = pageidid;
    }
    public int getPrepage() {
        return prepage;
    }
    public void setPrepage(int prepage) {
        this.prepage = prepage;
    }
    public int getNextpage() {
        return nextpage;
    }
    public void setNextpage(int nextpage) {
        this.nextpage = nextpage;
    }
    public String getNext() {
        return next;
    }
    public void setNext(String next) {
        this.next = next;
    }
    public String getPre() {
        return pre;
    }
    public void setPre(String pre) {
        this.pre = pre;
    }
    public Page() {
        super();

    }
    //pageid当前页,all总记录数,num为每页显示大小
    public  void apartPage(int pageid,int all,int num){
        this.totalpage=this.computeTotal(all, num);
        this.setPagesize(num);
        this.setPageidid(pageid);
        this.setNextpage(pageid);
        this.setPrepage(pageid);
        this.setNext("下一页");
        this.setPre("上一页");
        if(pageid>1){
            this.setPrepage(pageid-1);
        }else{
            this.setPre("首页");
        }
        int rest=all-pageid*num;
        if(rest>0){
            this.showcontentend=pageid*this.pagesize;
            this.setNextpage(pageid+1);
        }
        else{
            this.showcontentend=all;
            this.setNext("尾页");
        }
        if(this.pre.equals("首页")&&this.next.equals("尾页")){
            this.setNext("");
        }
        this.showcontentbegin=(pageid-1)*this.pagesize;

    }
    //计算总页数
    private int computeTotal(int all,int num){
        int page=all/num;
        page=all%num>0?page+1:page;
        setTotalpage(page);
        return this.totalpage;
    }
}
