@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import java.lang.Integer.max
import java.lang.Integer.min
import java.lang.Math.*
import lesson1.task1.sqr

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int = when {
    n == m -> 1
    n < 10 -> 0
    else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
}

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var num = abs(n)
    do {
        num /= 10
        count +=1
    } while (num > 0)
    return count
}
/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fib1 = 1
    var fib2 = 1
    var fib3 = 0
    for (i in 3..n) {
        fib3 = fib2
        fib2 += fib1
        fib1 = fib3
    }
    return fib2

}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    val lcm = m * n
    var k = m
    var l = n
    while ((l != 0) && (k != 0)) {
        if (l > k) l %= k
        else k %= l
    }
    return lcm / (l + k)
}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */

fun minDivisor(n: Int): Int {
    if (isPrime(n))
        return n
    return (2..round(sqrt(n.toDouble())).toInt()).firstOrNull { n % it == 0 } ?: n
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = n / minDivisor(n)

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun gcd(a: Int, b: Int): Int {
    var newA = a
    var newB = b
    while (max(newA, newB) % min(newA, newB) != 0) {
        when {
            newA > newB -> newA %= newB
            else -> newB %= newA
        }
    }
    return min(newA, newB)
}

fun isCoPrime(m: Int, n: Int): Boolean = gcd(m,n) == 1
/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    val k = floor(sqrt(n.toDouble()))
    return k * k >= m
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double{
    val number = x % (2 * PI )
    var sum = number
    var result  = number
    var count = 0
    while (abs(sum) >= eps) {
        count+=1
        sum = pow(number,
                count.toDouble() * 2 + 1) / factorial(count * 2 + 1)
        if (count % 2 == 0) {
            result += sum
        } else {
            result -= sum
        }
    }
    return result
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double{
    val number = x % (2 * PI )
    var sum = number
    var cos = 1.0
    var count = 0
    while (abs(sum) >= eps) {
        count+=1
        sum = pow(number, count.toDouble() * 2) / factorial(count * 2)
        if (count % 2 == 1) {
            cos -= sum
        } else {
            cos += sum
        }
    }
    return cos
}
/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var revNum = 0
    var k = 0
    var m = n
    while (m > 0) {
        k = m % 10
        revNum = revNum * 10 + k
        m /= 10
    }
    return revNum
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    var count = digitNumber(n) - 1
    val s = n.toString()
    for (i in 0..count)
        when {
        s[i] != s[count] ->
            return false
        else -> count -= 1
    }
    return true
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val number = n % 10
    var s = n
    while (s > 0) {
        if (s % 10 != number) {
            return true
        } else {
            s /= 10
        }
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var length = 0
    var square = 0
    var count = 1
    while (length < n) {
        square = count * count
        length += digitNumber(square)
        count +=1
    }
    if (length > n) {
        while (length != n) {
            square /= 10
            length -=1
        }
    }
    return square % 10
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var length = 0
    var fib = 0
    var count = 1
    while (length < n) {
        fib = fib(count)
        length += digitNumber(fib)
        count+=1
    }
    if (length > n) {
        while (length != n) {
            fib /= 10
            length-=1
        }
    }
    return fib % 10
}
