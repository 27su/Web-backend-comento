package com.devfun.settingweb_boot.service;
 
 
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    public HashMap<String, Object> yearloginNum (String year) {
        // TODO Auto-generated method stub
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }

	@Override
	public HashMap<String, Object> monthloginuserNum(String month) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectMonthLoginUser(month);
            retVal.put("month", month);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("month", month);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}

	@Override
	public HashMap<String, Object> dateloginuserNum(String date) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectDateLoginUser(date);
            retVal.put("date", date);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("date", date);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}

	@Override
	public HashMap<String, Object> avgdayloginNum() {
		// TODO Auto-generated method stub
HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.avgDayLogin();
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}

	@Override
	public HashMap<String, Object> deptmonthloginNum(String month, String dept) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectDeptMonthLogin(month, dept);
            retVal.put("month", month);
            retVal.put("dept", dept);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("month", month);
            retVal.put("dept", dept);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}
    
    
 
}