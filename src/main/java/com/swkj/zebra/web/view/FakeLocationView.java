package com.swkj.zebra.web.view;

import java.util.List;

import com.swkj.zebra.entity.CellInfo;
import com.swkj.zebra.entity.WifiInfo;

/**
 * 基站信息
 */
public class FakeLocationView {
    private double lon; // 经度
    private double lat; // 纬度
    private List<CellInfo> cellInfoList;
    private List<WifiInfo> wifiInfoList;
	
	public double getLon() {
		return lon;
	}
	
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public List<CellInfo> getCellInfoList() {
		return cellInfoList;
	}
	
	public void setCellInfoList(List<CellInfo> cellInfoList) {
		this.cellInfoList = cellInfoList;
	}
	
	public List<WifiInfo> getWifiInfoList() {
		return wifiInfoList;
	}
	
	public void setWifiInfoList(List<WifiInfo> wifiInfoList) {
		this.wifiInfoList = wifiInfoList;
	}

    
}
