package br.com.rads.drunkenmaster.product.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rads.drunkenmaster.common.toMoney
import br.com.rads.drunkenmaster.product.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_product.view.*
import rads.com.br.drunkenmaster.R

class ProductListAdapter(private val productList: MutableList<Product>,
                         private val productSelectedListener: ProductSelectedListener)
    : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.itemView.product_price_textView.text = product.price.toMoney()
        holder.itemView.product_name_textView.text = product.name
        holder.itemView.product_description_textView.text = product.description
        Picasso.get()
                .load(product.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.itemView.imageView)

        holder.itemView.setOnClickListener {
            productSelectedListener.productSelected(product)
        }
    }

    fun addAll(newProductList: List<Product>) {
        productList.clear()
        productList.addAll(newProductList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface ProductSelectedListener {
        fun productSelected(product: Product)
    }
}