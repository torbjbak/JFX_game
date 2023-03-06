package models

class Weapon(
    name: String,
    description: String,
    imgSrc: String?,
    value: Int,
    weight: Double,
    val baseDamage: Int,
    val damageType: DamageType,
    val secondaryDamage: Int?,
    val secondaryType: DamageType?,
) : Item(name, description, imgSrc, value, weight) {
    override fun toString(): String {
        var str = "[$id] $name (${this.javaClass.simpleName}) - Damage: "
        str += if (secondaryDamage == null || secondaryType == null) "$baseDamage $damageType"
            else "${baseDamage + secondaryDamage} ($baseDamage $damageType + $secondaryDamage $secondaryType)"
        return str
    }
}