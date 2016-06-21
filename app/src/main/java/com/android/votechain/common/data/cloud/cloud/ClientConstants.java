package com.android.votechain.common.data.cloud.cloud;

/**
 * 04/05/16.
 */
public class ClientConstants {
  public static final String BASE_URL_CANDIDATES = "https://votechain.firebaseio.com/";

  public static final class EndPointApi {
    public static final String CANDIDATES = "/candidatos.json";
    public static final String CANDIDATE = "/candidatos/{idCandidato}.json";
  }

  public static final class Path {
    public static final String ID_CONDIDATE = "idCandidato";
  }
}
