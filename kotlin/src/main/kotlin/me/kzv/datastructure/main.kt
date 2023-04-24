package me.kzv.datastructure

import me.kzv.datastructure.myarray.MyArrayList
import me.kzv.datastructure.myarray.MyListIterator

fun main() {
    myArrayListTest()
}

fun myArrayListTest(){
    val list = MyArrayList()
    for (i in 1..10 step (1)) {
        list.addLast("코틀린$i")
    }

    list.addMiddle(0, 1541)
    println(list.toString())
    list.remove(0)
    println(list.toString())

    println("\n")

    println(list.size)
    println(list.indexOf("코틀린1")) // 요소의 값으로 찾고자하는 요소의 인덱스 호출
    println(list.get(0)) // 인덱스로 찾고자하는 요소의 값 호출

    // Iterator
    val li: MyListIterator = list.listIterator()
    while (li.hasNext()) {
        print(li.next())
    }

    println("\n")

    while(li.hasPrev()){
        print(li.prev())
    }
}