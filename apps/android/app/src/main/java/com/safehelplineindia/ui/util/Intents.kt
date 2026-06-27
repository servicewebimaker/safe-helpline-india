package com.safehelplineindia.ui.util

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openDialer(number: String) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
    runCatching { startActivity(intent) }
}

fun Context.openWebPage(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    runCatching { startActivity(intent) }
}
