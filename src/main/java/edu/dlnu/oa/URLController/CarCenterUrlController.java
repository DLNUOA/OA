package edu.dlnu.oa.URLController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 车辆管理的url配置
 */
@Controller
@RequestMapping("/carCenter")
public class CarCenterUrlController {
    @RequestMapping("/CarCenterList")
    public String carCenterInfoList() { return "carCenter/queryCarCenter"; }
}
