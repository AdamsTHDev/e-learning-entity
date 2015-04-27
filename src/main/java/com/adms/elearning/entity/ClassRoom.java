package com.adms.elearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.adms.common.domain.BaseDomain;

@Entity
@Table(name="CLASS_ROOM")
public class ClassRoom extends BaseDomain {

	private static final long serialVersionUID = 6828505332299050700L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CLASS_CODE")
	private String classCode;
	
	@Column(name="CLASS_NAME")
	private String className;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
