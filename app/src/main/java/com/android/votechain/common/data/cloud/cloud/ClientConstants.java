package com.android.votechain.common.data.cloud.cloud;

/**
 * 04/05/16.
 */
public class ClientConstants {
  public static final String BASE_URL_CANDIDATES = "https://votechain.firebaseio.com/";
  public static final String BASE_URL_VOTE = "http://52.40.75.90/";

  public static final class EndPointApi {
    public static final String CANDIDATES = "/candidatos.json";
    public static final String CANDIDATE = "/candidatos/{idCandidato}.json";
    public static final String VOTE = "/api/0.1/votes/";
  }

  public static final class Path {
    public static final String ID_CONDIDATE = "idCandidato";
  }
}
