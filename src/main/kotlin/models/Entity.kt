package models

abstract class Entity(
    val name: String,
    val description: String,
    val imgSrc: String?
) {
    val id: Int = nextId++

    private companion object {
        private var nextId = 0
    }

    override fun toString(): String {
        return "[$id] $name (${this.javaClass.simpleName})"
    }
}