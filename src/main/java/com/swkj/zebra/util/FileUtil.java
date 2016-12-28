package com.swkj.zebra.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/7 0007.
 */
public class FileUtil {
    private static String rootPath = "/root/work/logs/contacts";
    private final static String enter = System.getProperty("line.separator");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static synchronized void log(String fileName, String logMessage) {
        try {
            File folder = new File(rootPath);
            if (!folder.exists()) {
                folder.mkdir();
            }
            File file = new File(rootPath + "/" + fileName + ".log");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, false);
            fw.write(sdf.format(new Date()) + " " + logMessage + enter);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void log(String fileName, String[] logMessages) {
        try {
            File folder = new File(rootPath);
            if (!folder.exists()) {
                folder.mkdir();
            }
            File file = new File(rootPath + "\\" + fileName + ".log");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str = "";
            String strToal = "";
            while ((str = in.readLine()) != null) {
                strToal += (str + enter);
            }
            for (int i = 0; i < logMessages.length; i++) {
                String logMessage = logMessages[i];
                strToal = strToal + (sdf.format(new Date()) + " " + logMessage + enter);
            }
            in.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(strToal);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getJson(InputStream inputStream) {
        StringBuffer stringBuffer = null;
        try {
            stringBuffer = new StringBuffer();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String s = "";
            while ((s = br.readLine()) != null) {
                stringBuffer.append(s);
            }
            isr.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String retJson(String curl) {
        StringBuffer strBuf = new StringBuffer();
        try {
            URL url = new URL(curl);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));//转码。
            String line = "";
            while ((line = reader.readLine()) != null) {
                strBuf.append(line + " ");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strBuf.toString();
    }
}
