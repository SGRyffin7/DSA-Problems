package com.greygryffin.practice.medium

fun groupAnagramsUsingSortedKey(strs: Array<String>): List<List<String>> {
    val anagramMap = HashMap<String, MutableList<String>>()

    for (str in strs) {
        // Sort the string and convert it back to a string
        val sortedStr = str.toCharArray().sorted().joinToString("")

        // Use the sorted string as a key in the HashMap
        anagramMap.computeIfAbsent(sortedStr) { mutableListOf() }.add(str)
    }

    return anagramMap.values.toList()
}

fun areAnagramsMap(str1: String, str2: String) : Boolean {
    if(str1.length != str2.length) return false

    val charMap = HashMap<Char, Int>()

    for (i in str1.indices) {
        charMap[str1[i]] = charMap.getOrDefault(str1[i], 0) + 1
        charMap[str2[i]] = charMap.getOrDefault(str2[i], 0) - 1
    }

    for (i in charMap.values) {
        if(i!=0) return false
    }

    return true
}

fun areAnagramsSort(str1: String, str2: String) : Boolean {
    if(str1.length != str2.length) return false

    return str1.toCharArray().sortedArray().toString() == str2.toCharArray().sortedArray().toString()

}

fun groupAnagramsCounting(strs: Array<String>): List<List<String>> {
    val anagramMap = HashMap<String, MutableList<String>>()

    for (str in strs) {
        val charCount = IntArray(26) // Assuming only lowercase letters
        for (char in str) {
            charCount[char - 'a']++
        }
        // Create a key based on the frequency count
        val key = charCount.joinToString(",")
        // Group by the frequency count key
        anagramMap.computeIfAbsent(key) { mutableListOf() }.add(str)
    }

    return anagramMap.values.toList()
}