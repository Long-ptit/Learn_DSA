package Sort


fun main() {
    val array = intArrayOf(1, 2, 3, 5, 8, -5)
    println( bubbleSortDES(array).contentToString() )
}

fun bubbleSortASC(array: IntArray) : IntArray {
    val length = array.size
    var tempValue = 0

    for (index in 0 until length step 1) {
        for (indexSwap in 1 until length - index step 1) {
            if (array[indexSwap - 1] > array[indexSwap]) {
                tempValue = array[indexSwap - 1]
                array[indexSwap - 1] = array[indexSwap]
                array[indexSwap] = tempValue
            }
        }
        println(array[length - index - 1])
    }

    return array
}

fun bubbleSortDES(array: IntArray) : IntArray {
    val length = array.size
    var tempValue = 0

    for (index in length -1 downTo  0 step 1) {
        for (indexSwap in index downTo  1 step 1) {
            if (array[indexSwap - 1] < array[indexSwap]) {
                tempValue = array[indexSwap - 1]
                array[indexSwap - 1] = array[indexSwap]
                array[indexSwap] = tempValue
            }
        }
        println(array[length - index - 1])
    }

    return array
}