package com.example.quizapp.utility

import androidx.core.text.HtmlCompat


   fun decodeHtmlEntities(text: String): String {
        return HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
    }