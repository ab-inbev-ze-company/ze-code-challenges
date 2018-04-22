package br.com.rads.drunkenmaster.geocode

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import br.com.rads.drunkenmaster.common.Extras

class GeocodeServiceImpl(val context: Context) : GeocodeService {

    override fun searchAddress(address: String,
                               addressFound: (List<PocAddress>) -> Unit,
                               addressNotFound: () -> Unit) {

        FetchAddressIntentService.startActionSearchAddress(context,
                address,
                object : ResultReceiver(Handler()) {
                    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                        super.onReceiveResult(resultCode, resultData)
                        val addresses = resultData?.getParcelableArray(Extras.ADDRESSES_FOUND_EXTRA)
                        if (addresses?.isNotEmpty() == true) {
                            addressFound(addresses.map { it as PocAddress })
                        } else {
                            addressNotFound()
                        }
                    }
                })
    }
}