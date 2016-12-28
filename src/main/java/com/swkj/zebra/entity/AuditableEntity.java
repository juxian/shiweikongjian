package com.swkj.zebra.entity;

import com.amaz.core.entity.IdEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;


/**
 * 含审计信息的Entity基类.
 * 
 * @author calvin
 */
@MappedSuperclass
public class AuditableEntity extends IdEntity {
	private static final long serialVersionUID = 1L;
	protected Date createTime = new Date();
	protected Date lastModifyTime;

	/**
	 * 创建时间.
	 */
	// 本属性只在save时有效,update时无效.
	@Column(updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

	/**
	 * 最后修改时间.
	 */
	// 本属性只在update时有效,save时无效.
	@Column(insertable = false)
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
}
