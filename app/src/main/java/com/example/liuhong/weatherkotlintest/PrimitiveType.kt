package com.example.liuhong.weatherkotlintest

/***
 * Created by liuhong on 2018/3/5.
 * Description:基本类型
 */
class PrimitiveType {

    //数字类型中不会自动转型
    val i: Int = 7
    val x: Double = i.toDouble()

    //字符不能直接作为一个数字来处理
    val z: Char = 'c'
    val k: Int = z.toInt()

    //位运算符号就是英文
    val m: Boolean = false
    val n: Boolean = true
    val bitwiseOr = m or n
    val bitwiseAnd = m and n

    //字面上可以写明具体的类型
    val j = 12
    val iHex = 0x3f
    val l = 3L
    val d = 3.5
    val f = 3.5F

    //一个string可以像数组那样访问并且被迭代
    val s = "Example"
    val c = s[2]
    fun test() {
        for (c in s) {
            print(c)
        }
    }


}