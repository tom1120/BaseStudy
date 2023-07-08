function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.getFullName = function() {
        return this.firstName + " " + this.lastName;
    }
}

var person = new Person("Peter", "Parker");
var MyJavaClass=Java.type("nashorn.TestNashorn");
MyJavaClass.fun2(person);
