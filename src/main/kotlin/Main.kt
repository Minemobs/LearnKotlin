import java.lang.NumberFormatException
import kotlin.system.exitProcess

fun main(args: Array<String>){
    println("What's your name ?")
    val name: String = readLine().toString()
    println(String.format("Hello %s !", name))
    val names: ArrayList<String> = ArrayList()
    names.add(name)
    nameList(names)
}

// From https://github.com/Minemobs/LearnScala/blob/main/lib/src/main/scala/fr/minemobs/learnscala/Main.scala#L34
fun nameList(names: ArrayList<String>){
    loop@ while (true){
        println("Do you want to check the name list or add a name to the list \n" +
                "[0] View names \n" +
                "[1] Add name \n" +
                "[2] Exit")
        var response = 0
        try{
            response = readLine()!!.toInt()
        }catch (ex: NumberFormatException){
            println("You didn't choose a number")
            nameList(names)
        }

        when (response) {
            0 -> {
                println("----------------------------------")
                for (name in names) {
                    println(name)
                }
                println("----------------------------------")
            }

            1 -> {
                println("Please write a name")
                names.add(readLine()!!)
            }
            2 -> {
                break@loop
            }
            else -> println()
        }
    }
}