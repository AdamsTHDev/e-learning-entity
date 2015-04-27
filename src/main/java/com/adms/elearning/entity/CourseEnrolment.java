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
@Table(name="COURSE_ENROLMENT")
public class CourseEnrolment extends BaseDomain {

	private static final long serialVersionUID = 5044971945518545158L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="STUDENT")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="EXAM_LEVEL_CODE", referencedColumnName="EXAM_LEVEL_CODE")
	private ExamLevel examLevel;
	
	@ManyToOne
	@JoinColumn(name="EXAM_TYPE_CODE", referencedColumnName="EXAM_TYPE_CODE")
	private ExamType examType;
	
	@ManyToOne
	@JoinColumn(name="CLASS_CODE", referencedColumnName="CLASS_CODE")
	private ClassRoom classRoom;
	
	@ManyToOne
	@JoinColumn(name="COURSE")
	private Course course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ExamLevel getExamLevel() {
		return examLevel;
	}

	public void setExamLevel(ExamLevel examLevel) {
		this.examLevel = examLevel;
	}

	public ExamType getExamType() {
		return examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
