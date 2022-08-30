package com.iba.messmanagementsystem.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

//	@Autowired
//	StudentsRepository studentsRepository;
//
//	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
//
//	@Override
//	public boolean saveStudent(Students students) throws IOException {
//		try {
//			if (students != null) {
//				studentsRepository.save(students);
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		return false;
//
//	}
//
//	@Override
//	public List<Students> getAllStudents() {
//		return studentsRepository.findAll();
//	}
//
//	@Override
//	public boolean deleteFile(Long id, String file) {
//		boolean status = false;
//		try {
//			if (id != 0 && file != null) {
//				studentsRepository.deleteStudentWithFile(id, file);
//				System.out.println(this.getClass().getSimpleName() + ":deleting student... " + id);
//				String path = uploadDirectory + "/" + file;
//				System.out.println("Path=" + path);
//				File fileToDelete = new File(path);
//				status = fileToDelete.delete();
//				System.out.println(this.getClass().getSimpleName() + ":deleting image... " + file);
//				System.out.println("Success: " + status + " fileToDelete: " + fileToDelete);
//				return status;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return status;
//		}
//		return status;
//	}
}
