package com.example.common.extensions

import android.os.Bundle
import androidx.fragment.app.Fragment

fun <T : Fragment> T.withArguments(action: Bundle.() -> Unit): Fragment {
    return apply { arguments = Bundle().apply(action) }
}