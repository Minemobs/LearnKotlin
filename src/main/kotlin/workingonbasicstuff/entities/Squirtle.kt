package workingonbasicstuff.entities

import workingonbasicstuff.Types

class Squirtle(override var typesList: ArrayList<Types>, override var pv: Float, override var entityResistance: Int,
               override var attackDamage: Int, override var name: String
) : IBasePokemon {
}