function increment(i) ++i;
try {
    throw "BOOM";
} catch(e if typeof e === 'string') {
    print("String thrown: " + e);
} catch(e) {
    print("this shouldn't happen!");
}
