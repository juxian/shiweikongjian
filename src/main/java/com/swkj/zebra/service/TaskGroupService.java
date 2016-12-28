package com.swkj.zebra.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.TaskGroupDao;
import com.swkj.zebra.entity.TaskGroup;

@Service
public class TaskGroupService extends BaseService<TaskGroup, Long> {

	@Autowired
	private TaskGroupDao taskGroupDao;

	@Override
	protected CommonRepository<TaskGroup, Long> getEntityRepository() {
		return taskGroupDao;

	}

	public TaskGroup get(ArrayList<Object> arrayList) {
		return null;
	}

}
