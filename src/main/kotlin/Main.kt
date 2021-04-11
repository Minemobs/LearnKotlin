import java.lang.NumberFormatException

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
    val color: Color = Color()
    loop@ while (true){
        println(color.ANSI_RESET + "Do you want to check the name list or add a name to the list \n" +
                "[0] View names \n" +
                "[1] Add name \n" +
                "[2] Exit")
        var response = 0
        try{
            response = readLine()!!.toInt()
        }catch (ex: NumberFormatException){
            println(color.ANSI_RED + "You didn't choose a number")
            nameList(names)
        }

        if(response !in 0..2){
            println(color.ANSI_RED + "Please choose a number between 0 and 2")
        }else{
            when (response) {
                0 -> {
                    val bar: String = color.ANSI_GRAY + "----------------------------------" + color.ANSI_RESET
                    println(bar)
                    for (name in names) {
                        println(color.ANSI_GREEN + name + color.ANSI_RESET)
                    }
                    println(bar)
                }

                1 -> {
                    println(color.ANSI_GREEN + "Please write a name")
                    names.add(readLine()!!)
                }
                2 -> {
                    break@loop
                }
                else -> println()
            }
        }
    }
}