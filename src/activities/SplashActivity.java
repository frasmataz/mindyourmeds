package activities;

import com.alarmed.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class SplashActivity extends Activity{
	
	private ImageView logoImg;
	protected int splashTime = 3000;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_layout);
		
		final Animation fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
				
		logoImg = (ImageView) findViewById(R.id.logoImgView);		
		logoImg.startAnimation(fade_in);
		
		// Set Runnable to remove splash screen just in case
	    final Handler splashHandler = new Handler();
	    splashHandler.postDelayed(new Runnable() {
	      @Override
	      public void run() {
	    	  
	    	  Intent openMainMenu = new Intent(SplashActivity.this, MainMenuActivity.class);
	    	  finish();
				startActivity(openMainMenu);

	      }
	    }, splashTime);
		
		
		
		
		
	}
	
	

}



		