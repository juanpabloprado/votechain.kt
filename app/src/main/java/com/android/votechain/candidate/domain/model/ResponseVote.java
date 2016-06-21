package com.android.votechain.candidate.domain.model;

/**
 * 21/06/2016.
 */
public class ResponseVote {

  private String message;

  public ResponseVote(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
