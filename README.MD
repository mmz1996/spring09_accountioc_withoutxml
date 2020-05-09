**Configuration**
作用：当前类是一个配置类

**ComponentScan**
作用：用于通过注解指定在spring在创建容器时要扫描的包
属性value :它和basePackages的属性是一样的,都是用于指定创建容器时扫描的包
细节，当配置类作为AnnotationConfigurationContext对象创建的参数时，该注解可以不写。


我们使用此注解就等于在xml中配置了：

```bash
<context:component-scan base-package="com.mmz"></context:component-scan>
```

**Bean**
作用：用于把当前方法的返回值作为bean对象存入spring的ioc的容器中，
属性：name指定bean的id。默认值是当前方法的名称，


```bash
package com.mmz.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Classname SpringConfiguration
 * @Description 该类是一个配置类，它的作用于bean.xml是一样的。spring中的新注解
 * @Date 2020/5/9 20:01
 * @Created by mmz
 */
@Configuration
@ComponentScan(basePackages = "com.mmz")
public class SpringConfiguration {


    //用于创建一个QueryRunner
    @Bean(name = "queryRunner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return  new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("password");
        }catch (Exception e){
            throw new RuntimeException();
        }

    }



}

```
当我们使用注解配置方法时，如果方法有参数，Spring框架会去容器中查找有没有可用的bean对象。
查找的方式和AutoWired注解作用是一样的。



**Import**
作用：导入其他的配置类
属性：value ，用于指定其他配置类的字节码
当我们使用import注解之后，有Import注解的类就父配置类，而导入都是自配置类


**PropertySource**
用于指定Properties文件的位置。
属性： value:指定文件的名称和路径
关键字classpath:表示类路径下



<hr>
注解与xml如何选择
首要根据公司选择
注解和xml结合比较好。
