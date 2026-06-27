package com.safehelplineindia.domain.model

enum class HelplineCategory(val label: String) {
    Emergency("Emergency"),
    WomenSafety("Women Safety");

    companion object {
        fun fromLabel(label: String): HelplineCategory? = values().firstOrNull { it.label == label }
    }
}
