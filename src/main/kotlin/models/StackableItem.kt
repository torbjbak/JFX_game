package models

class StackableItem(
    name: String,
    description: String,
    imgSrc: String?,
    value: Int,
    weight: Double,
    val count: Int
) : Item(name, description, imgSrc, value, weight) {

    fun getTotalWeight(): Double {
        return weight * count
    }

    fun getTotalValue(): Int {
        return value * count
    }


    override fun toString(): String {
        return "[$id] $name (${this.javaClass.simpleName}) - Count: $count"
    }
}