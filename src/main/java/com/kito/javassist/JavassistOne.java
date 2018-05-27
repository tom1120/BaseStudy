package com.kito.javassist;/**
 * Created by hasee on 2017/5/17.
 */

import com.kito.aop.Business;
import javassist.*;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/17-22:27
 */
public class JavassistOne {
    public static void main(String[] args) {
        //获取存放CtClass的容器
        ClassPool cp = ClassPool.getDefault();
        //创建一个类加载器
        Loader cl = new Loader();
        //增加一个转换器
        try {
            cl.addTranslator(cp, new MyTranslator());
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
        //启动MyTranslator的main函数
        try {
            cl.run("com.kito.javassist.JavassistOne$MyTranslator", args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static class MyTranslator implements Translator {
        public void start(ClassPool pool) throws NotFoundException, CannotCompileException {
        }


        /* * * 类装载到JVM前进行代码织入 */
        public void onLoad(ClassPool pool, String classname) {
            if (!"com.kito.aop.Business".equals(classname)) {
                return;
            }
            //通过获取类文件
            try {
                CtClass cc = pool.get(classname);
                //获得指定方法名的方法
                CtMethod m = cc.getDeclaredMethod("doSomeThing");
                //在方法执行前插入代码
                m.insertBefore("{ System.out.println(\"记录日志\"); }");
            } catch (NotFoundException e) {

            } catch (CannotCompileException e) {

            }
        }

        public static void main(String[] args) {
            Business b = new Business();
            b.doSomeThing2();
            b.doSomeThing();
        }
    }

}



