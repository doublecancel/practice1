package benas;

import annotations.*;


@Config(
        Action = @Action(
                    packageName = "com.ucpaas.opt.action.monitor",
                    pathName = "F:\\github\\practice\\util\\src\\main\\java\\result\\SmsMonitorAction.java",
                    clazzName = "SmsMonitorAction",
                    methods = {
                            @Method(action = "/monitor/smsMonitor/smsReachReport", result = "smsReachReport"),
                            @Method(action = "/monitor/smsMonitor/querySmsReachReport", json = true),
                            @Method(action = "/monitor/smsMonitor/querySmsRequestReport", json = true),
                            @Method(action = "/monitor/smsMonitor/exportSmsReachReport", excel = true),
                            @Method(action = "/monitor/smsMonitor/exportSmsReachReport", excel = true)
                    },
                    results = {
                            @Result(name = "smsReachReport", location = "/WEB-INF/content/monitor/sms/smsReachReport.jsp"),
                            @Result(name = "smsRequestReport", location = "/WEB-INF/content/monitor/sms/smsRequestReport.jsp")
                    }
            ),
        service = @Service ("ISmsMonitorService1"),
        Jsp = @Jsp (
                jspPath = "F:\\github\\practice\\util\\src\\main\\java\\result\\smsRequestReport.jsp",
                jspName = "smsRequestReport.jsp"
        )
)


public class Params {

    @Param(value = "邮箱", width=20)
    private String email;
    @Param(value = "手机号码", width=20)
    private String mobile;
    @Param(value = "认证名称", width=20)
    private String realname;
    @Param(value = "提交总数", width=20)
    private String commit_count;
    @Param(value = "提交成功总数", width=20)
    private String commit_success_count;
    @Param(value = "提交失败总数", width=20)
    private String commit_fail_count;
    @Param(value = "提交失败率", width=20)
    private String commit_fail_rate;
    @Param(value = "发送成功数量", width=20)
    private String send_success_count;
    @Param(value = "发送成功率", width=20)
    private String send_success_rate;
    @Param(value = "发送失败率", width=20)
    private String send_fail_count;


}
