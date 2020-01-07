package edu.dlnu.oa.URLController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 车辆管理的url配置
 */
@Controller
@RequestMapping("/carCenter")
public class CarCenterUrlController {

    //车辆信息页面
    @RequestMapping("/CarCenterList")
    public String carCenterInfoList() { return "carCenter/queryCarCenter"; }

    //派车记录页面
    @RequestMapping("/CarRentList")
    public String carRentInfoList() { return "carCenter/queryCarRent"; }

    //代办派车页面
    @RequestMapping("/CarRentStateList")
    public String carRentStateList() { return "carCenter/queryCarState"; }

    //公用列表测试
    @RequestMapping("/CarMenu")
    public String carMenu() {return "carCenter/comMenu";}

    //自己的用车申请
    @RequestMapping("/carApply")
    public String carApply() {return "carCenter/carApply";}

    //行政主管的用车申请列表
    @RequestMapping("/applyProcess")
    public String applyProcess() {return "carCenter/applyProcess";}
}
