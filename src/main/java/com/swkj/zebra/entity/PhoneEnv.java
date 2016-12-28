package com.swkj.zebra.entity;

import com.amaz.core.entity.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 手机环境信息
 */
@Entity
@Table(name = "ph_phone_env")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PhoneEnv extends IdEntity {
	private static final long serialVersionUID = 1L;
    private Long wxId;
    private String accountName;
    private String imei;
    private String imsi;
    private String androidId;
    private String serial;
    private Integer phoneType;
    private String phoneNumber;
    private String iccId;
    private String countryIso;
    private String operator;
    private String operatorName;
    private Integer activeNetworkType;
    private String activeNetworkTypeName;
    private Integer networkType;
    private String networkTypeName;
    private String mac;
    private String board;
    private String bootLoader;
    private String brand;
    private String device;
    private String display;
    private String fingerPrint;
    private String hardware;
    private String host;
    private String buildId;
    private String manufacturer;
    private String model;
    private String product;
    private String radio;
    private String tags;
    private String time;
    private String type;
    private String user;
    private String codeName;
    private String incremental;
    private String release;
    private Integer sdkInt;
    private Integer dev1;
    private String dev2;
    private String dev3;
    private String dev4;
    private String dev5;
    private String dev6;
    private String dev7Json;
    private Integer dev8;
    private String dev9;
    private String dev10;
    private String dev11Json;
    private String dev12Json;
    private String dev13Json;
    private String dev14;
    private String dev15;
    private String dev16;
    private Integer dev17;
    private Integer dev18;
    private String dev19;
    private Integer dev20;
    private String ip;

    public long getWxId() {
        return wxId;
    }

    public void setWxId(long wxId) {
        this.wxId = wxId;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(Integer phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIccId() {
        return iccId;
    }

    public void setIccId(String iccId) {
        this.iccId = iccId;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Integer getActiveNetworkType() {
        return activeNetworkType;
    }

    public void setActiveNetworkType(Integer activeNetworkType) {
        this.activeNetworkType = activeNetworkType;
    }

    public String getActiveNetworkTypeName() {
        return activeNetworkTypeName;
    }

    public void setActiveNetworkTypeName(String activeNetworkTypeName) {
        this.activeNetworkTypeName = activeNetworkTypeName;
    }

    public Integer getNetworkType() {
        return networkType;
    }

    public void setNetworkType(Integer networkType) {
        this.networkType = networkType;
    }

    public String getNetworkTypeName() {
        return networkTypeName;
    }

    public void setNetworkTypeName(String networkTypeName) {
        this.networkTypeName = networkTypeName;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getBootLoader() {
        return bootLoader;
    }

    public void setBootLoader(String bootLoader) {
        this.bootLoader = bootLoader;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getIncremental() {
        return incremental;
    }

    public void setIncremental(String incremental) {
        this.incremental = incremental;
    }

    @Column(name = "[release]", nullable = false)
    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public Integer getSdkInt() {
        return sdkInt;
    }

    public void setSdkInt(Integer sdkInt) {
        this.sdkInt = sdkInt;
    }

    public Integer getDev1() {
        return dev1;
    }

    public void setDev1(Integer dev1) {
        this.dev1 = dev1;
    }

    public String getDev2() {
        return dev2;
    }

    public void setDev2(String dev2) {
        this.dev2 = dev2;
    }

    public String getDev3() {
        return dev3;
    }

    public void setDev3(String dev3) {
        this.dev3 = dev3;
    }

    public String getDev4() {
        return dev4;
    }

    public void setDev4(String dev4) {
        this.dev4 = dev4;
    }

    public String getDev5() {
        return dev5;
    }

    public void setDev5(String dev5) {
        this.dev5 = dev5;
    }

    public String getDev6() {
        return dev6;
    }

    public void setDev6(String dev6) {
        this.dev6 = dev6;
    }

    public String getDev7Json() {
        return dev7Json;
    }

    public void setDev7Json(String dev7Json) {
        this.dev7Json = dev7Json;
    }

    public Integer getDev8() {
        return dev8;
    }

    public void setDev8(Integer dev8) {
        this.dev8 = dev8;
    }

    public String getDev9() {
        return dev9;
    }

    public void setDev9(String dev9) {
        this.dev9 = dev9;
    }

    public String getDev10() {
        return dev10;
    }

    public void setDev10(String dev10) {
        this.dev10 = dev10;
    }

    public String getDev11Json() {
        return dev11Json;
    }

    public void setDev11Json(String dev11Json) {
        this.dev11Json = dev11Json;
    }

    public String getDev12Json() {
        return dev12Json;
    }

    public void setDev12Json(String dev12Json) {
        this.dev12Json = dev12Json;
    }

    public String getDev13Json() {
        return dev13Json;
    }

    public void setDev13Json(String dev13Json) {
        this.dev13Json = dev13Json;
    }

    public String getDev14() {
        return dev14;
    }

    public void setDev14(String dev14) {
        this.dev14 = dev14;
    }

    public String getDev15() {
        return dev15;
    }

    public void setDev15(String dev15) {
        this.dev15 = dev15;
    }

    public String getDev16() {
        return dev16;
    }

    public void setDev16(String dev16) {
        this.dev16 = dev16;
    }

    public Integer getDev17() {
        return dev17;
    }

    public void setDev17(Integer dev17) {
        this.dev17 = dev17;
    }

    public Integer getDev18() {
        return dev18;
    }

    public void setDev18(Integer dev18) {
        this.dev18 = dev18;
    }

    public String getDev19() {
        return dev19;
    }

    public void setDev19(String dev19) {
        this.dev19 = dev19;
    }

    public Integer getDev20() {
        return dev20;
    }

    public void setDev20(Integer dev20) {
        this.dev20 = dev20;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
