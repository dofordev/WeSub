package com.iyuno.wesub

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

class LoadingDialog
    constructor(context: Context) : Dialog(context){
        init {
            setCanceledOnTouchOutside(false)
            setCancelable(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.1F)
            setContentView(R.layout.dialog_loading)
        }
}