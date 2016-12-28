package com.swkj.zebra.dao;

import com.amaz.core.orm.hibernate.HibernateTemplate;
import com.swkj.zebra.entity.Config;

import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class ConfigDao extends HibernateTemplate<Config, Long> {
}
