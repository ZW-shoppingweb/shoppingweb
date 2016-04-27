package com.thoughtworks.shoppingweb.web.tag;

/**
 * Created by szwang on 4/27/16.
 */
import lombok.Data;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
@Data
public class MenuTag extends SimpleTagSupport{
    // 标签定义的属性
    private String name;
    private String classes;

    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        String menuTag="<ul class='"+classes+"'>" +
                "<li><input type='radio'  name='"+name+"' value='ASC' ng-click='filterProduct()'/>升序</li>" +
                "<li><input type='radio'  name='"+name+"' value='DESC' ng-click='filterProduct()'/>降序</li>" +
                "<li><input type='radio'  name='"+name+"' checked='checked' value='' ng-click='filterProduct()'/>默认</li>" +
                "</ul>";
        out.write(menuTag);
        //out.write("价格：" + price);
        //out.write("书店：" + store);
    }
}
