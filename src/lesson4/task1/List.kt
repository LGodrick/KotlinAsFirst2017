@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant
import lesson3.task1.minDivisor
import java.lang.Math.pow

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) = when {
    y < 0 -> listOf()
    y == 0.0 -> listOf(0.0)
    else -> {
        val root = Math.sqrt(y)
        // Результат!
        listOf(-root, root)
    }
}

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    return if (list.isEmpty()) {
        0.0
    } else list.sum() / list.size
}


/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val medium = mean(list)
    for (i in 0 until list.size) {
        list[i] = list[i] - medium
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
val k = 0.until(a.size).sumByDouble { a[it] * b[it] }
return k
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
var k = 1.0
var s = 0.0
for (i in 0.until(p.size)) {
    s += k * p[i]
    k *= x
}
return s
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
for (i in 1 until list.size) list[i] += list[i - 1]
return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
val divisors = mutableListOf<Int>()
var n1 = n
while (n1 != 1) {
    val div = minDivisor(n1)
    divisors.add(div)
    n1 /= div
}
return divisors
}


/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString("*")


val figure = "0123456789abcdefghijklmnopqrstuvwxyz"

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
val result = mutableListOf<Int>()
val number = base
var number2 = n
while (number2 > 0) {
    result += number2 % number
    number2 /= number
}
return result.reversed()
}


/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
val list = convert(n, base)
val res = mutableListOf<Char>()
if (n == 0) {
    return "0"
} else {
    for (e in list) {
        when {
            e <= 9 -> res.add('0' + e)
            else -> res.add('a' + e - 10)
        }
    }
    return res.joinToString("")
}
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
var num = 0.0
var degree = pow(base.toDouble(), digits.size - 1.0)
for (i in 0 until digits.size) {
    num += digits[i] * degree
    degree /= base
}
return num.toInt()
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
val arabicSym = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
val romanSym = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
var str = ""
var k = n
for (i in 0 until arabicSym.size) {
    while (k >= arabicSym[i]) {
        str += romanSym[i]
        k -= arabicSym[i]
    }
}
return str
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
var count = 0
var number = n
while (number != 0) {
    number /= 10
    count +=1
}
var russian = " "
val units = arrayOf("", "один ", "два ", "три ", "четыре ", "пять ", "шесть ",
        "семь ", "восемь ", "девять ")
val tens = arrayOf("", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ",
        "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто ")
val hundreds = arrayOf("", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ",
        "шестьсот ", "семьсот ", "восемьсот ", "девятьсот ")
val thousands = arrayOf("", "одиннадцать ", "двенадцать ", "тринадцать ", "четырнадцать ",
        "пятнадцать ", "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать ")
val extraUnits = if (n % 10000 / 1000 == 2) "две "
else {
    if (n % 10000 / 1000 == 1) "одна "
    else units[n % 10000 / 1000]
}
val l = if (n % 100000 / 10000 == 1) thousands[n % 10000 / 1000]
else tens[n % 100000 / 10000] + extraUnits
val j = if (n % 100 / 10 == 1 && n % 10  != 0) thousands[n % 10]
else tens[n % 100 / 10] + units[n % 10]
val extraThousands = if (n % 10000 / 1000 == 1 && n % 100000 / 10000 != 1) "тысяча "
else {
    if (n % 10000 / 1000 > 4 || n % 10000 / 1000 == 0 || n % 100000 / 10000 == 1) "тысяч "
    else "тысячи "
}
    when{n == 0 -> russian = "ноль"
        count == 6 -> russian = hundreds[n / 100000] + l + extraThousands + hundreds[n % 1000 / 100] + j
        count == 5 -> russian = l + extraThousands + hundreds[n % 1000 / 100] + j
        count == 4 -> russian = extraUnits + extraThousands + hundreds[n % 1000 / 100] + j
        count == 3 -> russian = hundreds[n / 100] + j
        count == 2 -> russian = j
        count == 1 -> russian = units[n % 10]}
return russian.trim()
}