/**
 * Created by Samer on 7/1/2018.
 */

import java.io.*
import java.util.*
import kotlin.system.measureNanoTime

data class Ops(
        val start: Int, val end: Int, val amount: Long)


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val arraySize = sc.nextInt()
    val opSize = sc.nextInt()

    val res = LongArray(arraySize)
    val input = Array(arraySize, { Ops(0, 0, 0) })

    for (it in 1..opSize) {
        val from = sc.nextInt() - 1
        val to = sc.nextInt() - 1
        val rawAmount = sc.nextLong()

        input[it - 1] = Ops(from, to, rawAmount)
    }

    val currentTimeMillis = System.currentTimeMillis()
//    input.sortBy { it.start }

    val sortedInput = input.sortedWith(compareBy({ it.start }, { it.end }))

    var max = 0L
    var holder: Ops? = null
    for (i in 1 until sortedInput.size) {
        val ops = sortedInput[i]
        val prev = sortedInput[i - 1]
        holder?.let {
            if (it.start < ops.start) {
                holder = null
            } else {
                max = maxOf(it.amount, ops.amount, max)
            }
        }

        if (prev.end < ops.start) {
            max = maxOf(prev.amount, ops.amount, max)
        } else {
            holder = Ops(ops.start, prev.end, ops.amount + prev.amount)
            max = maxOf(holder!!.amount, max)
        }


    }
    println(System.currentTimeMillis() - currentTimeMillis)



}

