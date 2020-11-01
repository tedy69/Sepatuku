package tech.tedycoding.sepatuku.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeModel(
    val idproduct: Int = 0,
    var namaproduct: String? = "",
    var statusproduct: String? = "",
    var diskonproduct: String? = "",
    var imageproduct: String? = "") : Parcelable
