/*下面的代码将Java的List转换为JavaScript原生数组：*/
var javaList = new java.util.ArrayList();
javaList.add("1");
javaList.add("2");
javaList.add("3");
var jsArray = Java.from(javaList);
print(jsArray);                                  // 1, 2, 3
print(Object.prototype.toString.call(jsArray));  // [object Array]
/*下面的代码将JavaScript原生数组转换为Java的List：*/
var javaArray = Java.to([3, 5, 7, 11], "int[]");


