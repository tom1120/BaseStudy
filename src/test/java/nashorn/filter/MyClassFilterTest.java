package nashorn.filter;

import jdk.nashorn.api.scripting.ClassFilter;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;

/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2023-03-08 12:59
 */
public class MyClassFilterTest {

    class MyCF implements ClassFilter { // 创建类过滤器
        @Override
        public boolean exposeToScripts(String s) {
            if (s.equals("java.io.File")) {
                return false;
            }
            return true;
        }
    }

    public void testClassFilter() {

        final String script =
                "print(java.lang.System.getProperty(\"java.home\"));" +
                        "print(\"Create file variable\");" +
                        "var File = Java.type(\"java.io.File\");";

        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();

        ScriptEngine engine = factory.getScriptEngine(new MyClassFilterTest.MyCF());

        try {
            engine.eval(script);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }
    }

    public static void main(String[] args) {
        MyClassFilterTest myApp = new MyClassFilterTest();
        myApp.testClassFilter();
    }
}
