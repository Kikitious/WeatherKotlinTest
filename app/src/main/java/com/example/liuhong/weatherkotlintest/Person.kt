package com.example.liuhong.weatherkotlintest

/***
 * Created by liuhong on 2018/3/5.
 * Description: Person类
 */
class Person(name: String, surname: String) : Animal(name) {
    //当只有单个构造器时，需要在从父类继承下来的构造器中指定需要的参数，即java中的super

    var age: Int = 18

    var height: Int = 160
        get() {
            if (field < 0 || field > 250)
                return 160
            else
                return field
        }
        set(value) {
            field = 5 + value
        }

    init {
        //构造函数的函数体
    }

}