package com.iexchange.controller;

import com.iexchange.entity.Sample;
import com.iexchange.service.serviceImpl.SampleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhuChao on 2017/2/6.
 */
@Controller
public class SampleController {
    @Resource
    private SampleServiceImpl sampleService;

    @RequestMapping("sample.do")
    public ModelAndView sample(HttpServletRequest request, Model model) {
        System.out.println("SampleTest");
        Sample u=sampleService.getSample("zhuchao");
        System.out.println(u.getValue());
        ModelAndView mod=new ModelAndView();
        mod.setViewName("index");
        return mod;
    }

    public SampleServiceImpl getSampleService() {
        return sampleService;
    }

    public void setSampleService(SampleServiceImpl sampleService) {
        this.sampleService = sampleService;
    }
}
