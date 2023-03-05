package me.kzv.datastructure.myarray.test

fun main(){
    intArrayList()
}

fun intArrayList(){
    val numbers = ArrayList<Int>()

    numbers.add(10)
    numbers.add(20)
    numbers.add(30)
    numbers.add(40)
    println("add(값)")
    println(numbers)

    //add(값)
    //[10, 20, 30, 40]
    //
    //add(인텍스, 값)
    //[10, 50, 20, 30, 40] <- 20을 한칸 밀어내고 그 사이에 값을 넣었다.

    numbers.add(1, 50)
    println("\nadd(인텍스, 값)")
    println(numbers)

    val it = numbers.iterator()
    while (it.hasNext()) {
        println(it.next())
    }

    for ((index, number) in numbers.withIndex()) {
        println("index: $index number: $number")
    }
    
}

