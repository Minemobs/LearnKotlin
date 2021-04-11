package entities

import java.util.UUID

interface Entity {

    fun getHealth() : Int

    fun getAttackDamage() : Int

    fun getName() : String

    fun getUUID() : UUID

    fun setHealth(health: Int)

    fun setAttackDamage(dmg: Int)

}