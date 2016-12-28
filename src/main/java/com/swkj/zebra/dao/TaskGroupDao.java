package com.swkj.zebra.dao;

import javax.inject.Named;

import com.amaz.core.orm.hibernate.HibernateTemplate;
import com.swkj.zebra.entity.TaskGroup;
import com.swkj.zebra.entity.Vpn;

@Named
public class TaskGroupDao extends HibernateTemplate<TaskGroup,Long> {

}

    