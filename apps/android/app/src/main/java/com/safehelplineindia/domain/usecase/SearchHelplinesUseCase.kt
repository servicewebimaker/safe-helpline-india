package com.safehelplineindia.domain.usecase

import com.safehelplineindia.data.HelplineRepository
import com.safehelplineindia.domain.model.Helpline
import com.safehelplineindia.domain.model.HelplineCategory

class SearchHelplinesUseCase(
    private val repository: HelplineRepository
) {
    operator fun invoke(query: String, category: HelplineCategory?): List<Helpline> {
        val normalizedQuery = query.trim().lowercase()

        return repository.getHelplines().filter { helpline ->
            val matchesCategory = category == null || helpline.category == category
            val searchableText = listOf(
                helpline.name,
                helpline.number,
                helpline.category.label,
                helpline.description,
                helpline.sourceName
            ).joinToString(" ").lowercase()

            matchesCategory && (normalizedQuery.isBlank() || searchableText.contains(normalizedQuery))
        }
    }
}
