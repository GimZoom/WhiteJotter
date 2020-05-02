package com.zio.wj.config;

import com.alibaba.fastjson.JSON;
import com.zio.wj.utils.ResultVOUtil;
import com.zio.wj.vo.ResultVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomizedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        System.out.println("success");
        //        ResultVO resultVO = ResultVOUtil.success(UserUtil.getCurrentUser());
        ResultVO resultVO = ResultVOUtil.success();
        String resultString = JSON.toJSONString(resultVO);
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.write(resultString);
        printWriter.flush();
        printWriter.close();
    }
}
