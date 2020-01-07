package edu.dlnu.oa.peopleSend.controller;

import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import edu.dlnu.oa.peopleSend.service.ComSendListService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * 外派记录controller
 */
@RestController
@RequestMapping("api")
public class ComSendListController {

    @Autowired
    private ComSendListService service;

    //查询所有外派记录
    @RequestMapping(value = "/sendList/query", method = GET)
    public List<Map<String,Object>> query() { return service.querySList(); }

    //删除外派记录
    @RequestMapping(value = "/sendList/delete/{sendId}", method = DELETE)
    public int delete(@PathVariable int sendId) { return service.deleteList(sendId); }

    //添加外派记录
    @RequestMapping(value = "/sendList/add", method = POST)
    public int add(@RequestBody Map<String,Object> map) {
        Map<String,Object> sl = new HashMap<>();
        sl.put("sendSpId",map.get("spId"));
        sl.put("sendComId",map.get("comId"));
        sl.put("sendPeopleName",map.get("spName"));
        sl.put("sendComName",map.get("comName"));
//        更改外派人员状态
        service.updateState((int)map.get("spId"),(int)map.get("spState"));
        return service.addList(sl);
    }

    //导出表
    @GetMapping("/sendList/getExcel")
    @ResponseBody
    public void export(HttpServletResponse response, HttpServletRequest request) throws IOException {

        List<Map<String,Object>> sendList = service.querySList();

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("外派情况记录");
        HSSFCellStyle yellowStyle = wb.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle redStyle = wb.createCellStyle();
        redStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFRow row = null;
        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short)(20*20));
        row.createCell(0).setCellValue("外派编号");
        row.createCell(1).setCellValue("员工编号");
        row.createCell(2).setCellValue("公司编号");
        row.createCell(3).setCellValue("员工姓名");
        row.createCell(4).setCellValue("公司名称");



        //表格第一行设置完成，接下来就是取数据了
        for(int v=0;v<sendList.size();v++) {
            row = sheet.createRow(v + 1);
            Map<String,Object> map = sendList.get(v);
            HSSFCell cell = row.createCell(0);
            int s = (int) map.get("send_id");
            cell.setCellValue(s);
            HSSFCell cell1 = row.createCell(1);
            HSSFCell cell2 = row.createCell(2);
            HSSFCell cell3 = row.createCell(3);
            HSSFCell cell4 = row.createCell(4);

            cell1.setCellValue( map.get("send_sp_id").toString());
            cell2.setCellValue( map.get("send_com_id").toString());
            cell3.setCellValue( map.get("send_people_name").toString());
            cell4.setCellValue( map.get("send_com_name").toString());




            sheet.setDefaultRowHeight((short) (16.5 * 20));
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=SendList.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }
}
