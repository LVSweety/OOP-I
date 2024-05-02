package lv.lvs.sem_06_01.service;

import java.util.ArrayList;

import lv.lvs.sem_06_01.model.Grade;

public interface IGradeFilterService {
	public abstract ArrayList<Grade> selectGradesByStudentId(int id)
			throws Exception;
	
	public abstract ArrayList<Grade> selectFailedGradesByStudentId(int id)
			throws Exception;
	
	public abstract float calculateAVGGradeInCourseById(int id)
			throws Exception;
}
