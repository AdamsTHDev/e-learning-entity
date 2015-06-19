package com.adms.elearning.entity;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

import com.adms.common.domain.BaseAuditDomain;

@Entity
@Table(name="COURSE_ENROLMENT")
public class CourseEnrolment extends BaseAuditDomain {

	private static final long serialVersionUID = 5044971945518545158L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="EXAM_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date examDate;

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
	@JoinColumn(name="COURSE")
	private Course course;

	@ManyToOne
	@JoinColumn(name="SECTION")
	private Section section;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="courseEnrolment", cascade=CascadeType.ALL)
	private List<CourseResult> courseResults;

	@Formula("(select count(o.id) "
			+ " from COURSE_RESULT o "
			+ "	inner join ANSWER a on o.answer = a.id"
			+ " where o.COURSE_ENROLMENT = id"
			+ " and a.ANSWER_TYPE = 'CORRECT_ANS')")
	private int marks;

	@Formula("(select count(o.id) "
			+ " from COURSE_RESULT o "
			+ " where o.COURSE_ENROLMENT = id)")
	private int fullMarks;

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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public List<CourseResult> getCourseResults() {
		return courseResults;
	}

	public void setCourseResults(List<CourseResult> courseResults) {
		this.courseResults = courseResults;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getFullMarks() {
		return fullMarks;
	}

	public void setFullMarks(int fullMarks) {
		this.fullMarks = fullMarks;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}
