package edu.dlnu.oa.URLController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AssetManagement")
class AssetManagementUrlController{
    @RequestMapping ("/AddAsset")
    public String AddAsset(){ return "asset/AddAsset"; }
    @RequestMapping ("/QueryAsset")
    public String GetAsset(){ return "asset/QueryAsset"; }
    @RequestMapping ("/UpdateAsset")
    public String UpdateAsset(){ return "asset/UpdateAsset"; }
}
