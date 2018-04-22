package br.com.rads.drunkenmaster.home

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import br.com.rads.drunkenmaster.common.compatTint
import br.com.rads.drunkenmaster.geocode.PocAddress
import rads.com.br.drunkenmaster.R


class AddressesAdapter(private val addresses: MutableList<PocAddress>,
                       private val addressSelectedListener: AddressSelectedListener)
    : RecyclerView.Adapter<AddressesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_address, parent, false)
                as TextView
        return ViewHolder(textView)
    }

    override fun getItemCount() = addresses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val address = addresses[position]
        with(holder.addressTextView) {
            setCompoundDrawables(compoundDrawables.firstOrNull()?.compatTint(Color.parseColor("#9E9E9E")), null, null, null)
            text = address.fullAddress
            setOnClickListener {
                addressSelectedListener.addressSelected(address)
            }
        }
    }

    fun addAll(newAddresses: List<PocAddress>) {
        addresses.clear()
        addresses.addAll(newAddresses)
        notifyDataSetChanged()
    }

    class ViewHolder(val addressTextView: TextView) : RecyclerView.ViewHolder(addressTextView)

    interface AddressSelectedListener {
        fun addressSelected(pocAddress: PocAddress)
    }
}