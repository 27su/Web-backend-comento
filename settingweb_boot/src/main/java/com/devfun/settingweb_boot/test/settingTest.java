package com.devfun.settingweb_boot.test;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
import com.devfun.settingweb_boot.service.StatisticService;
 
 
 
@Controller
public class settingTest {
    
    @Autowired
    private StatisticService service;
    
    @ResponseBody 
    @RequestMapping("/sqlYearLogin")
    public Map<String, Object> sqlyearlogin(String year) throws Exception{ 
        
        return service.yearloginNum(year);
    }
    @ResponseBody 
    @RequestMapping("/sqlMonthLoginUser")
    public Map<String, Object> sqlmonthloginuser(String month) throws Exception{ 
        
        return service.monthloginuserNum(month);
    }
    @ResponseBody 
    @RequestMapping("/sqlDateLoginUser")
    public Map<String, Object> sqldateloginuser(String date) throws Exception{ 
        
        return service.dateloginuserNum(date);
    }
    @ResponseBody 
    @RequestMapping("/sqlavgDayLogin")
    public Map<String, Object> sqlavgdayloginNum(String date) throws Exception{ 
        
        return service.avgdayloginNum(date);
    }
    @ResponseBody 
    @RequestMapping("/sqlDeptMonthLogin")
    public Map<String, Object> sqldeptmonthlogin(String month) throws Exception{ 
        
        return service.deptmonthloginNum(month);
    }
    
    @RequestMapping("/test") 
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "devfunpj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}