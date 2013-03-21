package com.kopfgeldjaeger.ratememaybe;

import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.kopfgeldjaeger.ratememaybe.RateMeMaybe.OnRMMUserChoiceListener;

public class SampleActivity extends SherlockFragmentActivity implements OnRMMUserChoiceListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);
		
		RateMeMaybe.resetData(this);
		RateMeMaybe rmm = new RateMeMaybe(this);
		rmm.setPromptMinimums(0, 0, 0, 0);
		rmm.setRunWithoutPlayStore(true);
		rmm.setDialogMessage("You really seem to like this app, "
				+"since you have already used it %totalLaunchCount% times! "
				+"It would be great if you took a moment to rate it.");
		rmm.setDialogTitle("Rate this app");
		rmm.setPositiveBtn("Yeeha!");
		rmm.run();
		
	}

	@Override
	public void handlePositive() {
		Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void handleNeutral() {
		Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void handleNegative() {
		Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show();

	}

}
