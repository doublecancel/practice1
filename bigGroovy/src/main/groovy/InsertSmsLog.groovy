import org.jooq.SQLDialect
import org.jooq.impl.DSL

import java.sql.Connection
import java.sql.DriverManager
import java.util.concurrent.ThreadLocalRandom
/**
 * Created by Administrator on 2017/11/27.
 */
class InsertSmsLog {


    static main(args){
        def list = new InsertSmsLog().queryTemplate()


        new InsertSmsLog().insertlog("ucpaas_statistics.tb_sms_log_20171128", list)
        new InsertSmsLog().insertlog("ucpaas_statistics.tb_sms_log_20171126", list)
        new InsertSmsLog().insertlog("ucpaas_statistics.tb_sms_log_20171125", list)
        new InsertSmsLog().insertlog("ucpaas_statistics.tb_sms_log_20171124", list)
        new InsertSmsLog().insertlog("ucpaas_statistics.tb_sms_log_20171123", list)
        new InsertSmsLog().insertlog("ucpaas_statistics.tb_sms_log_20171122", list)
        new InsertSmsLog().insertlog("ucpaas_statistics.tb_sms_log_20171129", list)
        new InsertSmsLog().insertlog("ucpaas_statistics.tb_sms_log_20171127", list)


//        new InsertSmsLog().destory()

    }

    def insertlog(String tableName, List<String> list){
        def list1 = (108756 .. 209626).collect {it + ""}
        def context = getContext()
        (1 .. 10000).each {a ->
            def template_id = list1.get(getNumber(list1.size()))
            def status = getNumber(4)
//            def domain = new SmsLog(template_id, status)

            context.insertInto(DSL.table(tableName),
                    DSL.field("status"),
                    DSL.field("update_time"),
                    DSL.field("start_time"),
                    DSL.field("smsp_code"),
                    DSL.field("to_number"),
                    DSL.field("template_id")
            )
                    .values(status, getTime1(), getTime2(), getCode(), getMobile(), template_id)
                    .execute()

        }

        println "插入表${tableName}:1000"

    }

    def getMobile(){
        def list = [
                "13120971538",
                "13120971539",
                "13120971530",
                "13120971531",
                "13120971532",
                "13120971533",
                "13120971534",
                "13120971535",
                "13120971536",
                "13120971516",
                "13120971526",
                "13120971576",
                "13120971546",
                "13120971556",
                "13120971566",
        ]
        return getNumber(Integer.MAX_VALUE)
    }


    def getCode (){
        def list = [
                "CJ:0006",
                "E:ODML",
                "E:RPTSD",
                "HD:31",
                "HD:34",
                "5",
                "10",
                "90",
                "107",
                "115",
                "124",
                "182",
                "CJ:0005",
                "DB:0107",
        ]
        return list.get(getNumber(list.size()))
    }

    def destory(){
        (20171120 .. 20171128).each {a ->
            println "ucpaas_statistics.tb_sms_log_${a}"
            def i = getContext().delete(DSL.table("ucpaas_statistics.tb_sms_log_${a}"))
                    .where("1 = 1")
                    .execute()

            println i
        }

    }

    def getTime1 (){
        def arr = [
                '2017-11-28 09:00:00',
                '2017-11-28 08:00:00',
                '2017-11-28 07:00:00',
                '2017-11-28 06:00:00',
                '2017-11-28 05:00:00',
                '2017-11-28 04:00:00',
                '2017-11-28 03:00:00',
                '2017-11-28 02:00:00',
                '2017-11-28 01:00:00',
                '2017-11-27 09:00:00',
                '2017-11-27 09:00:00',
                '2017-11-27 09:00:00',
                '2017-11-24 09:00:00',
                '2017-11-24 09:00:00',
        ]
        return arr.get(getNumber(arr.size()))
    }

    def getTime2 (){
        def arr = [
                '2017-11-26 09:00:00',
                '2017-11-26 08:00:00',
                '2017-11-26 07:00:00',
                '2017-11-26 06:00:00',
                '2017-11-27 05:00:00',
                '2017-11-27 04:00:00',
                '2017-11-27 03:00:00',
                '2017-11-27 02:00:00',
                '2017-11-27 01:00:00',
                '2017-11-28 09:00:00',
                '2017-11-24 09:00:00',
                '2017-11-23 09:00:00',
                '2017-11-22 09:00:00',
                '2017-11-23 09:00:00',
        ]
        return arr.get(getNumber(arr.size()))
    }

    def getNumber(int bounds){
       return ThreadLocalRandom.current().nextInt(bounds)
    }


    //tb_srv_sms_template

    def queryTemplate (){


        def result =  getContext().select(DSL.field("template_id"))
        .from(DSL.table("tb_srv_sms_template"))
        .orderBy(DSL.field("create_date").desc())
        .limit(0, 1000).fetch()

        def list = result.getValues("template_id")

        println list

        return list

    }







    static Connection connection = DriverManager.getConnection(
            "jdbc:mysql://172.16.5.34:3306/ucpaas?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
            "root",
            "123456")


    def getContext(){
        return DSL.using(connection, SQLDialect.MYSQL)
    }
}

class SmsLog {
    String template_id
    Integer status

    SmsLog(String template_id, Integer status) {
        this.template_id = template_id
        this.status = status
    }
}







