package lesson03

import java.util.function.BiFunction

fun main(args: Array<String>) {

    //1 Сортировка вставкой (сложность O(n^2))
    var arr = mutableListOf(3, 1, 5, 2, 8, 4)
    val sortInsert = SortInsert(arr)
    println(sortInsert.sort(BiFunction{ t, u -> t > u }))

    //2 Числа Фибоначчи до номера (сложность O(n))
    val fibSequence = FibSequence()
    println(fibSequence.forNumber(10))

    //3 Двунаправленный список
    val list = MyLinkedListKT<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    list.add(6)
    list.add(7)

    list.printList()
    println("Значение по индексу : ${list.getByIndex(3)}")
    println("Значение по сконца : ${list.getBackByIndex(0)}")

}






