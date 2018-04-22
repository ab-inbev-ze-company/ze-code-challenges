package br.com.rads.drunkenmaster.product.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.rads.drunkenmaster.common.Extras
import br.com.rads.drunkenmaster.common.toMoney
import br.com.rads.drunkenmaster.product.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*
import rads.com.br.drunkenmaster.R

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getParcelableExtra<Product>(Extras.PRODUCT_EXTRA)

        Picasso.get().load(product.imageUrl).into(product_imageView)
        product_name_textView.text = product.name
        product_price_textView.text = product.price.toMoney()
        product_description_textView.text = if (product.description.isEmpty()) {
            getString(R.string.unavailable)
        } else {
            product.description
        }
    }
}
