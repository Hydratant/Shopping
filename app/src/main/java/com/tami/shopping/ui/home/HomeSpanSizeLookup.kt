package com.tami.shopping.ui.home

import androidx.recyclerview.widget.GridLayoutManager

class HomeSpanSizeLookup : GridLayoutManager.SpanSizeLookup() {
    override fun getSpanSize(position: Int): Int {
        return if (position == 0) 2
        else 1
    }
}