/**
 * Created by Samer on 7/1/2018.
 */

import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val arraySize = sc.nextInt()
    val opSize = sc.nextInt()

    val res = LongArray(arraySize)
    val ranges = mutableListOf<Pair<IntRange, Long>>()

    (1..opSize).forEach {
        val from = sc.nextInt() - 1
        val to = sc.nextInt() - 1
        val rawAmount = sc.nextLong()
        ranges.add(Pair((from..to), rawAmount))
    }

    (1..opSize).forEach {
        val from = sc.nextInt() - 1
        val to = sc.nextInt() - 1
        val rawAmount = sc.nextLong()

        var included = false
        ranges.forEach {
            var (range, amont) =it
            if (from in range && to in range) {
                //included
                (range.start..from)
                (to..range.last)
                (from..range.last)

            } else if (from in range || to in range) {
                included = true
                if (from in range) {
                    //included
                } else {//to in range

                }
            }
        }
        if (!included) {
            ranges.add(Pair((from..to), rawAmount))
        }
    }

    println(res.max())

}