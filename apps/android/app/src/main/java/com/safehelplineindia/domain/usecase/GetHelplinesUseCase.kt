package com.safehelplineindia.domain.usecase

import com.safehelplineindia.data.HelplineRepository
import com.safehelplineindia.domain.model.Helpline

class GetHelplinesUseCase(
    private val repository: HelplineRepository
) {
    operator fun invoke(): List<Helpline> = repository.getHelplines()
}
