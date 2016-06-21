package com.android.votechain.candidate.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * 21/06/2016.
 */
public class Vote {
  @SerializedName("candidate") private String idCandidate;
  private String gender;

  public Vote(String idCandidate) {
    this.idCandidate = idCandidate;
    this.gender = "M";
  }

  public String getIdCandidate() {
    return idCandidate;
  }

  public void setIdCandidate(String idCandidate) {
    this.idCandidate = idCandidate;
  }
}
