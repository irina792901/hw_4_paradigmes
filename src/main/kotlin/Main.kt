import kotlin.math.roundToInt
import kotlin.math.sqrt

/*
Скрипт вычисляет корреляцию Пирсона между двумя массивами
данных `x` и `y`:
 */

fun main() {
    // Пример данных
    val x = doubleArrayOf(1.5, 2.0, 3.8, 4.2, 5.6, 0.1)
    val y = doubleArrayOf(2.8, 3.1, 2.8, 5.4, 7.2, 2.2)

    val correlation = calculatePearsonCorrelation(x, y)
    println("Корреляция Пирсона: $correlation")
}

fun calculatePearsonCorrelation(x: DoubleArray, y: DoubleArray): Double {
    if (x.size != y.size) {
        throw IllegalArgumentException("Массивы должны иметь одинаковую длину")
    }

    val n = x.size
    val mx = x.average() // среднее арифметическое массива
    val my = y.average()
    val numerator: Double = (0..<n).sumOf { (x[it] - mx) * (y[it] - my) } //числитель
    val tempDenominator1 = (0..<n).sumOf { (x[it] - mx) * (x[it] - mx) }
    val tempDenominator2 = (0..<n).sumOf { (y[it] - my) * (y[it] - my) }
    if (tempDenominator1 == 0.0 || tempDenominator2 == 0.0) {
        return 0.0 // Защита от деления на ноль
    }
    val denominator = sqrt(tempDenominator1*tempDenominator2)
    return (numerator / denominator )
}


