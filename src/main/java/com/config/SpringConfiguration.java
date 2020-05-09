package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @Classname SpringConfiguration
 * @Description 该类是一个配置类，它的作用于bean.xml是一样的。spring中的新注解
 * @Date 2020/5/9 20:01
 * @Created by mmz
 */
@Configuration
@ComponentScan({"com.mmz"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
