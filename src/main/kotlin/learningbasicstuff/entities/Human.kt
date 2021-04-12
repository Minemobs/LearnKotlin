package learningbasicstuff.entities

import java.util.UUID

class Human(name: String, attackDamage: Int, health: Int) : Entity {

    private val entityName: String = name
    private val entityUUID: UUID = UUID.randomUUID()
    private var dmg: Int = attackDamage
    private var entityHealth: Int = health

    override fun getHealth(): Int {
        return entityHealth
    }

    override fun getAttackDamage(): Int {
        return dmg
    }

    override fun getName(): String {
        return entityName
    }

    override fun getUUID(): UUID {
        return entityUUID
    }

    override fun setHealth(health: Int) {
        entityHealth = health
    }

    override fun setAttackDamage(dmg: Int) {
        this.dmg = dmg
    }
}