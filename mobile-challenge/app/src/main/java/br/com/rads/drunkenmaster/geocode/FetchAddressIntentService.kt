package br.com.rads.drunkenmaster.geocode

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.os.ResultReceiver
import android.util.Log
import br.com.rads.drunkenmaster.common.ACTION_SEARCH_ADDRESS
import br.com.rads.drunkenmaster.common.Extras.ADDRESSES_FOUND_EXTRA
import br.com.rads.drunkenmaster.common.Extras.ADDRESS_EXTRA
import br.com.rads.drunkenmaster.common.Extras.RECEIVER_EXTRA
import java.io.IOException
import java.util.*

class FetchAddressIntentService : IntentService("FetchAddressIntentService") {

    private val MAX_RESULTS = 50
    private var receiver: ResultReceiver? = null

    override fun onHandleIntent(intent: Intent?) {
        intent?.let {
            receiver = it.getParcelableExtra(RECEIVER_EXTRA)
            when (it.action) {
                ACTION_SEARCH_ADDRESS -> searchAddress(it.getStringExtra(ADDRESS_EXTRA))
            }
        }
    }


    private fun searchAddress(address: String?) {

        val addressesFound = mutableListOf<Address>()

        try {
            if (address?.isNotEmpty() == true) {
                val geocoder = Geocoder(this, Locale.getDefault())
                addressesFound.addAll(geocoder.getFromLocationName(address, MAX_RESULTS))
            }
        } catch (e: IOException) {
            Log.e("GEOCODE",
                    "onHandleIntent: Serviço indisponivel - timeout or reboot device",
                    e)
        }


        val pocAddresses = addressesFound.mapNotNull { address ->
            address.getAddressLine(0)?.let {
                PocAddress(it, address.latitude, address.longitude)
            }
        }

        deliverResultToReceiver(SUCCESS_RESULT, pocAddresses)


    }

    private fun deliverResultToReceiver(resultCode: Int, pocAddress: List<PocAddress>) {
        val bundle = Bundle().apply {
            putParcelableArray(ADDRESSES_FOUND_EXTRA, pocAddress.toTypedArray())
        }
        receiver?.send(resultCode, bundle)
    }

    companion object {

        fun startActionSearchAddress(context: Context, address: String, receiver: ResultReceiver) {
            context.startService(Intent(context, FetchAddressIntentService::class.java)
                    .setAction(ACTION_SEARCH_ADDRESS)
                    .putExtra(ADDRESS_EXTRA, address)
                    .putExtra(RECEIVER_EXTRA, receiver))
        }

    }
}
