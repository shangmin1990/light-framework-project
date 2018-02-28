package com.benjamin.project.dubbo.api.impl;

import com.benjamin.project.dubbo.api.DubboTest;

/**
 * @Author: benjamin
 * @Date: Create in  2017/11/19 下午11:20
 * @Description:
 */
public class DubboTestImpl implements DubboTest {
    @Override
    public String dubboTest() {
        return "Success";
    }
}
