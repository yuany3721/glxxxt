package top.yuany3721.glxxxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan("top.yuany3721.glxxxt.dao")
@EntityScan("top.yuany3721.glxxxt.entity")
public class GlxxxtApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(GlxxxtApplication.class, args);
	}
}
