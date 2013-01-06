package com.jason.blog.domain.article;

import java.util.Date;
import javax.validation.constraints.Size;

import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.domain.shared.IdDomainObject;

public class Article extends IdDomainObject{

	private static final long serialVersionUID = 1L;

	
	@Size(min = 6, max = 128)
	private String title;
	
	@Size(min = 6, max = 8192)
	private String content;
	
	private long viewCount;//瀏覽數
	
	private long commentCount;//評論數

	private int priority;

	private boolean onTop; //是否 置頂
	
	private int status;//狀態
	
	private Date createdAt;
	
	private Date updatedAt;

	private UserInfo userInfo;

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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public Article setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
		return this;
	}
	
	
}
