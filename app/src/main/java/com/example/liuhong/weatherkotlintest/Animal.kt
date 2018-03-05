package com.example.liuhong.weatherkotlintest

/***
 * Created by liuhong on 2018/3/5.
 * Description: Animal类，此处用来派生Person类
 */
open class Animal(name: String)
//默认任何类都继承自Any
//默认所有的类都是final，不可继承
//只能继承明确声明为open活着abstract的类