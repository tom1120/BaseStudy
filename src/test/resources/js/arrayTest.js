/*int[]数组就像真实的Java整数数组那样。但在试图向数组添加非整数时，Nashron执行了一些隐式的转换。字符串会自动转换为整数，这十分便利。*/
var IntArray=Java.type("int[]");
var array=new IntArray(5);
array[0]=5;
array[1]=4;
array[2]=3;
array[3]=2;
array[4]=1;

try{
    array[5]=23;
}catch (e){
    print(e.message); // Array index out of range: 5
}

array[0]="17";
print(array[0]);//17

array[0] = "wrong type";
print(array[0]);  // 0

array[0] = "17.3";
print(array[0]);  // 17
