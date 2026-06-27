package com.safehelplineindia.data

import com.safehelplineindia.domain.model.Helpline
import com.safehelplineindia.domain.model.HelplineCategory

class HelplineRepository {
    fun getHelplines(): List<Helpline> = BundledHelplineData.helplines

    fun getById(id: String): Helpline? = BundledHelplineData.helplines.firstOrNull { it.id == id }

    fun getByNumber(number: String): Helpline? {
        val normalizedNumber = number.filter { it.isDigit() }
        return BundledHelplineData.helplines.firstOrNull { it.number == normalizedNumber }
    }

    fun getByCategory(category: HelplineCategory): List<Helpline> =
        BundledHelplineData.helplines.filter { it.category == category }
}
