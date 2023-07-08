var SuperRunner = Java.type('nashorn.SupperRunner');
var Runner = Java.extend(SuperRunner);

var runner = new Runner() {
    run: function() {
        Java.super(runner).run();
        print('my run');
    }
}
runner.run();

// super run
// my run
