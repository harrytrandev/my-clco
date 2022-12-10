package com.cloudcomputing.backend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.cloudcomputing.backend.api.StudentAPI;
import com.cloudcomputing.backend.model.StudentDTO;
import com.cloudcomputing.backend.service.StudentService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
@ExtendWith(MockitoExtension.class)
class BackendApplicationTests {
    @InjectMocks
	StudentAPI studentAPI;
	
	@Mock
	StudentService studentService;

	@Test
	public void testAllStudents() 
	{
		StudentDTO student = new StudentDTO();
		student.setFullname("Quang Tran");
		List<StudentDTO> list = new ArrayList<>();
		list.add(student);

		when(studentService.getAllStudent()).thenReturn(list);

		List<StudentDTO> students = studentAPI.getAllStudent();

		assertThat(students.size()).isEqualTo(1);
		
		assertThat(students.get(0).getFullname())
						.isEqualTo(student.getFullname());
	}
}
