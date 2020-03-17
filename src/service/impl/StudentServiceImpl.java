package service.impl;

import java.util.List;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService{
	private final StudentDao studentDao;
	
	public StudentServiceImpl() {
		this.studentDao = new StudentDaoImpl();
	}
	
	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}
	
}
