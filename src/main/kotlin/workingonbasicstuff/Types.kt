package workingonbasicstuff

import java.util.function.Consumer

enum class Types(weakness: ArrayList<String>, resistances: ArrayList<String>) {

    WATER(arrayListOf("LEAF"), arrayListOf("FIRE")),
    FIRE(arrayListOf("WATER"), arrayListOf("LEAF")),
    LEAF(arrayListOf("FIRE"), arrayListOf("WATER"));

    private val weak: ArrayList<String> = weakness

    fun getWeaknessAsTypes(): ArrayList<Types> {
        val weakness: ArrayList<Types> = ArrayList()
        weak.forEach(Consumer { t -> weakness.add(valueOf(t)) })
        return weakness
    }

    fun getWeakness(): ArrayList<String> {
        return weak
    }

    private val res: ArrayList<String> = resistances

    fun getResistancesAsTypes(): ArrayList<Types> {
        val resistances: ArrayList<Types> = ArrayList()
        res.forEach(Consumer { t -> resistances.add(valueOf(t)) })
        return resistances
    }

    fun getResistances(): ArrayList<String> {
        return res
    }


}