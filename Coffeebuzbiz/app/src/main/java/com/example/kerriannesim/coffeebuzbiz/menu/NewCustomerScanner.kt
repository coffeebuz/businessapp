package com.example.kerriannesim.coffeebuzbiz.menu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kerriannesim.coffeebuzbiz.R
import com.google.zxing.integration.android.IntentIntegrator

class NewCustomerFragment : Fragment() {

    companion object {

        fun newInstance(): NewCustomerFragment {
            return NewCustomerFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var integrator = IntentIntegrator.forSupportFragment(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES)
        integrator.setPrompt("Scan a barcode")
        integrator.setCameraId(0)  // Use a specific camera of the device
        integrator.setBeepEnabled(false)
        integrator.setOrientationLocked(false)
        integrator.setBarcodeImageEnabled(true)
        integrator.initiateScan()
        return inflater.inflate(R.layout.new_customer_main, container, false)
    }


}