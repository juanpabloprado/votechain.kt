package com.android.votechain.candidate

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.android.votechain.R
import com.android.votechain.candidates.domain.model.Candidate
import com.android.votechain.candidates.view.dialog.CandidateProposalDialog
import com.android.votechain.common.view.BaseFragment
import com.android.votechain.common.view.loadURL
import com.android.votechain.tutorial.TutorialActivity
import kotlinx.android.synthetic.main.fragment_candidate_detail.*


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


  val loadingVote by lazy {
    val loading = ProgressDialog(context)
    loading.setMessage("Registrando Voto...")
    loading.setCancelable(false)
    loading
  }


  companion object {
    fun newInstance(idCandidate: String?, name: String?): CandidateDetailFragment {
      val args: Bundle = Bundle()
      val fragment: CandidateDetailFragment = CandidateDetailFragment()
      args.putString("id_candidate", idCandidate)
      fragment.arguments = args
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
    speechButton.setOnClickListener({ view -> presenter.textToSpeech() })
    buttonVote.setOnClickListener({ view -> presenter.makeVote() })
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

  override fun saySpeech(speech: String?) {
    CandidateProposalDialog.newInstance(speech).show(fragmentManager, "Speech")
  }

  override fun showLoadingVote() {
    loadingVote.show()
  }

  override fun hideLoadingVote() {
    loadingVote.hide()
  }

  override fun successVote() {
    Toast.makeText(context, "Voto Realizado", Toast.LENGTH_LONG).show()
    val intent: Intent = Intent(context, TutorialActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    startActivity(intent)
//    finishActivity()
  }
}