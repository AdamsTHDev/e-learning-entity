package com.adms.elearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.adms.common.domain.BaseDomain;

@Entity
@Table(name="EXAM_TYPE")
public class ExamType extends BaseDomain {

	private static final long serialVersionUID = 1167828229209044823L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="EXAM_TYPE_CODE")
	private String examTypeCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExamTypeCode() {
		return examTypeCode;
	}

	public void setExamTypeCode(String examTypeCode) {
		this.examTypeCode = examTypeCode;
	}
	
}
