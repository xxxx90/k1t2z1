import java.util.Scanner
import kotlin.time.times

fun main() {

    val amount = 100

    val isMasterCard = false
    val isVisaMir = false
    val isVKPay = true

    val limitDay = 150_000
    val limitMonthIn = 600_000
    val limitOutMonth = 600_000
    val limitVkOne = 15_000
    val limitVkMonth = 40_000
    var result = ""
    var isExcessLimit = false



    if (isExcessLimit) {
        println("Превышен месячный лимит")

    } else {
        if (isVKPay) {
            result = commmissionVK(amount)
        } else {
            if (isVisaMir) {
                result = commmissionMir( amount)
            }
            result = commmissionMaster( amount)
        }


    }
    println(result)

}

fun commmissionMaster(amount: Int): String {

    var commission: Int = (amount*0.006+20).toInt()

    if (amount > 300 && amount < 75_000) { return "Коммиссия не взимается" }

    return "Комиссия составит " + commission
}

fun commmissionMir(amount: Int): String {
    var commission: Int = (amount * 0.0075).toInt()

    if (commission < 35 ) {commission =35}

    return "Комиссия составит " + commission
}

fun commmissionVK(amount: Int): String {
    var result = ""
    if (amount > 15_000) {
        result = "Нельзя переводить более 15 тыс рублей за один раз"
    } else {
        result = "Комиссия не взимается"
    }

    return result
}
