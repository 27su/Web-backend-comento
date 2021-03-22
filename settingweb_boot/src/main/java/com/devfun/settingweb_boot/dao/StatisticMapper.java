package com.devfun.settingweb_boot.dao;
import java.util.HashMap;
 
import com.devfun.settingweb_boot.dto.StatisticDto;
 
public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
    public HashMap<String, Object> selectMonthLoginUser(String month);
    public HashMap<String, Object> selectDateLoginUser(String date);
    public HashMap<String, Object> avgDayLogin();
    public HashMap<String, Object> selectDeptMonthLogin(String month, String dept);
}