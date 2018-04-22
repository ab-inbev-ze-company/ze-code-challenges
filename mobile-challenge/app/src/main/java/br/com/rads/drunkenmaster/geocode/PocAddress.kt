package br.com.rads.drunkenmaster.geocode

import android.os.Parcel
import android.os.Parcelable

data class PocAddress(val fullAddress: String,
                      val lat: Double,
                      val lng: Double) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readDouble(),
            parcel.readDouble())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullAddress)
        parcel.writeDouble(lat)
        parcel.writeDouble(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PocAddress> {
        override fun createFromParcel(parcel: Parcel): PocAddress {
            return PocAddress(parcel)
        }

        override fun newArray(size: Int): Array<PocAddress?> {
            return arrayOfNulls(size)
        }
    }
}