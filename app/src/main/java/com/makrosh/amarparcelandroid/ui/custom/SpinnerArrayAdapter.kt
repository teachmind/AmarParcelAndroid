package com.makrosh.amarparcelandroid.ui.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.makrosh.amarparcelandroid.R

class SpinnerArrayAdapter(context: Context, resource: Int, objects: MutableList<String>) : ArrayAdapter<String>(context, resource, objects) {

    private lateinit var flater: LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return rowview(convertView, position)
    }

    private fun rowview(convertView: View?, position: Int): View {
        val rowItem: String? = getItem(position)
        val holder: viewHolder
        var rowview = convertView

        if (rowview == null) {
            holder = viewHolder()
            flater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            rowview = flater.inflate(R.layout.spinner_list_item, null, false)
            holder.txtTitle = rowview.findViewById<View>(R.id.tvSpinner) as TextView
            rowview.tag = holder
        } else {
            holder = rowview.tag as viewHolder
        }
        holder.txtTitle?.setText(rowItem)
        return rowview!!
    }

    private class viewHolder {
        var txtTitle: TextView? = null
    }
}