package ${config.Action().packageName()};

import com.ucpaas.opt.action.NewBaseAction;
import com.ucpaas.opt.model.PageContainer;
import com.ucpaas.opt.service.monitor.ISmsMonitorService;
import com.ucpaas.opt.util.JsonUtils;
import com.ucpaas.opt.util.file.ExcelUtils;
import com.ucpaas.opt.util.rest.vo.Excel;
import com.ucpaas.opt.util.web.StrutsUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;


@Controller
@Scope("prototype")
@Results({
    <#list config.Action().results() as result>
    @Result(name = "${result.name()}", location = "${result.location()}"),
    </#list>
})
public class ${config.Action().clazzName()} extends NewBaseAction {

    @Autowired
    ${config.service().value()} ${obj.firstToLowerCase("${config.service().value()}")};

    private static final Logger logger = LoggerFactory.getLogger(${config.Action().clazzName()}.class);

    <#list config.Action().methods() as method>
        <#if method.json() == true>
            @Action("${method.action()}")
            public String ${obj.getMethodName("${method.action()}")}() {
                return "${method.result()}";
            }
        <#elseif method.excel() == true>
            @Action("${method.action()}")
            public void ${obj.getMethodName("${method.action()}")}() {
                HttpServletResponse response = ServletActionContext.getResponse();

                Excel excel = initHeaders(initExcel("短信发送到达报表"), false);
                PageContainer container = smsMonitorService.querySmsReachReport(StrutsUtils.getFormDataX());
                excel.setDataList(container.getList());

                OutputStream os = null;
                try {
                excelResponse(response, "短信发送到达报表.xls");
                ExcelUtils.exportExcel(excel, response.getOutputStream());
                } catch (IOException e) {
                logger.error("导出发送到达报表excel报错：" + e);
                } finally {
                if (os != null) {
                try {
                os.close();
                } catch (IOException e) {}
                }
                }
            }
        <#else>
            @Action("${method.action()}")
            public void ${obj.getMethodName("${method.action()}")}() {
                StrutsUtils.renderJson(new Object());
            }
        </#if>
    </#list>


    /**
    * 设置excel表的内容
    *
    * @return
    */
    private Excel initExcel() {
        Excel excel = new Excel();
        <#assign map = map>
        <#list map?keys as key>
        excel.addHeader(${map[key].width()}, "${key}", "${map[key].value()}");
        </#list>
        PageContainer container = smsMonitorService.querySmsReachReport(StrutsUtils.getFormData());
        excel.setDataList(container.getList());
        excel.setTitle("短信发送到达报表");
        return excel;
    }





    private void excelResponse(HttpServletResponse response, String fileName){
        try {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "ISO-8859-1"));
            response.setContentType("application/msexcel");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private String appendJson(String rows, int totalCount){
        return "{\"rows\":" + rows + ",\"total\":" + totalCount + "}";
    }
}
