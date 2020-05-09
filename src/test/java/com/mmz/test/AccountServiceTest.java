package com.mmz.test;

import com.config.SpringConfiguration;
import com.mmz.pojo.Account;
import com.mmz.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Classname AccountServiceTest
 * @Description 使用junit单元测试配置
 * @Date 2020/5/9 13:41
 * @Created by mmz
 */
public class AccountServiceTest {

    private ApplicationContext applicationContext;
    private AccountService accountService;


    @Before
    public void init(){
        applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        accountService = applicationContext.getBean("accountService",AccountService.class);

    }


    @Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAllAccount();
        for(Account account: accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        accountService.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        Account account = accountService.findAccountById(1);
        account.setMoney(23456f);
        accountService.updateAccount(account);
    }
    @Test
    public void testDelete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        accountService.deleteAccount(7);
    }



}
