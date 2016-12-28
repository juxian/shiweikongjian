package com.swkj.zebra.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amaz.core.common.Collections3;
import com.amaz.core.common.DateUtils;
import com.amaz.core.common.StringUtils;
import com.amaz.core.orm.hibernate.HibernateTemplate;
import com.swkj.zebra.entity.WechatChartroom;
import javax.inject.Named;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

@Named
public class WechatChartroomDao extends HibernateTemplate<WechatChartroom, Long> {

	public void saveOnDuplicate(Long wxId, String chartroomName, List<WechatChartroom> wechatChartrooms) {
		//设置群组成员状态为非成员(0无效 1有效)
		String updatesql = "update ph_wechat_chartroom set last_modify_time=? where wx_id=? and chartroom_name=?";
		super.createSQLQuery(updatesql, DateUtils.getTime(), wxId, chartroomName).executeUpdate();

		if (wechatChartrooms.size() == 0) {
			return;
		}
		//插入群成员信息
		String[] filds = { "wx_id	", "chartroom_name", "chartroom_member", "create_time", "last_modify_time" };
		StringBuilder placeholders = new StringBuilder();
		for (int i = 0; i < filds.length - 1; i++) {
			placeholders.append("?,");
		}
		placeholders.append("?");
		//如果存在群成员，更新状态和时间
		String[] updateFilds = { "state", "update_time" };
		StringBuilder duplicateSql = new StringBuilder();
		for (int i = 0; i < updateFilds.length - 1; i++) {
			String updateFild = updateFilds[i];
			duplicateSql.append(updateFild).append("=").append("VALUES(").append(updateFild).append("),");
		}
		duplicateSql.append(updateFilds[updateFilds.length - 1]).append("=").append("VALUES(").append(updateFilds[updateFilds.length - 1]).append(")");

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ph_wechat_chartroom");
		sql.append("(").append(Collections3.convertToString(Arrays.asList(filds), ",")).append(")");
		sql.append("VALUES");
		List<Object> values = new ArrayList<>();
		for (WechatChartroom wc : wechatChartrooms) {
			sql.append("(").append(placeholders).append("),");
			values.add(wc.getWxId());
			values.add(wc.getChartroomName());
			values.add(wc.getChartroomMember());
			values.add(wc.getCreateTime());
			values.add(wc.getLastModifyTime());
		}
		sql = new StringBuilder(StringUtils.substringBeforeLast(sql.toString(), ","));
		sql.append(" ON DUPLICATE KEY UPDATE ");
		sql.append(duplicateSql);

		int r = createSQLQuery(sql.toString(), values.toArray()).executeUpdate();

	}
}
