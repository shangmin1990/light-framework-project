package com.benjamin.project.service.impl;

import com.benjamin.project.model.IndexAd;
import com.benjamin.project.service.IIndexAdService;

import net.shmin.common.service.BaseService;
import net.shmin.core.datasource.DataSources;
import net.shmin.core.datasource.annotation.DataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @DataSource 代表该类使用的是DataSources.SLOT1 数据源槽1 所指向的数据源
 * 默认提供了16个数据源槽
 */
@Service
@Transactional
@DataSource(DataSources.SLOT1)
public class IndexAdServiceImpl extends BaseService<Integer, IndexAd> implements IIndexAdService {
}
