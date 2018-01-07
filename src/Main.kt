import java.io.*
import java.util.*
/**
 * Created by Samer on 7/1/2018.
 */

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val arraySize = sc.nextInt()
    val opSize = sc.nextInt()

    val array = LongArray(arraySize)

    (1..opSize).forEach {
        val from = sc.nextInt() - 1
        val to = sc.nextInt() - 1
        val amout = sc.nextInt()

        (from..to).forEach {
            array[it] = array[it] + amout
        }

    }
    println(array.max())

}