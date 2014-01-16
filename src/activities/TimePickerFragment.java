package activities;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener
{	
	String parent;
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
		parent = getArguments().getString("parent");
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
     // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }
	
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) 
	{
        // Do something with the time chosen by the user
		if(parent.equals("AddReminderActivity"))
    	{		
			// USE BELOW CODE TO CALL PARENT ACTIVTY METHODS ECT....
			((AddReminderActivity) getActivity()).setTimeBtn(hourOfDay, minute);
    	}
		
    }

}
