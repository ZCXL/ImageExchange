package com.iexchange.service.serviceImpl;


import com.iexchange.dao.ISampleDao;
import com.iexchange.entity.Sample;
import com.iexchange.service.ISampleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ZhuChao on 2017/2/6.
 */
@Service
public class SampleServiceImpl implements ISampleService {
    @Resource
    private ISampleDao sampleDao;
    @Override
    public Sample getSample(String key) {
        return this.sampleDao.select(key);
    }

    public static void main(String []args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        SampleServiceImpl s = (SampleServiceImpl)ctx.getBean("sampleServiceImpl");
        Sample sample = s.getSample("zhuchao");
        System.out.println(sample.getValue());
    }

    public ISampleDao getSampleDao() {
        return sampleDao;
    }

    public void setSampleDao(ISampleDao sampleDao) {
        this.sampleDao = sampleDao;
    }
}
