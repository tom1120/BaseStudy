var list = new java.util.ArrayList();
list.add("a1");
list.add("a2");
list.add("a3");
list.add("b1");
list.add("b2");
list.add("b3");
list.add("c1");
list.add("c2");
list.add("c3");


list
    .stream()
    .filter(function(el) {
        return el.startsWith("a");
    })
    .sorted()
    .forEach(function(el) {
        print(el);
    });
// a1, a2, a3
