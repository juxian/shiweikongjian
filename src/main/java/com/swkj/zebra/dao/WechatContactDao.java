package com.swkj.zebra.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.amaz.core.common.Collections3;
import com.amaz.core.common.StringUtils;
import com.amaz.core.orm.hibernate.HibernateTemplate;
import com.swkj.zebra.entity.WechatContact;

import javax.inject.Named;

@Named
public class WechatContactDao extends HibernateTemplate<WechatContact, Long> {

	private static final String[] FILDS = { "add_time", "alias", "area", "conremark", "gender","internal", "is_pull", "lh_mark", "message_time", "nickname","online_time", "shifu_zkm", "signature", "sns_timeline", "status","type", "verify_content", "wx_contact_uid", "wx_id","wxuid", "zkm", "update_time" };
	private static final String[] UPDATEFILDS = { "status", "alias", "nickname", "type", "update_time", "conremark" };

	public void saveOnDuplicateByWxId(Integer wxId, Collection<WechatContact> wechatContacts) {
		StringBuilder placeholders = new StringBuilder();//占位符块
		StringBuilder duplicateSql = new StringBuilder();//更新字段块
		StringBuilder sql = new StringBuilder();//插入语句块
		for (int i = 0; i < FILDS.length - 1; i++)
			placeholders.append("?,");
		placeholders.append("?");
		for (int i = 0; i < UPDATEFILDS.length - 1; i++) {
			String updateFild = UPDATEFILDS[i];
			duplicateSql.append(updateFild).append("=").append("VALUES(").append(updateFild).append("),");
		}
		duplicateSql.append(UPDATEFILDS[UPDATEFILDS.length - 1]).append("=").append("VALUES(").append(UPDATEFILDS[UPDATEFILDS.length - 1]).append(")");

		sql.append("INSERT INTO ph_wechat_contact");
		sql.append("(").append(Collections3.convertToString(Arrays.asList(FILDS), ",")).append(")");
		sql.append("VALUES");
		List<Object> values = new ArrayList<>();
		for (WechatContact wc : wechatContacts) {
			sql.append("(").append(placeholders).append("),");
			values.add(null != wc.getAddTime() ? wc.getAddTime() : "");
			values.add(null != wc.getAlias() ? wc.getAlias() : "");
			values.add(null != wc.getArea() ? wc.getArea() : "");
			values.add(null != wc.getConremark() ? wc.getConremark() : "");
			values.add(null != wc.getGender() ? wc.getGender() : "");

			values.add(null != wc.getInternal() ? wc.getInternal() : 0);
			values.add(null != wc.getIsPull() ? wc.getIsPull() : "");
			values.add(null != wc.getLhMark() ? wc.getLhMark() : "");
			values.add(null != wc.getMessageTime() ? wc.getMessageTime() : "");
			values.add(null != wc.getNickname() ? wc.getNickname() : "");

			values.add(null != wc.getOnlineTime() ? wc.getOnlineTime() : new Date());
			values.add(null != wc.getShifuZkm() ? wc.getShifuZkm() : "");
			values.add(null != wc.getSignature() ? wc.getSignature() : "");
			values.add(null != wc.getSnsTimeline() ? wc.getSnsTimeline() : "");
			values.add(null != wc.getStatus() ? wc.getStatus() : "");

			values.add(null != wc.getType() ? wc.getType() :0);
			values.add(null != wc.getVerifyContent() ? wc.getVerifyContent() : "");
			values.add(null != wc.getWxContactUid() ? wc.getWxContactUid() : "");
			values.add(null != wc.getWxId() ? wc.getWxId() : "");
			values.add(null != wc.getWxuid() ? wc.getWxuid() : "");

			values.add(null != wc.getZkm() ? wc.getZkm() : "");
			values.add(null != wc.getUpdateTime() ? wc.getUpdateTime() : "");
		}
		sql = new StringBuilder(StringUtils.substringBeforeLast(sql.toString(), ","));
		sql.append(" ON DUPLICATE KEY UPDATE ");
		sql.append(duplicateSql);
		try {
			createSQLQuery(sql.toString(), values.toArray()).executeUpdate();//执行
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateByWxId(Integer wxId) {
		String sql = "update ph_wechat_contact set status=?,update_time=? where wx_id=? and status = ?";
		super.createSQLQuery(sql, 0, new Date(), wxId, 0).executeUpdate();
	}

	public void saveOnDuplicateValidate(List<WechatContact> wechatContacts) {
        if (wechatContacts.size() == 0) {
            return;
        }

        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < FILDS.length - 1; i++) {
            placeholders.append("?,");
        }
        placeholders.append("?");

        StringBuilder duplicateSql = new StringBuilder();
        String[] updateFilds = {"wx_id", "status"};
        for (int i = 0; i < updateFilds.length - 1; i++) {
            String fild = updateFilds[i];
            duplicateSql.append(fild).append("=").append("VALUES(").append(fild).append("),");
        }
        duplicateSql.append(updateFilds[updateFilds.length - 1]).append("=").append("VALUES(").append(updateFilds[updateFilds.length - 1]).append(")");

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ph_wechat_contact");
        sql.append("(").append(Collections3.convertToString(Arrays.asList(FILDS), ",")).append(")");
        sql.append("VALUES");
        List<Object> values = new ArrayList<>();
        for (WechatContact wc : wechatContacts) {
            sql.append("(").append(placeholders).append("),");
            values.add(wc.getWxuid());
            values.add(wc.getWxContactUid());
            values.add(wc.getNickname());
            values.add(wc.getAlias());
            values.add(wc.getGender());
            values.add(wc.getArea());
            values.add(wc.getConremark());
            values.add(wc.getType());
            values.add(wc.getSignature());
            values.add(wc.getSnsTimeline());
            values.add(wc.getLhMark());
            values.add(wc.getAddTime());
            values.add(wc.getZkm());
            values.add(wc.getShifuZkm());
            values.add(wc.getInternal());
            values.add(wc.getStatus());
            values.add(wc.getWxId());
            values.add(wc.getUpdateTime());
            values.add(wc.getVerifyContent());
        }
        sql = new StringBuilder(StringUtils.substringBeforeLast(sql.toString(), ","));
        sql.append(" ON DUPLICATE KEY UPDATE ");
        sql.append(duplicateSql);
            int r = createSQLQuery(sql.toString(), values.toArray()).executeUpdate();
	}

}
