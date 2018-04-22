package br.com.rads.drunkenmaster.product

import android.os.Parcel
import br.com.rads.drunkenmaster.PocCategorySearchQuery
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ProductTest {

    private val product = Product("name", "description", "imageUrl", 1.0f)

    @Test
    fun productIsParcelable() {
        val parcel = Parcel.obtain()
        product.writeToParcel(parcel, product.describeContents())
        parcel.setDataPosition(0)

        val fromParcel = Product.CREATOR.createFromParcel(parcel)
        assertThat(fromParcel.name, CoreMatchers.`is`(product.name))
        assertThat(fromParcel.description, CoreMatchers.`is`(product.description))
        assertThat(fromParcel.imageUrl, CoreMatchers.`is`(product.imageUrl))
        assertThat(fromParcel.price, CoreMatchers.`is`(product.price))
    }

    @Test
    fun generateProductFromEmptyResponse() {
        val productFromResponse = Product.from(PocCategorySearchQuery.Product("", null))
        assertEquals("", productFromResponse.name)
        assertEquals("", productFromResponse.description)
        assertEquals("", productFromResponse.imageUrl)
        assertEquals(0.0f, productFromResponse.price)
    }

    @Test
    fun generateProductFromResponse() {
        val productFromResponse = Product.from(PocCategorySearchQuery.Product("queryTypeName",
                listOf(
                        PocCategorySearchQuery.ProductVariant("variantTypeName",
                                "prodTitle",
                                "prodDesc",
                                "prodImageUrl",
                                3.0)
                )))
        assertEquals("prodTitle", productFromResponse.name)
        assertEquals("prodDesc", productFromResponse.description)
        assertEquals("prodImageUrl", productFromResponse.imageUrl)
        assertEquals(3.0f, productFromResponse.price)
    }
}