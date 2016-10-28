package com.vshop.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.vshop.util.StringHelper;

/**
 * 自定义标签类（用来实现格式化时间戳）
 * 
 * @author ASUS
 * 
 */
public class FormatTimeStamp extends SimpleTagSupport {

	/**
	 * 时间戳
	 */
	private long timestamp;
	/**
	 * 时间格式（yyyy-MM-dd | yyyy-MM-dd HH:mm:ss）
	 */
	private String format;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
        out.println(StringHelper.getDateByTimeStamp(timestamp, format));
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}

