package workingonbasicstuff.entities

import workingonbasicstuff.Types

interface IBasePokemon {

    var typesList: ArrayList<Types>
    var pv: Float
    var entityResistance: Int
    var attackDamage: Int
    var name: String

    fun getPokemonName() : String{
        return name
    }

    fun setPokemonName(name: String){
        this.name = name
    }

    fun getTypes(): ArrayList<Types> {
        return typesList
    }

    fun setTypes(type: Types){
        typesList.add(type)
    }

    fun getHealth(): Float {
        return pv
    }

    fun setHealth(health: Float){
        pv = health
    }

    fun removeHealth(health: Float){
        pv -= (health - entityResistance)
    }

    fun addHealth(health: Int){
        pv -= health
    }

    fun getResistance(): Int {
        return entityResistance
    }

    fun setResistance(resistance: Int){
        entityResistance = resistance
    }

    fun getDamage(): Int {
        return attackDamage
    }

    fun setDamage(atck: Int){
        attackDamage = atck
    }
}
