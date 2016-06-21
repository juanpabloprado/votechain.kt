package com.android.votechain.candidate

import com.android.votechain.R
import com.android.votechain.candidates.domain.model.Candidate
import com.android.votechain.common.view.BaseFragment
import com.android.votechain.common.view.loadURL
import kotlinx.android.synthetic.main.fragment_candidate_detail.*
import kotlinx.android.synthetic.main.item_candidate.*


class CandidateDetailFragment() : BaseFragment(), CandidateDetailView.View {

    val presenter by lazy {
        CandidateDetailPresenter(this)
    }

    val idCandidate by lazy {
        val id = arguments.getString("id_candidate")
        id
    }

    val adapter by lazy {
        val mAdapter = ProposalAdapter()
        mAdapter
    }

    companion object {
        fun newInstance(idCandidate: String?, name: String?): CandidateDetailFragment {
            val args: Bundle = Bundle()
            val fragment: CandidateDetailFragment = CandidateDetailFragment()
            args.putString("id_candidate", idCandidate)
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun getFragmentLayout(): Int {
        return R.layout.fragment_candidate_detail
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)
        list_proposals.setHasFixedSize(true)
        list_proposals.layoutManager = LinearLayoutManager(context)
        list_proposals.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.getCandidateData(idCandidate)
    }

    override fun showCandidateData(candidate: Candidate?) {
        candidateName.text = candidate?.name
        politicParty.text = candidate?.politicParty
        candidateImage.loadURL(candidate?.photoUrl)

        adapter.addProposals(candidate?.proposals?.toList())
    }
}