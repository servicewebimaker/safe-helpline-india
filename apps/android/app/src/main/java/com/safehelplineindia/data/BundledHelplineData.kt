package com.safehelplineindia.data

import com.safehelplineindia.domain.model.Helpline
import com.safehelplineindia.domain.model.HelplineCategory

object BundledHelplineData {
    val helplines = listOf(
        Helpline(
            id = "erss-112",
            name = "Emergency Response Support System (ERSS)",
            number = "112",
            category = HelplineCategory.Emergency,
            country = "IN",
            availability = "24x7",
            description = "India's unified emergency number for reporting emergencies. ERSS is designed to route actionable distress calls to the appropriate emergency services, including police, health, fire, disaster, women and children helpline systems.",
            sourceUrl = "https://www.mha.gov.in/en/commoncontent/emergency-response-support-system-erss",
            sourceName = "Ministry of Home Affairs, Government of India",
            lastVerified = "2026-06-26",
            verificationStatus = "verified"
        ),
        Helpline(
            id = "women-helpline-181",
            name = "Women Helpline",
            number = "181",
            category = HelplineCategory.WomenSafety,
            country = "IN",
            availability = "24x7",
            description = "Women Helpline provides emergency and non-emergency response through telephonic short-code 181 for women, including referral to appropriate authorities and information about women-related government schemes and support services.",
            sourceUrl = "https://www.myscheme.gov.in/schemes/whl-181",
            sourceName = "myScheme, Government of India",
            lastVerified = "2026-06-26",
            verificationStatus = "verified"
        )
    )
}
