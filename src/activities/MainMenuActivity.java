package activities;

import com.alarmed.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainMenuActivity extends Activity implements OnClickListener{
	
	Button manageRemindersBtn;
	Button addReminderBtn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_layout);
		
		manageRemindersBtn = (Button) findViewById(R.id.manageRemindersBtn);
		addReminderBtn = (Button) findViewById(R.id.addReminderBtn);
		
		manageRemindersBtn.setOnClickListener(this);
		addReminderBtn.setOnClickListener(this);
		
	}
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		
		switch (arg0.getId()){

		case R.id.manageRemindersBtn:
			
			Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_LONG).show();
			
			break;
			
		case R.id.addReminderBtn:
		
			Intent openAddReminder = new Intent(MainMenuActivity.this, AddReminderActivity.class);
	    	  //finish();
				startActivity(openAddReminder);
				overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
			break;
			
			
		}
		
		
	}
	
	
	
	

}
