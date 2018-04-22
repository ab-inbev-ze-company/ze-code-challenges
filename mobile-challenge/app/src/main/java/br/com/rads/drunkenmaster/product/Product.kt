package br.com.rads.drunkenmaster.product

import android.os.Parcel
import android.os.Parcelable
import br.com.rads.drunkenmaster.PocCategorySearchQuery

data class Product(val name: String,
                   val description: String,
                   val imageUrl: String,
                   val price: Float) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readFloat())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(imageUrl)
        parcel.writeFloat(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }

        fun from(it: PocCategorySearchQuery.Product): Product {
            val productVariant = it.productVariants()?.first()
            return Product(productVariant?.title() ?: "",
                    productVariant?.description() ?: "",
                    productVariant?.imageUrl() ?: "",
                    productVariant?.price()?.toFloat() ?: 0.0f)
        }


    }
}