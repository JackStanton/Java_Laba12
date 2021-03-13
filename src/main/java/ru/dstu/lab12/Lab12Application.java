package ru.dstu.lab12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.dstu.lab12.dao.Dao;
import ru.dstu.lab12.dao.entitiesDao.StudentDao;
import ru.dstu.lab12.entities.Student;
import ru.dstu.lab12.services.ApplicationServiceImpl;

@SpringBootApplication
public class Lab12Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab12Application.class, args);

	}

}
