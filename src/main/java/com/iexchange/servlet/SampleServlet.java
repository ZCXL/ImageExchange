package com.iexchange.servlet;

import com.iexchange.entity.Sample;
import com.iexchange.service.serviceImpl.SampleServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ZhuChao on 2017/2/6.
 */
public class SampleServlet extends HttpServlet{
    private SampleServiceImpl sampleService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        sampleService = (SampleServiceImpl)wac.getBean("sampleServiceImpl");
        Sample sample = sampleService.getSample("zhuchao");
        System.out.println("SampleTest: " + sample.getValue());
        PrintWriter out = resp.getWriter();
        out.println("SampleTest: " + sample.getValue());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
