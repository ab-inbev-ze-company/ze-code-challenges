package br.com.rads.drunkenmaster.geocode

import android.os.Parcel
import br.com.rads.drunkenmaster.product.Product
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PocAddressTest {

    private val pocAddress = PocAddress("address", 0.0, 1.0)

    @Test
    fun productIsParcelable() {
        val parcel = Parcel.obtain()
        pocAddress.writeToParcel(parcel, pocAddress.describeContents())
        parcel.setDataPosition(0)

        val fromParcel = PocAddress.CREATOR.createFromParcel(parcel)
        assertThat(fromParcel.fullAddress, CoreMatchers.`is`(pocAddress.fullAddress))
        assertThat(fromParcel.lat, CoreMatchers.`is`(pocAddress.lat))
        assertThat(fromParcel.lng, CoreMatchers.`is`(pocAddress.lng))
    }
}