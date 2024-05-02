package lv.lvs.sem_06_01.service;

import java.util.ArrayList;

import lv.lvs.sem_06_01.model.Course;

public interface ICourseFilterService {
	
	public abstract ArrayList<Course> selectCoursesByCP(int cp)
			throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByProfessorId(int id)
			throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByStudentId(int id)
		throws Exception;
	

	


}
