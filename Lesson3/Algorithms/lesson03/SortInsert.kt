package lesson03

import java.util.function.BiFunction

class SortInsert(var arr: MutableList<Int>){

    fun sort(compare: BiFunction<Int, Int, Boolean>) : MutableList<Int> {

        for (i in 1 until arr.size step 1) {
            for (j in i downTo 1 step 1) {

                if (compare.apply(arr[j], arr[j - 1])) {
                    change(j, j-1)
                } else break
            }
        }
        return arr
    }

    private fun change(index1: Int, index2: Int) {
        val temp = arr[index1]
        arr[index1] = arr[index2]
        arr[index2] = temp
    }
}