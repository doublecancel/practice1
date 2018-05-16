package TestSome

import javax.script.Bindings
import javax.script.Invocable
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

/**
 * Created by Administrator on 2017/11/22.
 */
class Test2 {

    static main(args) {

        def t = new Test2()
        def range = 1..20
//        range.each {
//            TimeUnit.SECONDS.sleep(1)
//            t.test1()
//        }

        t.test3()


    }

    def test1() {
        def path = "F:\\github\\practice\\bigGroovy\\src\\main\\groovy\\TestSome"
        GroovyScriptEngine engine = new GroovyScriptEngine(path)

        Binding binding = new Binding()
        binding.setVariable("input", "world")

        engine.run("Script.groovy", binding)

        println "${binding.getVariable("output")}"

    }

    def test2() {
        def path = "F:\\github\\practice\\bigGroovy\\src\\main\\groovy\\scripts"
        GroovyScriptEngine engine = new GroovyScriptEngine(path)


        GroovyObject script1 = engine.loadScriptByName("Script1.groovy").newInstance()
        GroovyObject script2 = engine.loadScriptByName("Script2.groovy").newInstance()
        GroovyObject script3 = engine.loadScriptByName("Script3.groovy").newInstance()


        String result = (String) script1.invokeMethod("output", "刘")
        String result1 = (String) script2.invokeMethod("output", "刘")
        String result2 = (String) script3.invokeMethod("output", "刘")

        println "${result}, ${result1}, ${result2}"


    }

    def test3() {

        ScriptEngineManager factory = new ScriptEngineManager()

        //每次生成一个engine实例
        ScriptEngine engine = factory.getEngineByName("groovy")
        Bindings binding = engine.createBindings()
        binding.put("date", new Date())

        //如果script文本来自文件,请首先获取文件内容
        engine.eval("def getTime(){return date.getTime();}", binding)
        engine.eval("def sayHello(name,age){return 'Hello,I am ' + name + ',age' + age;}")
        Long time = (Long) ((Invocable) engine).invokeFunction("getTime", null)
        System.out.println(time)
        String message = (String) ((Invocable) engine).invokeFunction("sayHello", "zhangsan", new Integer(12))
        System.out.println(message);
    }

}
