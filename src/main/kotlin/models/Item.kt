package models

abstract class Item(
    name: String,
    description: String,
    imgSrc: String?,
    val value: Int,
    val weight: Double
) : Entity(name, description, imgSrc)