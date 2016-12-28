package com.swkj.zebra.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
public class RandomUtils {
    private static final double PI = 3.14159265;

    /**
     * 获取集合长度的随机下标
     */
    public static Integer getRandomNumber(Integer size) {
        Random random = new Random();
        return random.nextInt(size);
    }

    /**
     * 根据经纬度和距离返回一个矩形范围
     *
     * @param lng      经度
     * @param lat      纬度
     * @param distance 距离(单位为米)
     * @return [lng1, lat1, lng2,lat2] 矩形的左下角(lng1,lat1)和右上角(lng2,lat2)
     */
    public static double[] getRectangle(double lng, double lat, long distance) {
        float delta = 111000;
        if (lng != 0 && lat != 0) {
            double lng1 = lng - distance / Math.abs(Math.cos(Math.toRadians(lat)) * delta);
            double lng2 = lng + distance / Math.abs(Math.cos(Math.toRadians(lat)) * delta);
            double lat1 = lat - (distance / delta);
            double lat2 = lat + (distance / delta);
            System.out.println(lng1+","+ lat1+","+lng2+","+lat2);
            return new double[]{lng1, lat1, lng2, lat2};
        } else {
            // TODO ZHCH 等于0时的计算公式
            double lng1 = lng - distance / delta;
            double lng2 = lng + distance / delta;
            double lat1 = lat - (distance / delta);
            double lat2 = lat + (distance / delta);
            return new double[]{lng1, lat1, lng2, lat2};
        }
    }

    /**
     * 矩形范围内 随机返回
     */
    public static String randomLonLat(double lat1, double lng1, double lat2, double lng2) {
        BigDecimal db = new BigDecimal(Math.random() * (lng2 - lng1) + lng1);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();//小数后6位
        db = new BigDecimal(Math.random() * (lat2 - lat1) + lat1);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        return lon + "@" + lat;
    }
}
