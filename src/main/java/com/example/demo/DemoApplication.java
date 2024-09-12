package com.example.demo;

import com.example.dao.StudentDAOable;
import com.example.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
		"com.example",
})
@EntityScan( basePackages = {
		"com.example.entity"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAOable studentDAO) {
		return runner -> {
			System.out.println("Hello World");
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAOable studentDAO) {
		System.out.println("Creating student");
		var student = new Student("Marcos", "Lucas", "juanmiguel431@gmail.com");

		System.out.println("Saving the Student.");
		studentDAO.save(student);

		var id = student.getId();
		System.out.println("Student saved. The Id is " + id);

		var dbStudent = studentDAO.getById(id);
		System.out.println("The queried student is " + dbStudent);

		var allStudents = studentDAO.getAll();

		for(var item: allStudents) {
			System.out.println(item);
		}
	}
}
