package nashorn;

import com.kito.jvm.Person;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.junit.jupiter.api.Test;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * 命令行脚本
 * 如果你对编写命令行（shell）脚本感兴趣，来试一试Nake吧。Nake是一个Java 8 Nashron的简化构建工具。你只需要在项目特定的Nakefile中定义任务，之后通过在命令行键入nake -- myTask来执行这些任务。任务编写为JavaScript，并且在Nashron的脚本模式下运行，所以你可以使用你的终端、JDK8 API和任意Java库的全部功能。
 * @author zhaoyipc
 * @company QLONG
 * @date 2023-03-06 13:17
 */
public class TestNashorn {
    @Test
    void testNashorn() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello World!');");
    }

    @Test
    void testNashornFile() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/hello.js"));
    }

    @Test
    void compileJs() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        CompiledScript compiledScript = ((Compilable) engine).compile("print('Hello World!');");
        compiledScript.eval();
    }

    @Test
    void bindVar() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Bindings bindings = engine.createBindings();
        bindings.put("name", "Nashorn");
        engine.eval("print('Hello ' + name);", bindings);
    }

    @Test
    void testJs() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/test.js"));

        Invocable invocable = (Invocable) engine;

        Object result = invocable.invokeFunction("fun1", "Nashorn");
        System.out.println(result);
        System.out.println(result.getClass());
    }

    @Test
    void testJs2() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/test.js"));
        Invocable invocable = (Invocable) engine;
        invocable.invokeFunction("fun2", new Date());
// [object java.util.Date]

        invocable.invokeFunction("fun2", LocalDateTime.now());
// [object java.time.LocalDateTime]

        invocable.invokeFunction("fun2", new Person());
// [object my.package.Person]
    }

    public static String sayHello(String name) {
        System.out.println("Hello " + name);
        return "Hi!";
    }


    @Test
    void testJsCallJavaStatic() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/callStatic.js"));
    }

    public static void fun(Object obj) {
        System.out.println(obj.getClass());
    }

    @Test
    void testNashornTypeConvert() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/testNashornTypeConvert.js"));
    }

    @Test
    void testJsCreateJavaObject() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/createJavaObject.js"));
    }

    @Test
    void testJsArrayTest() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/arrayTest.js"));
    }


    @Test
    void testJsForeachTest() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/foreachTest.js"));
    }

    @Test
    void testJsFunctionTest() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/functionTest.js"));
    }

     @Test
    void testJsPrototypeSet() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/prototypeSet.js"));
    }


    @Test
    void testJsLambda() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/lambda.js"));
    }

    @Test
    void testJsMultiThread() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/multiThread.js"));
    }


    @Test
    void testJsfunctionReload() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/functionReload.js"));
    }

    @Test
    void testJsJavabean() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/javabean.js"));
    }

    @Test
    void testJsPropertyBind() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/propertyBind.js"));
    }

    @Test
    void testJsStringextAndCurrentFile() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/stringext.js"));
    }

    @Test
    void testJsImportWith() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/importWith.js"));
    }



    @Test
    void testJsJavaListToJsArray() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/javaListToJsArray.js"));
    }


    @Test
    void testJsSuperRunner() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/superRunner.js"));
    }

    @Test
    void testJsNoSuchPropertyAndNoSuchMethod() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/noSuchPropertyAndNoSuchMethod.js"));
    }

    @Test
    void testJsJsonCompatible() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        // jdk 版本有关，不支持asJSONCompatible
        Object obj = engine.eval("Java.asJSONCompatible({ number: 42,greet:'hello',primes:[2,3,5,7,11,13]})");
        Map<String, Object> map = (Map<String, Object>)obj;

        System.out.println(map.get("greet"));
        System.out.println(map.get("primes"));
        System.out.println(List.class.isAssignableFrom(map.get("primes").getClass()));
    }

    @Test
    void testJsInnerHello() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Object obj = engine.eval("Java.asJSON({value:1})");
    }


    @Test
    void testJsLoadJs() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/loadJs.js"));
    }


    public static void fun1(ScriptObjectMirror mirror) {
        System.out.println(mirror.getClassName() + ": " +
                Arrays.toString(mirror.getOwnKeys(true)));
    }

    @Test
    void testJsScriptObjectMirror() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/scriptObjectMirror.js"));
    }

    public static void fun2(ScriptObjectMirror person) {
        System.out.println("Full Name is: " + person.callMember("getFullName"));
    }
    @Test
    void testJsPerson() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/jsPerson.js"));
    }


    @Test
    void testJsonStringify() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(getClass().getResource("/").getPath() + "js/json_stringify.js"));
    }






















}
