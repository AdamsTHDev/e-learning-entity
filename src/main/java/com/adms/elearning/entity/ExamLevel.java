package com.adms.elearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.adms.common.domain.BaseDomain;

@Entity
@Table(name="EXAM_LEVEL")
public class ExamLevel extends BaseDomain {

	private static final long serialVersionUID = -1016600474226659418L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="EXAM_LEVEL_CODE")
	private String examLevelCode;
	
	@Column(name="EXAM_LEVEL")
	private String examLevel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExamLevelCode() {
		return examLevelCode;
	}

	public void setExamLevelCode(String examLevelCode) {
		this.examLevelCode = examLevelCode;
	}

	public String getExamLevel() {
		return examLevel;
	}

	public void setExamLevel(String examLevel) {
		this.examLevel = examLevel;
	}
	
}
