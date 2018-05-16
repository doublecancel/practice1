import org.jooq.SQLDialect
import org.jooq.impl.DSL

import java.sql.Connection
import java.sql.DriverManager
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by Administrator on 2017/11/29.
 */
class InsertTemplate {


    static main(args){
        def list = new InsertTemplate().queryAppid()
        (1 .. 40000).each {
            new InsertTemplate().insertTemplate(it)
        }

    }

    def insertTemplate(int a){
        getContext().insertInto(DSL.table("tb_srv_sms_template"),
                DSL.field("app_sid"),
                DSL.field("name"),
                DSL.field("content"),
                DSL.field("status"),
                DSL.field("create_date"),
                DSL.field("type"),
                DSL.field("sign"),
                DSL.field("is_report")

        )
        .values(
                "df814c97be794306b57daf2c7686a3d1",
                "测试模板" + a,
                "测试模板内容{}，测试模板内容{}",
                "2",
                "2017-11-29 10:56:59",
                "4",
                "测试模板签名",
                "1"
        ).execute()

        println a

    }

    def getAppid(List<String> list){
        return list.get(ThreadLocalRandom.current().nextInt(list.size()))
    }

    def queryAppid(){
        def result = getContext().select(DSL.field("app_sid"))
        .from(DSL.table("tb_ucpaas_application"))
        .limit(1000).fetch()
        return result.getValues("app_sid")
    }

    static Connection connection = DriverManager.getConnection(
            "jdbc:mysql://172.16.5.34:3306/ucpaas?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
            "root",
            "123456")


    def getContext(){
        return DSL.using(connection, SQLDialect.MYSQL)
    }



}
