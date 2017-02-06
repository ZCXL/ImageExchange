package com.iexchange.dao;

import com.iexchange.entity.Sample;

/**
 * Created by ZhuChao on 2017/2/6.
 */
public interface ISampleDao {
    int insert(Sample sample);

    Sample select(String key);
}
