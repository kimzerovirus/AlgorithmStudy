package me.kzv.datastructure

class MyArrayList {
    var size = 0 // 현재 요소의 개수 ... 인덱스와 맞추려면 -1을 해줘야 한다!! - size는 다른곳에서도 사용하므로 public으로
    private var capacity = 10 // 현재 수용 가능한 최대 용량
    private var elementData = arrayOfNulls<Any>(capacity) // default 10

    fun addFirst(element: Any): Boolean = addMiddle(0, element)

    fun addMiddle(index: Int, element: Any): Boolean {
        // 마지막 인덱스(총 개수 - 1) ~ 삽입할 위치 인덱스 까지 인덱스 번호를 1씩 뒤로 미룬다.
        for (i in size - 1 downTo index) {
            elementData[i + 1] = elementData[i]
        }
        elementData[index] = element
        size++

        resize()
        return true
    }

    fun addLast(element: Any): Boolean {
        elementData[size] = element
        size++

        resize()
        return true
    }

    // TODO 수정
    fun set(index: Int, element: Any): Boolean {
        elementData[index] = element

        return true
    }

    // TODO 제거
    fun remove(index: Int): Boolean {
        for (i in index + 1 until size step (1)) { // < until
            elementData[i - 1] = elementData[i]
        }
        elementData[size - 1] = null
        size--

        resize()
        return true
    }

    // TODO 찾고자하는 요소의 위치(인덱스) 반환
    fun indexOf(element: Any): Int {
        for ((idx, el) in elementData.withIndex()) {
            if (el == element) return idx
        }

        return -1 // 찾는 값이 없으면 -1 반환
    }

    // TODO 인덱스 -> 값
    fun get(index: Int): Any {
        if (index < 0 || index > size - 1) {
            throw IndexOutOfBoundsException()
        }

        return elementData[index]!!
    }

    fun listIterator() = MyListIterator(elementData, size)

    /**
     *  만약 데이터는 적은데 배열의 수용용량은 엄청 크면 메모리가 낭비되고,
     *  반대로 최대 용량은 적은데 더 많은 데이터를 넣으려고 한다면 에러가 발생할 것이다.
     *  따라서 데이터에 개수에 따라 최적화된 용량을 갖추게 하는 메서드를 구현한다.
     */
    private fun resize() {
        when {
            size == elementData.size -> {
                // 최대 수용 용량을 넘기면 총 용량을 1.5배로 늘려준다.
                capacity = (capacity * 1.5).toInt()
                elementData = elementData.copyOf(capacity)
            }

            size < (capacity / 1.5) && (capacity / 1.5) > 10 -> {
                // 최대 수용 용량의 1.5배 보다 작아지면 사이즈를 줄인다.
                // 수용 용량은 default 값인 10보다 작아질 수 없다.
                capacity = (capacity / 1.5).toInt()
                elementData = elementData.copyOf(capacity)
            }
//            else -> return
        }
    }

    override fun toString(): String {
        var str = "["

        for ((index, element) in elementData.withIndex()) {
            if (element != null) {
                str += element
                if (index != size - 1) str += ", "
            }
        }

        return "$str]"
    }
}

class MyListIterator(
    private val elementData: Array<Any?>,
    private val size: Int
) {
    private var currentIndex = 0

    fun hasNext() = currentIndex < size

    fun next() = elementData[currentIndex++]

    fun hasPrev() = currentIndex > 0

    fun prev() = elementData[--currentIndex]
}