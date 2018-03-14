package me.a3cha.android.smartprogressdialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.dialog_progress.view.*


/**
 * Created by Anuphap Suwannamas on 13/3/2018 AD.
 * Email: Anupharpae@gmail.com
 */

class SmartProgressDialogFragment : DialogFragment() {
    private var message: String? = null

    companion object {
        private const val ARG_MESSAGE = "arg_message"

        fun newInstance(message: String?): SmartProgressDialogFragment {
            val fragment = SmartProgressDialogFragment()
            val bundle = Bundle()
            bundle.putString(ARG_MESSAGE, message)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            retrieveArguments(arguments)
        } else {
            retrieveInstanceState(savedInstanceState)
        }
    }

    override fun onStart() {
        super.onStart()
        val windowParams = dialog.window.attributes
        windowParams.dimAmount = 0.0f
        dialog.window.attributes = windowParams
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_progress, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_MESSAGE, message)
    }

    private fun setupView(rootView: View) {
        dialog.window.setBackgroundDrawableResource(android.R.color.transparent)
        message?.let { rootView.tvMessage.text = it }
    }

    private fun retrieveInstanceState(bundle: Bundle) {
        message = bundle.getString(ARG_MESSAGE)
    }

    private fun retrieveArguments(bundle: Bundle?) {
        bundle?.let { message = it.getString(ARG_MESSAGE) }
    }

    class Builder {
        private var message: String? = ""

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun build(): SmartProgressDialogFragment {
            return newInstance(message)
        }
    }
}