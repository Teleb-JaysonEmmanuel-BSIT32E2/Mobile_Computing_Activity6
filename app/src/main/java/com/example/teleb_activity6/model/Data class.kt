package com.example.teleb_activity6.model

import android.content.Intent.ShortcutIconResource
import java.sql.RowId
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//class `Data class` {
//}

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)