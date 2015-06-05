package com.adms.elearning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.adms.common.domain.BaseAuditDomain;

@Entity
@Table(name="ANSWER")
@NamedNativeQueries({
//	<!-- For getting question data -->
	@NamedNativeQuery(
			name="getAnswerByCourseIdSectionNoAndQuestionNo",
			query="SELECT t.ID, t.QUESTION, t.CHOICE_LETTER, t.ANSWER_TYPE, t.ANSWER_TEXT "
				+ " FROM ANSWER t "
				+ "	LEFT JOIN ANSWER_TYPE at on t.ANSWER_TYPE = at.ANSWER_TYPE_CODE "
				+ " LEFT JOIN QUESTION q on t.QUESTION = q.ID "
				+ " LEFT JOIN SECTION s on q.SECTION = s.ID "
				+ " LEFT JOIN COURSE c on s.COURSE = c.ID "
				+ " WHERE q.ACTIVE = 'Y' "
				+ " AND c.ID = ? "
				+ " AND s.SECTION_NO = ? "
				+ " AND q.QUESTION_NO = ? ",
			resultClass=Question.class)
})
public class Answer extends BaseAuditDomain {

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
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="answer", cascade=CascadeType.ALL)
	private List<CourseResult> courseResults;

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

	@Override
	public String toString() {
		return "Answer [id=" + id + ", question=" + question
				+ ", choiceLetter=" + choiceLetter + ", answerType="
				+ answerType + ", answerText=" + answerText + "]";
	}

	public List<CourseResult> getCourseResults() {
		return courseResults;
	}

	public void setCourseResults(List<CourseResult> courseResults) {
		this.courseResults = courseResults;
	}
	
}
