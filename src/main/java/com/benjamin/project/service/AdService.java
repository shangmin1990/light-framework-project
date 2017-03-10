package com.benjamin.project.service;

import com.benjamin.project.model.Ad;
import com.le.bigdata.common.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by benjamin on 2017/3/9.
 */
@Service
@Transactional
public class AdService extends BaseService<Integer, Ad> {

}
