package com.example.valposystemsdemo;

import com.example.valposystemsdemo.model.UserModel;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MappedTypes(UserModel.class)
@MapperScan("com.example.valposystems.mapper")
@SpringBootApplication
public class ValposystemsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValposystemsDemoApplication.class, args);
	}

}
