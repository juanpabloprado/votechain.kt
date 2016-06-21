package com.android.votechain.candidates.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import com.android.votechain.R;
import java.util.HashMap;
import java.util.Locale;

/**
 * 21/06/2016.
 */
public class CandidateProposalDialog extends DialogFragment implements TextToSpeech.OnInitListener {

  private static final String ARG_TEXT = "text";
  private static final String LOG_TAG = CandidateProposalDialog.class.getSimpleName();
  private TextToSpeech mTextToSpeech;

  public static CandidateProposalDialog newInstance(String text) {
    Bundle args = new Bundle();
    args.putString(ARG_TEXT, text);
    CandidateProposalDialog fragment = new CandidateProposalDialog();
    fragment.setArguments(args);
    return fragment;
  }

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {

    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setView(R.layout.dialog_loading_sound);
    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {

      }
    });
    mTextToSpeech = new TextToSpeech(getContext(), this);

    return builder.create();
  }

  private String getTextFromArguments() {
    return getArguments().getString(ARG_TEXT);
  }

  @Override public void onInit(int status) {
    if (status != TextToSpeech.ERROR) {
      Locale locSpanish = new Locale("spa", "MEX");
      mTextToSpeech.setLanguage(locSpanish);
      mTextToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
        @Override public void onStart(String utteranceId) {

        }

        @Override public void onDone(String utteranceId) {
        }

        @Override public void onError(String utteranceId) {

        }
      });

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        String utteranceId = this.hashCode() + "";
        mTextToSpeech.speak(getTextFromArguments(), TextToSpeech.QUEUE_FLUSH, null, utteranceId);
      } else {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        mTextToSpeech.speak(getTextFromArguments(), TextToSpeech.QUEUE_FLUSH, map);
      }
    }
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    if (mTextToSpeech != null) {
      mTextToSpeech.stop();
      mTextToSpeech.shutdown();
    }
  }
}
