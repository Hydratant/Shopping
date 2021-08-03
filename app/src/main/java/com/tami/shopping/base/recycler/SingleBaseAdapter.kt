package com.tami.shopping.base.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Single BindingAdapter
 * ITEM ,BindingLayout, BindingViewHolder
 *
 *  @param resId Binding layout ResId
 *  @param holderClass BindingViewHolder를 상속받은 ViewHolder Class
 */
abstract class SingleBindingAdapter<ITEM, B : ViewDataBinding, BH : BindingViewHolder<ITEM, B>>(
    @LayoutRes private val resId: Int,
    private val holderClass: Class<BH>
) : RecyclerView.Adapter<BH>() {

    val items = mutableListOf<ITEM>()
    var onItemClick: ((ITEM) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BH {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val bb: B = DataBindingUtil.inflate(inflater, resId, parent, false)
        return (holderClass.constructors[0].newInstance(bb.root) as BH).apply {
            itemView.setOnClickListener {
                val bindingAdapterPosition = bindingAdapterPosition
                if (bindingAdapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick?.invoke(items[bindingAdapterPosition])
                }
            }
        }
    }

    override fun onBindViewHolder(holder: BH, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    open fun set(items: List<ITEM>) {
        synchronized(this) {
            this.items.clear()
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }
}

/**
 * SingleBaseAdapter ViewHolder
 */
abstract class BindingViewHolder<ITEM, B : ViewDataBinding>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    var bb: B = DataBindingUtil.bind(itemView)!!
    abstract fun bind(item: ITEM)
}