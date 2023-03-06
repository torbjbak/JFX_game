package models

enum class DamageType(private val category: DamageCategory) {
    CUT(DamageCategory.PHYSICAL),
    PIERCE(DamageCategory.PHYSICAL),
    BLUNT(DamageCategory.PHYSICAL),

    HEAT(DamageCategory.SPECIAL),
    COLD(DamageCategory.SPECIAL),
    RADIATION(DamageCategory.SPECIAL);

    enum class DamageCategory {
        PHYSICAL,
        SPECIAL
    }

    fun getCategory(): DamageCategory {
        return category
    }
}