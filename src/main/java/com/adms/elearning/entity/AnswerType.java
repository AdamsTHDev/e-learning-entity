package com.adms.elearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.adms.common.domain.BaseDomain;

@Entity
@Table(name="ANSWER_TYPE")
public class AnswerType extends BaseDomain {

	private static final long serialVersionUID = -5006021125855507401L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ANSWER_TYPE_CODE")
	private String answerTypeCode;
	
	@Column(name="DESCRIPTION")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswerTypeCode() {
		return answerTypeCode;
	}

	public void setAnswerTypeCode(String answerTypeCode) {
		this.answerTypeCode = answerTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
