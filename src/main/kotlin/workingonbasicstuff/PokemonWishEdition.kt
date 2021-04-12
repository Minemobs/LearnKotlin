package workingonbasicstuff

import learningbasicstuff.Color
import workingonbasicstuff.entities.Charmander
import workingonbasicstuff.entities.IBasePokemon
import workingonbasicstuff.entities.Squirtle

fun main(){

    val color = Color()

    val charmander = Charmander(arrayListOf(Types.FIRE), 30f, 5, 5, "Charmander")
    val squirtle = Squirtle(arrayListOf(Types.WATER), 25f, 3, 5, "Squirtle")

    while (charmander.getHealth() > 0 && squirtle.getHealth() > 0) {
        println(charmander.name + " attack " + squirtle.name)
        attackPokemon(charmander, squirtle)
        if(charmander.getHealth() <= 0) break
        println(squirtle.getPokemonName() + " has now " + squirtle.getHealth() + color.ANSI_RED + " ❤️" + color.ANSI_RESET)
        Thread.sleep(2500)
        println(squirtle.name + " attack " + charmander.name)
        attackPokemon(squirtle, charmander)
        if(charmander.getHealth() <= 0) break
        println(charmander.getPokemonName() + " has now " + charmander.getHealth() + color.ANSI_RED + " ❤️" + color.ANSI_RESET)
        Thread.sleep(2500)
    }

    if(squirtle.getHealth() > 0 && charmander.getHealth() <= 0) {
        println(color.ANSI_GREEN + charmander.getPokemonName() + color.ANSI_RESET + " is " + color.ANSI_RED + "KO" + color.ANSI_RESET)
        println(color.ANSI_GREEN + squirtle.getPokemonName() + color.ANSI_RESET + " won the fight")
    }else if(charmander.getHealth() > 0 && squirtle.getHealth() <= 0){
        println(color.ANSI_GREEN + squirtle.getPokemonName() + color.ANSI_RESET + " is " + color.ANSI_RED + "KO" + color.ANSI_RESET)
        println(color.ANSI_GREEN + charmander.getPokemonName() + color.ANSI_RESET + " won the fight")
    }else{
        println("DRAW !")
    }

}

fun attackPokemon(attacker: IBasePokemon, defender: IBasePokemon) {
    for (type in defender.getTypes()) {
        if (type.getWeaknessAsTypes().containsAll(attacker.getTypes()) && defender.getTypes().size != 1) {
            defender.removeHealth(attacker.getDamage() * 4f)
            println("It's super effective (x4)")
        } else if (type.getWeaknessAsTypes().containsAll(attacker.getTypes()) && defender.getTypes().size == 1) {
            defender.removeHealth(attacker.getDamage() * 2f)
            println("It's super effective (x2)")
        }else{
            defender.removeHealth(attacker.getDamage().toFloat())
        }
    }
}
