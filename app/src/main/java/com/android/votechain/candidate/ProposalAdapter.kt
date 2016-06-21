package com.android.votechain.candidate

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.android.votechain.R
import com.android.votechain.common.view.inflate
import kotlinx.android.synthetic.main.item_proposal.view.*


class ProposalAdapter : RecyclerView.Adapter<ProposalAdapter.ViewHolder>() {

    private val proposals by lazy {
        mutableListOf<String>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val view = parent.inflate(R.layout.item_proposal)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return proposals.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItem(proposals[position])
    }

    fun addProposals(proposals: List<String>?) {
        this.proposals.addAll(proposals!!)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(proposal: String) {
            itemView.textProposal.text = proposal;
        }
    }
}