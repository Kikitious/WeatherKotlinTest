package com.example.liuhong.weatherkotlintest.operator

import android.util.Log

/***
 * Created by du on 2018/3/23.
 * Description:
 */
object OperatorExt {

    val list = listOf(1, 2, 3, 4, 5, 6)

    fun sumExt(): Unit {

        val any = list.any {
            //true
            it % 2 == 0
        }

        val all = list.all {
            //true
            it < 10
        }

        val count = list.count {
            //3
            it % 2 == 0
        }

        list.fold(4) { acc, i ->
            i
        }

        list.foldRight(4) { acc, i ->
            i
        }

        list.forEach {
            println(it)
        }

        list.forEachIndexed { index, value ->
            println("position $index contains a $value")
        }

        val max = list.max()

        val maxBy = list.maxBy { -it }

        val min = list.min()

        val minBy = list.minBy { -it }

        val none = list.none { it % 7 == 0 }

        list.reduce { acc, i ->
            i
        }

        list.reduceRight { i, acc ->
            i
        }

        val sumBy = list.sumBy { it % 2 }

    }

    fun dropExt(): Unit {
        val drop = list.drop(4)//5 6

        val dropWhile = list.dropWhile {
            // 3456
            it < 3
        }

        val dropLastWhile = list.dropLastWhile {
            it > 4
        }

        val filter = list.filter {
            //2 4 6
            it % 2 == 0
        }

        val filterNot = list.filterNot {
            //1 3 5
            it % 2 == 0
        }

        val filterNotNull = list.filterNotNull()//123456

        val slice = list.slice(listOf(1, 3, 4))//2 4 5

        val take = list.take(2)//1 2

        val takeLast = list.takeLast(2)//5 6

        val takeWhile = list.takeWhile {
            //1 2
            it < 3
        }

    }

    fun mapExt() {
        list.flatMap {
            listOf(it, it + 1, it + 2)
        }

        list.flatMap {
            arrayListOf(it)
        }

        list.groupBy {
            if (it % 2 == 0) {
                "even"
            } else {
                "odd"
            }
        }

        list.map {
            it * 2
        }

        list.mapIndexed { index, i ->
            index * i
        }

        list.mapNotNull {
            it * 2
        }

    }

    fun logi(tag: String = "MainActivity", result: String) {
        Log.i(tag, result)
    }

}