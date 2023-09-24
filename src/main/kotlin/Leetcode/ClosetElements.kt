package Leetcode

import java.util.*
import kotlin.math.abs

fun main() {
    val array = intArrayOf(1,1,1,10,10,10)

    println(findClosestElements(array, 1, 9))
}

data class Entry(val key: Int,val value: Int)

fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    val index = binarySort(arr, x)
    println(index)
    var low = Math.max(index - k, 0)
    var high = Math.min(arr.size - 1, index + k)

    val queue = PriorityQueue<Entry>() {
            p1, p2 ->
        if (p1.key == p2.key) return@PriorityQueue p1.value - p2.value

        return@PriorityQueue p1.key - p2.key

    }

    for (index in low until high + 1  step 1) {
        queue.add(Entry(abs( arr[index] - x), index))
    }
    val list = mutableListOf<Int>()
    repeat(k) {
        list.add(arr[queue.poll().value])
    }
    list.sort()
    return list
}

fun binarySort(array: IntArray, target: Int) : Int {
    var low = 0;
    var high = array.size - 1;
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (array[mid] == target) return mid;
        if (array[mid] < target) low = mid + 1
        else high = mid - 1
    }

    // maybe return -1 if not present
    if (low > 0) return low - 1
    return low
}