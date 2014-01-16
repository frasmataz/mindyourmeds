package activities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.alarmed.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



public class AddReminderActivity extends FragmentActivity implements OnClickListener{
	
	
	ImageButton addImageBtn;
	TextView addImageTxtView;
	Uri selectedImageURI;
	Uri imageUri;
	Bitmap image;
	

	Button monBtn;
	Button tueBtn;
	Button wedBtn;
	Button thurBtn;
	Button friBtn;
	Button satBtn;
	Button sunBtn;
	Button setTimeBtn;
	
	Button cancelBtn;
	Button setAlarmBtn;
	
	boolean monSelected = false;
	boolean tueSelected = false;
	boolean wedSelected = false;
	boolean thurSelected = false;
	boolean friSelected = false;
	boolean satSelected = false;
	boolean sunSelected = false;
	
	String parent;
	Bundle parentBundle;
	DialogFragment newFragment;
	int selectedHour, selectedMin;
	
	
	Uri selectedImageUri;
	String  selectedPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_reminder_layout);
		
		// layout buttons
		addImageBtn = (ImageButton) findViewById(R.id.addImageBtn);
		
		addImageBtn.setOnClickListener(this);
		
		addImageTxtView = (TextView) findViewById(R.id.addImageTxtView);
		
		parent = "AddReminderActivity";
		parentBundle = new Bundle();
		parentBundle.putString("parent", parent);
 		
		monBtn = (Button) findViewById(R.id.monBtn);
		tueBtn = (Button) findViewById(R.id.tueBtn);
		wedBtn = (Button) findViewById(R.id.wedBtn);
		thurBtn = (Button) findViewById(R.id.thurBtn);
		friBtn = (Button) findViewById(R.id.friBtn);
		satBtn = (Button) findViewById(R.id.satBtn);
		sunBtn = (Button) findViewById(R.id.sunBtn);
		
		cancelBtn = (Button) findViewById(R.id.cancelBtn);
		setAlarmBtn = (Button) findViewById(R.id.setAlarmBtn);
		cancelBtn.setOnClickListener(this);
		setAlarmBtn.setOnClickListener(this);
		
		setTimeBtn = (Button) findViewById(R.id.setTimeBtn);
		setTimeBtn.setOnClickListener(this);
		
		monBtn.setOnClickListener(this);
		tueBtn.setOnClickListener(this);
		wedBtn .setOnClickListener(this);
		thurBtn.setOnClickListener(this);
		friBtn.setOnClickListener(this);
		satBtn.setOnClickListener(this);
		sunBtn.setOnClickListener(this);
		
	}
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		
		switch (arg0.getId()){

		case R.id.addImageBtn:
			  

         		final Dialog dialog = new Dialog(this);
         		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         		dialog.setContentView(R.layout.custom_dialog_add_img);
         		
         		Button galleryDialogBtn = (Button) dialog.findViewById(R.id.galleryDialogBtn);

         		galleryDialogBtn.setOnClickListener(new OnClickListener() {
    				@Override
    				public void onClick(View v) {
    					
    					Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
    		            photoPickerIntent.setType("image/*");
    		            startActivityForResult(photoPickerIntent, 10);
    					
    					dialog.dismiss();
    				}
    			});
    			
    			Button cameraDialogBtn = (Button) dialog.findViewById(R.id.cameraDialogBtn);
    			// if button is clicked, close the custom dialog
    			cameraDialogBtn.setOnClickListener(new OnClickListener() {
    				@Override
    				public void onClick(View v) {
    					
    					Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
    	                startActivityForResult(cameraIntent, 100);
    					
    					dialog.dismiss();
    				}
    			});
         		
         		dialog.show();
         		
         		
			
			break;
			
		case R.id.setTimeBtn:
			
			newFragment = new TimePickerFragment();
			newFragment.setArguments(parentBundle);
		    newFragment.show(getSupportFragmentManager(), "timePicker");
			
			
			break;
			
			
		case R.id.monBtn:
			
			if(monSelected == false)
			{
				monBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue_selected));
				monBtn.setTextColor(Color.parseColor("#ffffff"));
				monSelected = true;
			}
			else if(monSelected == true)
			{
				monBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue));
				monBtn.setTextColor(Color.parseColor("#2C8EE8"));
				monSelected = false;
			}		
			
			break;
			
		case R.id.tueBtn:
			
			if(tueSelected == false)
			{
				tueBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue_selected));
				tueBtn.setTextColor(Color.parseColor("#ffffff"));
				tueSelected = true;
			}
			else if(tueSelected == true)
			{
				tueBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue));
				tueBtn.setTextColor(Color.parseColor("#2C8EE8"));
				tueSelected = false;
			}
			
			break;
			
		case R.id.wedBtn:
			
			if(wedSelected == false)
			{
				wedBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue_selected));
				wedBtn.setTextColor(Color.parseColor("#ffffff"));
				wedSelected = true;
			}
			else if(wedSelected == true)
			{
				wedBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue));
				wedBtn.setTextColor(Color.parseColor("#2C8EE8"));
				wedSelected = false;
			}
	
			break;
	
		case R.id.thurBtn:
			
			if(thurSelected == false)
			{
				thurBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue_selected));
				thurBtn.setTextColor(Color.parseColor("#ffffff"));
				thurSelected = true;
			}
			else if(thurSelected == true)
			{
				thurBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue));
				thurBtn.setTextColor(Color.parseColor("#2C8EE8"));
				thurSelected = false;
			}
	
			break;
	
		case R.id.friBtn:
			
			if(friSelected == false)
			{
				friBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue_selected));
				friBtn.setTextColor(Color.parseColor("#ffffff"));
				friSelected = true;
			}
			else if(friSelected == true)
			{
				friBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue));
				friBtn.setTextColor(Color.parseColor("#2C8EE8"));
				friSelected = false;
			}
	
			break;
	
		case R.id.satBtn:
			
			if(satSelected == false)
			{
				satBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue_selected));
				satBtn.setTextColor(Color.parseColor("#ffffff"));
				satSelected = true;
			}
			else if(satSelected == true)
			{
				satBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue));
				satBtn.setTextColor(Color.parseColor("#2C8EE8"));
				satSelected = false;
			}
	
			break;
	
		case R.id.sunBtn:
			
			if(sunSelected == false)
			{
				sunBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue_selected));
				sunBtn.setTextColor(Color.parseColor("#ffffff"));
				sunSelected = true;
			}
			else if(sunSelected == true)
			{
				sunBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue));
				sunBtn.setTextColor(Color.parseColor("#2C8EE8"));
				sunSelected = false;
			}
	
			break;
			
		case R.id.cancelBtn:
			
			Toast.makeText(getApplicationContext(), "" + System.currentTimeMillis(), Toast.LENGTH_LONG).show();
			//System.currentTimeMillis();
			
			break;
			
		case R.id.setAlarmBtn:
	
			//Pull image from internal memory
			//String path = "data/data/com.alarmed/files/img_1.bmp";
			//Bitmap savedImage = BitmapFactory.decodeFile(path);	
			//addImageBtn.setImageBitmap(savedImage);
			
			//Save image with unique name
			//String imgName = String.valueOf(System.currentTimeMillis());
			//saveImageToInternalStorage(getResizedBitmap(image, getReqScreenSize(), getReqScreenSize()), imgName + ".bmp");
			
			break;
			
			
			
		
			
		}
		
		
	}
	
	
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		 
		 
		 
        if (resultCode == RESULT_OK) {
         if(data.getData() != null){
           selectedImageUri = data.getData();
         }else{
          Log.d("selectedPath1 : ","Came here its null !");
          Toast.makeText(getApplicationContext(), "failed to get Image!", 500).show();
         }
          
         if (requestCode == 10 && resultCode == RESULT_OK) {  
        	 
        	 try {
        		 
				image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
				addImageBtn.setImageBitmap(getResizedBitmap(image, getReqScreenSize(), getReqScreenSize()));
				addImageTxtView.setVisibility(View.INVISIBLE);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 
 
            } 
          
            if (requestCode == 100 && resultCode == RESULT_OK)
 
            {
 
            	try {
           		 
    				image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
    				addImageBtn.setImageBitmap(getResizedBitmap(image, getReqScreenSize(), getReqScreenSize()));
    				addImageTxtView.setVisibility(View.INVISIBLE);
    				
    			} catch (FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
               
               //Toast.makeText(getApplicationContext(), "Camera", Toast.LENGTH_LONG).show();
 
            }
 
        }
 
    }
        
	
        
	public int getReqScreenSize()
	{
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		int densityDpi = (int)(metrics.density * 160f);
		
		int res = 0;
		
		switch (densityDpi){

		case 640:		
			res = 192 * 2;		
			break;
		
		case 480:		
			res = 144 * 2;		
			break;
			
		case 320:			
			res = 96 * 2;			
			break;
			
		case 240:			
			res = 72 * 2;			
			break;
			
		case 160:			
			res = 48 * 2;			
			break;
			
		case 120:		
			res = 36 * 2;		
			break;
			
		}
			
		return res;
		
	}
	
	
	
	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
	    int width = bm.getWidth();
	    int height = bm.getHeight();
	    float scaleWidth = ((float) newWidth) / width;
	    float scaleHeight = ((float) newHeight) / height;
	    // CREATE A MATRIX FOR THE MANIPULATION
	    Matrix matrix = new Matrix();
	    // RESIZE THE BIT MAP
	    matrix.postScale(scaleWidth, scaleHeight);

	    // "RECREATE" THE NEW BITMAP
	    Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
	    return resizedBitmap;
	}
	
	
	public void saveImageToInternalStorage(Bitmap image, String fileName) {
		
		
		try {
				
			FileOutputStream fos = this.openFileOutput(fileName, Context.MODE_PRIVATE);
			image.compress(Bitmap.CompressFormat.PNG, 100, fos);

			 fos.close();

		} catch (Exception e) {


		}
		
		
	
	}
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		
		DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		        switch (which){
		        case DialogInterface.BUTTON_POSITIVE:
		            //Yes button clicked
		        	
		        	finish();
		    	    overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );

		            break;

		        case DialogInterface.BUTTON_NEGATIVE:
		            //No button clicked
		        	//Do nothing...
		            break;
		        }	    
		    }
		};
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
		    .setNegativeButton("No", dialogClickListener).show();
		
	    
	}
	
	

	
	public void setTimeBtn(int hourOfDay, int minute)
	{	
		selectedHour = hourOfDay;
		selectedMin = minute;	
		
		String zeroHour = "";
		String zeroMin = "";
		
		if(selectedHour < 10)
		{
			zeroHour = "0";
		}
		if(selectedMin < 10)
		{
			zeroMin = "0";
		}
		
		String time = zeroHour + Integer.toString(hourOfDay) + ":" + zeroMin + Integer.toString(minute);
	
		setTimeBtn.setBackground(getResources().getDrawable(R.drawable.custom_btn_blue_selected));
		setTimeBtn.setTextColor(Color.parseColor("#ffffff"));
		setTimeBtn.setText(time);
	}
	
	
	
	
	
	
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {

	    View v = getCurrentFocus();
	    boolean ret = super.dispatchTouchEvent(event);

	    if (v instanceof EditText) {
	        View w = getCurrentFocus();
	        int scrcoords[] = new int[2];
	        w.getLocationOnScreen(scrcoords);
	        float x = event.getRawX() + w.getLeft() - scrcoords[0];
	        float y = event.getRawY() + w.getTop() - scrcoords[1];

	        Log.d("Activity", "Touch event "+event.getRawX()+","+event.getRawY()+" "+x+","+y+" rect "+w.getLeft()+","+w.getTop()+","+w.getRight()+","+w.getBottom()+" coords "+scrcoords[0]+","+scrcoords[1]);
	        if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom()) ) { 

	            InputMethodManager imm = (InputMethodManager)getSystemService(AddReminderActivity.INPUT_METHOD_SERVICE);
	            imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
	            
	            
	        }
	    }    	    
	return ret;
	}
	
	

	

	
	
}
