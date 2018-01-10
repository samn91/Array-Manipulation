/**
 * Created by Samer on 7/1/2018.
 */

import java.io.*
import java.util.*


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    val output = LongArray(n)
    (1..m).forEach {
        val a = scanner.nextInt() - 1
        val b = scanner.nextInt()
        val k = scanner.nextInt()
        output[a] += k.toLong()
        if (b < n) output[b] -= k.toLong()
    }
    var sum = 0L
    var max = 0L
    for (i in 0 until n) {
        sum += output[i]
        if (sum > max) max = sum
    }
    println(max)
    scanner.close()
}

