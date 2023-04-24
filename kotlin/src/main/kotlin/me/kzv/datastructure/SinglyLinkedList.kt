package me.kzv.datastructure

class Node(
    val data: Int,
    var next: Node? = null
) {
    fun append(data: Int) {
        val end = Node(data)
        var node = this
        while (node.next != null) {
            node = node.next!!
        }
        node.next = end
    }

    fun delete(data: Int) {
        var node = this
        while (node.next != null) {
            if (node.next!!.data == data) {
                node.next = node.next!!.next
            } else {
                node = node.next!!
            }
        }
    }

    fun retrieve() {
        var node = this
        while (node.next != null) {
            print(node.data.toString() + " -> ")
            node = node.next!!
        }
        println(node.data)
    }
}

fun main() {
    val head = Node(1)
    head.append(2)
    head.append(3)
    head.append(4)
    head.append(5)
    head.retrieve()
    head.delete(2)
    head.delete(3)
    head.retrieve()
}