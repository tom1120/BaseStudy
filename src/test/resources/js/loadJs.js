/*脚本引擎中载入其他JavaScript文件：*/
load('classpath:js/hello.js');
/*通过URL载入脚本：*/
// load('./hello.js');

/*请记住，JavaScript没有命名空间的概念，所以所有的内容都堆放在全局环境中。这使得加载的脚本有可能与你的代码或它们之间的命名冲突。这可以使用loadWithNewGlobal函数尽可能减少这种情况的发生：*/

var math = loadWithNewGlobal('classpath:js/math_module.js')
math.increment(5);
