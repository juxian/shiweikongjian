package com.swkj.zebra.dao;

import com.amaz.core.orm.hibernate.HibernateTemplate;
import com.swkj.zebra.entity.PhoneEnv;

import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class PhoneEnvDao extends HibernateTemplate<PhoneEnv,Long>{
}
