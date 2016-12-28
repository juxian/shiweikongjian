//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.swkj.zebra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@ConfigurationProperties(
    prefix = "spring.jpa"
)
public class HibernateProperties {
    private Map<String, String> properties = new HashMap();
    private Map<String, String> hibernate = new HashMap<>();
    private String showSql ="false";



    public Map<String, String> getProperties() {
        this.properties.put("hibernate.show_sql", showSql);
        if (hibernate.containsKey("hibernate.hbm2ddl.auto")){
            this.properties.put("hibernate.hbm2ddl.auto",hibernate.get("ddl-auto"));
        }
        return this.properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, String> getHibernate() {
        return hibernate;
    }

    public void setHibernate(Map<String, String> hibernate) {
        this.hibernate = hibernate;
    }

    public String getShowSql() {
        return showSql;
    }

    public void setShowSql(String showSql) {
        this.showSql = showSql;
    }


}
