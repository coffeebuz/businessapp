package com.example.kerriannesim.coffeebuzbiz.menu

import android.app.Activity.RESULT_CANCELED
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kerriannesim.coffeebuzbiz.CaptureActivityPortrait
import com.example.kerriannesim.coffeebuzbiz.R
import com.google.zxing.integration.android.IntentIntegrator
import android.widget.Toast
import com.google.zxing.integration.android.IntentResult
import android.content.Intent
import android.support.design.R.id.container
import android.widget.Button
import kotlinx.android.synthetic.main.new_customer_main.view.*


class NewCustomerFragment : Fragment() {

    companion object {

        fun newInstance(): NewCustomerFragment {
            return NewCustomerFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var integrator = IntentIntegrator.forSupportFragment(this@NewCustomerFragment)
        integrator.setPrompt("Scan a barcode")
        integrator.setCameraId(0)  // Use a specific camera of the device
        integrator.setBeepEnabled(false)
        integrator.setOrientationLocked(true)
        integrator.captureActivity = CaptureActivityPortrait::class.java
        integrator.setBarcodeImageEnabled(true)
        integrator.initiateScan()

        return inflater.inflate(R.layout.new_customer_main, container, false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode != RESULT_CANCELED) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(getActivity(), "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }


}