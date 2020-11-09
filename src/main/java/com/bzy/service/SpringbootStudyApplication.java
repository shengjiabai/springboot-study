package com.bzy.service;

import com.bzy.service.other.A;
import com.bzy.service.other.ImportTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //开始定时任务
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//不加载数据库配置
//@Import({ImportTest.class})
public class SpringbootStudyApplication {

    /**
     * <h2>SpringBoot 应用入口类</h2>
     * */
	public static void main(String[] args) {


		ConfigurableApplicationContext run = SpringApplication.run(SpringbootStudyApplication.class, args);
		//A bean = run.getBean(A.class);
//		ImportTest bean = run.getBean(ImportTest.class);
//		bean.test();

	}

}

