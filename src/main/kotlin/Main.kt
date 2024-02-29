fun main() {
    // TaskN1
    val numbers = intArrayOf(1, 3, 5, 5, 3, 1, 7, 2, 2)
    val singleNumber = singleNumber(numbers)
    println("The number that does not repeat is: $singleNumber")

    //Task N2
    val tetri = 182
    val minCoins = minSplit(tetri)
    println("Minimum number of coins needed to make $tetri tetri: $minCoins")

    //Task N3
    val words = arrayOf("brick", "bro", "brown")
    println("Longest prefix: ${longestPrefix(words)}")

    val words2 = arrayOf("sun", "moon", "earth")
    println("Longest prefix: ${longestPrefix(words2)}")

    //Task N4
    val a = "1010"
    val b = "1011"
    println("Sum of $a and $b = ${addBinary(a, b)}")

    //Task N5
    val n = 4
    println("Number of ways to climb $n stairs: ${countVariants(n)}")

    //Task N6
    val ds = FastRemovalDataStructure<Int>()
    ds.add(1)
    ds.add(22)
    ds.add(33)
    ds.printList()
    ds.remove(1)
    ds.printList()
}

// TaskN1
fun singleNumber(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    for ((num, count) in map) {
        if (count == 1) {
            return num
        }
    }
    return -1
}

// TaskN2
fun minSplit(money: Int): Int {
    val coins = intArrayOf(50, 20, 10, 5, 1)
    var remainingTetri = money
    var coinCount = 0
    var i = 0
    while (remainingTetri > 0 && i < coins.size) {
        coinCount += remainingTetri / coins[i]
        remainingTetri %= coins[i]
        i++
    }
    return coinCount
}

// TaskN3
fun longestPrefix(stringArray: Array<String>): String {
    if (stringArray.isEmpty()) return ""

    val firstWord = stringArray[0]

    for (i in firstWord.indices) {
        val char = firstWord[i]
        for (j in 1 until stringArray.size) {
            if (i == stringArray[j].length || stringArray[j][i] != char) {
                return firstWord.substring(0, i)
            }
        }
    }
    return firstWord
}

// Task N4
fun addBinary(num1: String, num2: String): String {
    var carry = 0
    var result = ""
    var i = num1.length - 1
    var j = num2.length - 1

    while (i >= 0 || j >= 0 || carry > 0) {
        val digitA = if (i >= 0) num1[i] - '0' else 0
        val digitB = if (j >= 0) num2[j] - '0' else 0

        val sum = digitA + digitB + carry

        result = (sum % 2).toString() + result
        carry = sum / 2

        i--
        j--
    }

    return result
}

// Task N5
fun countVariants(n: Int): Int {
    if (n == 0 || n == 1) return 1

    var prev = 1
    var curr = 1

    for (i in 2..n) {
        val next = prev + curr
        prev = curr
        curr = next
    }

    return curr
}

