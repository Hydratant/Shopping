package com.tami.shopping.base.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class ListBindingAdapter<T, B : ViewDataBinding, VH : BindingViewHolder<T, B>> constructor(
    diffCallback: DiffUtil.ItemCallback<T>,
    @LayoutRes private val resId: Int,
    private val holderClass: Class<VH>
) : ListAdapter<T, VH>(diffCallback) {

    var onItemClick: ((T) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val bb: B = DataBindingUtil.inflate(inflater, resId, parent, false)
        return (holderClass.constructors[0].newInstance(bb.root) as VH).apply {
            itemView.setOnClickListener {
                val bindingAdapterPosition = bindingAdapterPosition
                if (bindingAdapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick?.invoke(getItem(bindingAdapterPosition))
                }
            }
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(getItem(position))
}

abstract class BindingViewHolder<T, B : ViewDataBinding>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    var bb: B = DataBindingUtil.bind(itemView)!!
    abstract fun bind(item: T)
}