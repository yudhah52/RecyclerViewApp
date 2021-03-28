package com.yhezra.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperHeroes (
    var image:String,
    var name: String,
    var detail:String
):Parcelable