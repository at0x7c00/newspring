package me.huqiao.newspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("me.huqiao.newspring.dao") //JPAɨ��ð�·���µ�Repositorie
@EntityScan("me.huqiao.newspring.domain") //ɨ��Entityʵ����
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
