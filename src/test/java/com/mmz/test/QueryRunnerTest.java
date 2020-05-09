package com.mmz.test;

import com.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname QueryRunnerTest
 * @Description TODO
 * @Date 2020/5/9 21:00
 * @Created by mmz
 */
public class QueryRunnerTest {

    @Test
    public void testQueryRunner(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner queryRunner  = applicationContext.getBean("queryRunner",QueryRunner.class);
        QueryRunner queryRunner1  = applicationContext.getBean("queryRunner",QueryRunner.class);
        System.out.println(queryRunner == queryRunner1);

    }
}
