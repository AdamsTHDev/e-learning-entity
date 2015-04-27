package com.adms.elearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.adms.common.domain.BaseDomain;

@Entity
@Table(name="ANSWER")
public class Answer extends BaseDomain {

	private static final long serialVersionUID = -3022637327483787855L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="QUESTION")
	private Question question;
	
	@Column(name="CHOICE_LETTER")
	private String choiceLetter;
	
	@ManyToOne
	@JoinColumn(name="ANSWER_TYPE", referencedColumnName="ANSWER_TYPE_CODE")
	private AnswerType answerType;
	
	@Column(name="ANSWER_TEXT")
	private String answerText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getChoiceLetter() {
		return choiceLetter;
	}

	public void setChoiceLetter(String choiceLetter) {
		this.choiceLetter = choiceLetter;
	}

	public AnswerType getAnswerType() {
		return answerType;
	}

	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	
}
