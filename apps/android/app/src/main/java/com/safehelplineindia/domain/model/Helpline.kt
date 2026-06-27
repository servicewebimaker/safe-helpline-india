package com.safehelplineindia.domain.model

data class Helpline(
    val id: String,
    val name: String,
    val number: String,
    val category: HelplineCategory,
    val country: String,
    val availability: String,
    val description: String,
    val sourceUrl: String,
    val sourceName: String,
    val lastVerified: String,
    val verificationStatus: String
)
