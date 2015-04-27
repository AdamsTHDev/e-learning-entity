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
@Table(name="COURSE_RESULT")
public class CourseResult extends BaseDomain {

	private static final long serialVersionUID = -8427125943157285023L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="COURSE_ENROLMENT")
	private CourseEnrolment courseEnrolment;
	
	@ManyToOne
	@JoinColumn(name="ANSWER")
	private Answer answer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseEnrolment getCourseEnrolment() {
		return courseEnrolment;
	}

	public void setCourseEnrolment(CourseEnrolment courseEnrolment) {
		this.courseEnrolment = courseEnrolment;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
}
