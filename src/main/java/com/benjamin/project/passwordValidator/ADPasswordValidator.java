package com.benjamin.project.passwordValidator;

import net.shmin.auth.AuthContext;
import net.shmin.auth.authentication.PasswordValidator;
import net.shmin.core.dto.CommonResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义登录验证逻辑 实现密码验证逻辑
 *
 */
@Component("dream_business_ad_password_validator")
public class ADPasswordValidator implements PasswordValidator {

    @Override
    public CommonResponseDTO login(HttpServletRequest httpServletRequest) throws Exception {
        //TODO 登录逻辑实现
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("pwd");
        if(!"test".equals(username)){
            // 错误码和错误信息 封装成CommonResponseDTO返回到前端
            return CommonResponseDTO.error(100000, "该用户名不存在");
        }
        boolean result = "123456".equals(password);
        return CommonResponseDTO.status(result);
    }
}
