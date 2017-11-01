package com.rupeng.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rupeng.pojo.Subject;
import com.rupeng.service.SubjectService;

public class BaseServiceTest {

    private ApplicationContext applicationContext;
    private SubjectService subjectService;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("/beans.xml");
        subjectService = applicationContext.getBean(SubjectService.class);
    }

    @Test
    public void testInsertIsExistedSelectOneDelete() {
        Subject subject = new Subject();
        subject.setName("_testName");
        int result = subjectService.insert(subject);

        Assert.assertSame(1, result);

        boolean re = subjectService.isExisted(subject);
        Assert.assertSame(true, re);

        subject = subjectService.selectOne(subject);
        Assert.assertNotNull(subject);

        result = subjectService.delete(subject.getId());
        Assert.assertSame(1, result);

    }

}
