package lesson03

class MyLinkedListKT<E> : Iterable<E>{

    private val first : Node<E> = Node()
    private var size : Int = 0

    fun add(value: E) {
        if (size != 0) {
            first.add(value)
            size++
        } else {
            first.value = value
            size++
        }
    }

    fun getByIndex(index: Int) : E? {

        if (checkIndex(index)) return null

        var result : E? = first.value
        val iterator = iterator()
        for (i in 0 until index) {
            result = iterator.next()
        }
        return result
    }

    fun getBackByIndex(index: Int) : E?{

        if (checkIndex(index)) return null

        var result : E? = null
        val iterator1 = iterator()
        val iterator2 = iterator()

        for (i in 0 until  index) {
            iterator1.next()
        }

        while (iterator1.hasNext()) {
            result = iterator2.next()
            iterator1.next()
        }

        return result
    }

    private fun checkIndex(index: Int): Boolean {
        if (index >= size || size == 0) {
            return true
        }
        return false
    }

    fun isEmpty() = size == 0


    override fun iterator(): Iterator<E> = MyIterator(first)

    inner class MyIterator<E>(var current: Node<E>) : Iterator<E> {

        override fun hasNext(): Boolean = current.hasNext()

        override fun next(): E {

            if (current.hasNext()) {
                current = current.next

            }
            return current.value
        }
    }


    fun printList() {
        if (isEmpty()) {
            println("Массив пустой")
        }
        println(first.value)
        val iterator = iterator()
        for (i in 0 until size - 1) {
            println(iterator.next())
        }
    }
}