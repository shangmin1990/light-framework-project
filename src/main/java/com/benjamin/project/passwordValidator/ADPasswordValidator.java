package com.benjamin.project.passwordValidator;

import com.le.bigdata.auth.authentication.PasswordValidator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现密码验证逻辑
 */
@Component("dream_business_ad_password_validator")
public class ADPasswordValidator implements PasswordValidator {
    @Override
    public boolean login(HttpServletRequest httpServletRequest) throws Exception {
        //TODO 登录逻辑实现
        return false;
    }
}
