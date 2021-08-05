package com.tami.shopping.ui.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.tami.shopping.R
import com.tami.shopping.utils.ext.formatComma

object GoodBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:isFavorite")
    fun isFavorite(imageView: ImageView, isFavorite: Boolean) {
        if (isFavorite)
            imageView.setImageResource(R.drawable.ic_favorite_sunset_orange_24dp)
        else
            imageView.setImageResource(R.drawable.ic_favorite_border_white_24dp)

    }

    @JvmStatic
    @BindingAdapter("app:actualPrice", "app:price", requireAll = true)
    fun setSalePercent(textView: TextView, actualPrice: Int, price: Int) {
        if (actualPrice == price) {
            textView.visibility = View.GONE
        } else {
            val percent =
                (((actualPrice.toFloat() - price.toFloat()) / actualPrice.toFloat()) * 100).toInt()
            textView.text =
                String.format(textView.context.getString(R.string.sale_percent), percent)

        }
    }

    @JvmStatic
    @BindingAdapter("app:price")
    fun setPrice(textView: TextView, price: Int) {
        textView.text = price.formatComma()
    }


    @JvmStatic
    @BindingAdapter("app:sellCount")
    fun setSellCount(textView: TextView, sellCount: Int) {
        sellCount.formatComma()
        textView.text =
            String.format(textView.context.getString(R.string.sell_count), sellCount.formatComma())
    }
}