package Sort

fun main() {
    val array = intArrayOf(2, 4, 5, 6, 9)
    println(binarySort(array, 10))
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
    return low
}