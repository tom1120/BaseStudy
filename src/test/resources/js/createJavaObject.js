/*同样，为了方便，Nashorn默认提供了对几个Java包的访问，分别是：com、edu、java、javafx、javax和org*/
var HashMap = Java.type("java.util.HashMap");
var ss=Java.type("nashorn.TestNashorn");
var mapDef = new HashMap();
var map100 = new HashMap(100);

var result = ss.sayHello("Nashorn");
print(result);

var mapDef123 = new java.util.HashMap();
