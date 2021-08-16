package com.dyf.grab.entity;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;
 
public class CategoryEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private String cid;
 
	@SerializedName("is_parent")
	private Boolean isParent;
 
	private String name;
	@SerializedName("parent_cid")
	private String parentCid;
 
	private String status;
 
	private Integer level;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCid() {
		return parentCid;
	}

	public void setParentCid(String parentCid) {
		this.parentCid = parentCid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CategoryEntity [cid=" + cid + ", isParent=" + isParent + ", name=" + name + ", parentCid=" + parentCid
				+ ", status=" + status + ", level=" + level + "]";
	}
 
}
