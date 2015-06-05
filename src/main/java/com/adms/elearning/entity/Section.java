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

import com.adms.common.domain.BaseDomain;

@Entity
@Table(name="SECTION")
@NamedNativeQueries({
//	<!-- For getting section data -->
	@NamedNativeQuery(
			name="getSectionByCourseIdAndSectionNo",
			query="SELECT t.* "
				+ " FROM SECTION t "
				+ " LEFT OUTER JOIN COURSE c ON t.COURSE = c.ID "
				+ " WHERE c.ID = ? AND t.SECTION_NO = ? ",
			resultClass=Section.class)
})
public class Section extends BaseDomain {

	private static final long serialVersionUID = 2839809624253805974L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="COURSE")
	private Course course;
	
	@Column(name="SECTION_NO")
	private Integer sectionNo;
	
	@Column(name="SECTION_NAME")
	private String sectionName;
	
	@Column(name="SECTION_DESCRIPTION")
	private String sectionDescription;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="section", cascade=CascadeType.ALL)
	private List<Question> questions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionDescription() {
		return sectionDescription;
	}

	public void setSectionDescription(String sectionDescription) {
		this.sectionDescription = sectionDescription;
	}

	public Integer getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(Integer sectionNo) {
		this.sectionNo = sectionNo;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
