package me.huqiao.newspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("me.huqiao.newspring.dao") //JPA扫描该包路径下的Repositorie
@EntityScan("me.huqiao.newspring.domain") //扫描Entity实体类
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
