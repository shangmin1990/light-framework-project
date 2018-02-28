package com.benjamin.project.service.impl;

import com.benjamin.project.model.Ad;
import com.benjamin.project.service.IADService;
import com.fengjr.sauron.agent.annotation.Trace;
import net.shmin.common.service.BaseService;
import net.shmin.core.datasource.annotation.DataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 默认使用的是DataSources.SLOT0 数据源槽0 所指向的数据源
 */
@Service
@Transactional
@Trace
public class AdServiceImpl extends BaseService<Integer, Ad> implements IADService{

}
