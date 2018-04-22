package br.com.rads.drunkenmaster.home

import android.content.Context
import br.com.rads.drunkenmaster.geocode.PocAddress

interface HomeContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun addressFound(addresses: List<PocAddress>)
        fun addressNotFound()
        fun startProductListActivity(pocAddress: PocAddress)
    }

    interface Presenter {
        fun searchAddress(address: String)
    }

}