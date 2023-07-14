package com.example.marketplaceapp.presenter.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.marketplaceapp.R

class HomeHeader : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, styleAttr: Int) : super(context, attrs, styleAttr)

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.home_header_item, this, false)
        addView(view)
    }

}