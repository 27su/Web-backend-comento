package com.devfun.settingweb_boot.service;
 
import java.util.HashMap;
 
public interface StatisticService {
    public HashMap<String,Object> yearloginNum (String year);
    public HashMap<String,Object> monthloginuserNum (String month);
    public HashMap<String,Object> dateloginuserNum (String date);
    public HashMap<String,Object> avgdayloginNum ();
    public HashMap<String,Object> deptmonthloginNum (String month, String dept);
}