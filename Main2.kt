class InvalidGradeException(message: String) : Exception(message)
fun main() {
    print("Введіть кількість студентів: ")
    val n = readLine()!!.toInt()
    val students = mutableListOf<Pair<String, Int>>()
    for (i in 1..n) {
        println("Студент $i:")
        print("Введіть ім'я студента: ")
        val name: String? = readLine()
        print("Введіть оцінку студента (0-100): ")
        var grade = try {
            readLine()!!.toInt()
        } catch (e: Exception) {
            println("Невірний ввід для оцінки, встановлено 0")
            0
        }
        try {
            if (grade !in 0..100) {
                throw InvalidGradeException("Оцінка повинна бути в діапазоні 0-100!")
            }
        } catch (e: InvalidGradeException) {
            println("Помилка: ${e.message}")
            grade = 0 
        }
        val studentName = name?.takeIf { it.isNotBlank() } ?: "Unknown"
        students.add(studentName to grade)
    }

    val totalGrade = students.sumBy { it.second }
    val averageGrade = totalGrade.toDouble() / students.size
    val maxGrade = students.maxByOrNull { it.second }?.second ?: 0
    val minGrade = students.minByOrNull { it.second }?.second ?: 0

    println("\nСтуденти, що мають оцінку ≥ 90 (відмінники):")
    students.filter { it.second >= 90 }.forEach {
        println("${it.first}: ${it.second}")
    }

    val levelComment = when {
        averageGrade.toInt() >= 90 -> "Високий рівень"
        averageGrade.toInt() in 70..89 -> "Середній рівень"
        else -> "Низький рівень"
    }

    println("\nПідсумки:")
    println("Середня оцінка: $averageGrade")
    println("Найвища оцінка: $maxGrade")
    println("Найнижча оцінка: $minGrade")
    println("Коментар: $levelComment")
}
