package datastructure

fun main(){
    val list = MyArrayList()
    for (i in 1..10 step (1)) {
        list.addLast("코틀린$i")
    }

    list.addMiddle(0,1541)
    println(list.toString())
    list.remove(0)
    println(list.toString())
    println(list.size)

    println(list.indexOf("코틀린1")) // 요소의 값으로 찾고자하는 요소의 인덱스 호출
    println(list.get(0)) // 인덱스로 찾고자하는 요소의 값 호출
}