package com.jason.blog.domain.article;

import java.util.Date;
import javax.validation.constraints.Size;

import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.domain.shared.IdDomainObject;
/**
 * 
 * @author Jason
 * @date 2013-1-27 上午10:47:05
 */
public class Article extends IdDomainObject{
	private static final long serialVersionUID = 1L;
	
	@Size(min = 2, max = 128,message="标题字符串限制2~128之间")
	private String title;
	
	@Size(min = 4, max = 3000)
	private String summary;		//摘要
	
	@Size(min = 4, max = 10000,message="内容字符限制在4~10000之间")
	private String content;
	
	private long viewCount;		//浏览数
	
	private long commentCount;	//评论数

	private int priority;

	private boolean onTop; 		//是否 置顶
	
	private int status;			//状态
	
	private Date createdAt;		//创建时间
	
	private Date updatedAt;		//最后更新时间

	private UserInfo user;

	
	public String getTitle() {
		return title;
	}

	public Article setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Article setContent(String content) {
		this.content = content;
		return this;
	}

	public long getViewCount() {
		return viewCount;
	}

	public Article setViewCount(long viewCount) {
		this.viewCount = viewCount;
		return this;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public Article setCommentCount(long commentCount) {
		this.commentCount = commentCount;
		return this;
	}

	public int getPriority() {
		return priority;
	}

	public Article setPriority(int priority) {
		this.priority = priority;
		return this;
	}

	public boolean isOnTop() {
		return onTop;
	}

	public Article setOnTop(boolean onTop) {
		this.onTop = onTop;
		return this;
	}

	public int getStatus() {
		return status;
	}

	public Article setStatus(int status) {
		this.status = status;
		return this;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Article setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Article setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public UserInfo getUser() {
		return user;
	}

	public Article setUser(UserInfo user) {
		this.user = user;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public Article setSummary(String summary) {
		this.summary = summary;
		return this;
	}
	
	
}
