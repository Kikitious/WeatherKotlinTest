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
        val flatMap = list.flatMap {
            listOf(it, it + 1, it + 2)
        }//ArrayList {1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6, 5, 6, 7, 6, 7,8}

        val flatMap1 = list.flatMap {
            arrayListOf(it)
        }//ArrayList {1, 2, 3, 4, 5, 6}

        val groupBy = list.groupBy {
            if (it % 2 == 0) {
                "even"
            } else {
                "odd"
            }
        } //LinkedHashMap   mapof("odd" to listof(1, 3, 5), "even" to listof(2, 4, 6))

        val map = list.map {
            it * 2
        }//ArrayList {2, 4, 6, 8, 10, 12}

        val mapIndexed = list.mapIndexed { index, i ->
            index * i
        }//ArrayList {0, 2, 6, 12, 20, 30}

        val mapNotNull = list.mapNotNull {
            it * 2
        }

    }

    fun elementExt() {
        val contains = list.contains(2)//true

        val elementAt = list.elementAt(4)//5

        val elementAtOrElse = list.elementAtOrElse(6) { it * 2 }//12

        val elementAtOrNull = list.elementAtOrNull(6)//null

        val first = list.first()//1

        val first1 = list.first { it % 2 == 0 }//2

        val firstOrNull = list.firstOrNull { it % 7 == 0 }// null

        val indexOf = list.indexOf(4)//3

        val i = list[4]//5

        val indexOfFirst = list.indexOfFirst { it % 2 == 0 }//1

        val indexOfLast = list.indexOfLast { it % 2 == 0 }//5

        val last = list.last()//6

        val last1 = list.last { it % 2 == 0 }//6

        val lastIndexOf = list.lastIndexOf(5)//4

        val lastOrNull = list.lastOrNull { it % 7 == 0 }//null

        val single = list.single { it % 5 == 0 }//5
        //val single1 = list.single { it % 2 == 0 }//抛出异常

        val singleOrNull = list.singleOrNull { it % 2 == 0 }//null
        val singleOrNull1 = list.singleOrNull { it % 5 == 0 }//5
    }

    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)

    fun produce() {
        val union = list.union(listRepeated)//LinkedHashSet<Integer> 1, 2, 3, 4, 5, 6

        val zip = list.zip(listRepeated)//ArrayList<Pair> (1,2) (2,2) (3,3) (4,4) (5,5) (6,5)

        val zip1 = list.zip(listRepeated, { a, b ->
            a + b
        })//ArrayList<Integer> 3, 4, 6, 8, 10, 11

        val unzip = listOf(Pair(5, 7), Pair(1, 2)).unzip()//Pair  ([5, 1], [7, 2])

        val plus = list.plus(listOf(7, 8))//ArrayList 1 2 3 4 5 6 7 8

        val partition = list.partition { it % 2 == 0 }//Pair ([2, 4, 6], [1, 3, 5])
    }

    val unSortedList = listOf(9, 4, 5, 7)

    fun orderExt() {
        val reversed = unSortedList.reversed()//ArrayList<Integer> 7 5 4 9
        val asReversed = unSortedList.asReversed()//ReversedListReadOnly<Integer> 7 5 4 9

        val sorted = unSortedList.sorted()//4 5 7 9
        val sortedBy = unSortedList.sortedBy { it % 3 }//9 4 7 5
        val sortedDescending = unSortedList.sortedDescending()// 9 7 5 4
        val sortedByDescending = unSortedList.sortedByDescending { it % 3 }// 5 4 7 9
    }

    fun logi(tag: String = "MainActivity", result: String) {
        Log.i(tag, result)
    }

}