var MyJavaClass = Java.type("nashorn.TestNashorn");
MyJavaClass.fun(127);
// class java.lang.Integer

MyJavaClass.fun(49.99);
// class java.lang.Double

MyJavaClass.fun(true);
// class java.lang.Boolean

MyJavaClass.fun("Hi!");
// class java.lang.String

MyJavaClass.fun(new Number(127));
// class jdk.nashorn.internal.objects.NativeNumber

MyJavaClass.fun(new Date());
// class jdk.nashorn.internal.objects.NativeDate

MyJavaClass.fun(new RegExp());
// class jdk.nashorn.internal.objects.NativeRegExp

MyJavaClass.fun({foo: 'bar'});
// class jdk.nashorn.internal.scripts.JO4
