import entities.Human
import entities.Zombie
import java.lang.NumberFormatException
import kotlin.random.Random

fun main(){
    println("What's your name ?")
    val name: String = readLine().toString()
    println(String.format("Hello %s !", name))
    val names: ArrayList<String> = ArrayList()
    names.add(name)

    //nameList(names)
    battleSimulator(name)
}

private val color: Color = Color()

fun battleSimulator(username: String) {
    val player = Human(username, 5, 20)
    val zombie = Zombie("Zombie " + Random.nextInt(0, 101), 3, 15)

    if(Random.nextInt(0, 2) == 0){
        println(player.getName() + " used his ability : " + color.ANSI_RED + "First hit " + color.ANSI_RESET + "on " + zombie.getName())
        zombie.setHealth(zombie.getHealth() - player.getAttackDamage())
        println(zombie.getName() + " has now " + zombie.getHealth() + color.ANSI_RED + " ❤️" + color.ANSI_RESET)
    }else{
        println(zombie.getName() + " used his ability : " + color.ANSI_RED + "First hit " + color.ANSI_RESET + "on " + player.getName())
        player.setHealth(player.getHealth() - zombie.getAttackDamage())
        println(player.getName() + " has now " + player.getHealth() + color.ANSI_RED + " ❤️" + color.ANSI_RESET)
    }

    while (zombie.getHealth() > 0 && player.getHealth() > 0){
        Thread.sleep(2500)
        println(player.getName() + " attack " + zombie.getName())
        zombie.setHealth(zombie.getHealth() - player.getAttackDamage())
        println(zombie.getName() + " has now " + zombie.getHealth() + color.ANSI_RED + " ❤️" + color.ANSI_RESET)
        if(zombie.getHealth() <= 0) break
        Thread.sleep(2500)
        println(zombie.getName() + " attack " + player.getName())
        player.setHealth(player.getHealth() - zombie.getAttackDamage())
        println(player.getName() + " has now " + player.getHealth() + color.ANSI_RED + " ❤️" + color.ANSI_RESET)
    }

    if(player.getHealth() > 0 && zombie.getHealth() <= 0){
        println(color.ANSI_GREEN + player.getName() + color.ANSI_RESET + " won the fight")
    }else if(zombie.getHealth() > 0 && player.getHealth() <= 0){
        println(color.ANSI_GREEN + zombie.getName() + color.ANSI_RESET + " won the fight")
    }else{
        println("DRAW !")
    }
}

// From https://github.com/Minemobs/LearnScala/blob/main/lib/src/main/scala/fr/minemobs/learnscala/Main.scala#L34
fun nameList(names: ArrayList<String>){

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
            continue@loop
        }

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