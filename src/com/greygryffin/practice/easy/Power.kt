package com.greygryffin.practice.easy

import java.math.BigInteger

fun powerBigInt(base: BigInteger, exp: Int): BigInteger {
    // Base case: Any number raised to the power of 0 is 1
    if (exp == 0) return BigInteger.ONE

    var result = BigInteger.ONE
    var x = base
    var y = exp

    // Handle negative exponents manually, since BigInteger doesn't support non-integer exponents
    if (y < 0) {
        throw IllegalArgumentException("Negative exponents not supported with BigInteger.")
    }

    while (y > 0) {
        // If exp is odd, multiply the result by base
        if (y % 2 == 1) {
            result = result.multiply(x)
        }
        // Square the base and halve the exponent
        x = x.multiply(x)
        y /= 2
    }

    return result
}

fun power(x: Double, y: Int): Double {
    // Base case: Any number raised to the power of 0 is 1
    if (y == 0) return 1.0

    // Handle negative powers by computing 1 / x^|y|
    var base = x
    var exp = y
    if (y < 0) {
        base = 1 / base
        exp = -exp
    }

    var result = 1.0
    while (exp > 0) {
        // If y is odd, multiply the result by x
        if (exp % 2 == 1) {
            result *= base
        }
        // Square x and reduce y by half
        base *= base
        exp /= 2
    }

    return result
}

// Test cases
fun main() {
    val base = BigInteger("12345678901234567890")
    val exponent = 20
    println(powerBigInt(base, exponent))  // Output: A large BigInteger value

    println(power(2.0, 10))  // Output: 1024.0
    println(power(5.0, -3))  // Output: 0.008
}
