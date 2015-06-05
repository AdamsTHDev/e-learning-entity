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
@Table(name="QUESTION")
@NamedNativeQueries({
//	<!-- For getting question data -->
	@NamedNativeQuery(
			name="getQuestionByCourseIdAndSectionNoAndQuestionNo",
			query="SELECT t.* "
				+ " FROM QUESTION t "
				+ " INNER JOIN SECTION s ON t.SECTION = s.ID "
				+ " INNER JOIN COURSE c ON s.COURSE = c.ID "
				+ " WHERE c.ID = ? "
				+ " AND s.SECTION_NO = ? "
				+ " AND t.QUESTION_NO = ? "
				+ " AND t.ACTIVE = 'Y' ",
			resultClass=Question.class)
})
public class Question extends BaseAuditDomain {

	private static final long serialVersionUID = 7088132665159469815L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="SECTION")
	private Section section;
	
	@Column(name="QUESTION_NO")
	private Integer questionNo;
	
	@Column(name="QUESTION_TEXT")
	private String questionText;
	
	@Column(name="ACTIVE")
	private String active;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="question", cascade=CascadeType.ALL)
	private List<Answer> answers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Integer getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}
