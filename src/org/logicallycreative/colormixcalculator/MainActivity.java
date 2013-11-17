package org.logicallycreative.colormixcalculator;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.SeekBar.*;
import android.graphics.*;

import org.logicallycreative.colormixcalculator.colormixer.*;

public class MainActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setSeekBarListeners(R.id.red1Input, R.id.red1Output);
		setSeekBarListeners(R.id.green1Input, R.id.green1Output);
		setSeekBarListeners(R.id.blue1Input, R.id.blue1Output);
		setSeekBarListeners(R.id.red2Input, R.id.red2Output);
		setSeekBarListeners(R.id.green2Input, R.id.green2Output);
		setSeekBarListeners(R.id.blue2Input, R.id.blue2Output);
		
		addColorMixOptions();
	}

	public void mixColors(View sender)
	{
		Spinner mixTypeSpinner = (Spinner)findViewById(R.id.colorMixType);
		ImageView firstColorResult = (ImageView)findViewById(R.id.color1Result);
		ImageView mixedColorResult = (ImageView)findViewById(R.id.colorMixResult);
		ImageView secondColorResult = (ImageView)findViewById(R.id.color2Result);
		
		ColorData firstColor = createColorData(R.id.red1Input, R.id.green1Input, R.id.blue1Input);
		ColorData secondColor = createColorData(R.id.red2Input, R.id.green2Input, R.id.blue2Input);
		ColorMixable mixer = (ColorMixable)mixTypeSpinner.getSelectedItem();
		
		ColorData mixedColor = mixer.mixColors(firstColor, secondColor);
		
		firstColorResult.setBackgroundColor(Color.argb(255, firstColor.red, firstColor.green, firstColor.blue));
		mixedColorResult.setBackgroundColor(Color.argb(255, mixedColor.red, mixedColor.green, mixedColor.blue));
		secondColorResult.setBackgroundColor(Color.argb(255, secondColor.red, secondColor.green, secondColor.blue));
	}
	
	private void setSeekBarListeners(int seekBarId, int textViewId)
	{
		final TextView textViewOutput = (TextView)findViewById(textViewId);
		final SeekBar seekBarInput = (SeekBar)findViewById(seekBarId);

		seekBarInput.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
			{
				@Override
				public void onStopTrackingTouch(SeekBar sender)
				{
				}

				@Override
				public void onStartTrackingTouch(SeekBar sender)
				{
				}

				@Override
				public void onProgressChanged(SeekBar sender, int progress, boolean fromUser)
				{
					updatePreviewColors();
					textViewOutput.setText(String.valueOf(progress));
				}
			});
	}
	
	private void updatePreviewColors()
	{
		final ImageView color1Preview = (ImageView)findViewById(R.id.color1Preview);
		final ImageView color2Preview = (ImageView)findViewById(R.id.color2Preview);

		int red1Value = getSeekBarValue(R.id.red1Input);
		int green1Value = getSeekBarValue(R.id.green1Input);
		int blue1Value = getSeekBarValue(R.id.blue1Input);

		int red2Value = getSeekBarValue(R.id.red2Input);
		int green2Value = getSeekBarValue(R.id.green2Input);
		int blue2Value = getSeekBarValue(R.id.blue2Input);

		color1Preview.setBackgroundColor(Color.argb(255, red1Value, green1Value, blue1Value));
		color2Preview.setBackgroundColor(Color.argb(255, red2Value, green2Value, blue2Value));
	}
	
	private ColorData createColorData(int redResourceId, int greenResourceId, int blueResourceId)
	{
		ColorData newColorData = new ColorData();
		newColorData.red = getSeekBarValue(redResourceId);
		newColorData.green = getSeekBarValue(greenResourceId);
		newColorData.blue = getSeekBarValue(blueResourceId);
		
		return newColorData;
	}
	
	private int getSeekBarValue(int seekBarResourceId)
	{
		SeekBar seekBarView = (SeekBar)findViewById(seekBarResourceId);
		if (seekBarView == null)
			return 0;
			
		return seekBarView.getProgress();
	}
	
	private void addColorMixOptions()
	{
		Spinner colorMixOptions = (Spinner)findViewById(R.id.colorMixType);

		//TODO: Is there a better way of getting a resource string without passing the string or the Context itself?
		ArrayAdapter<ColorMixable> optionsArrayAdapter = new ArrayAdapter<ColorMixable>(this, android.R.layout.simple_spinner_item);
		optionsArrayAdapter.add(new AddColorMixer(getResources().getString(R.string.addColors)));
		optionsArrayAdapter.add(new SubtractColorMixer(getResources().getString(R.string.subtractColors)));
		optionsArrayAdapter.add(new AndColorMixer(getResources().getString(R.string.andColors)));
		optionsArrayAdapter.add(new OrColorMixer(getResources().getString(R.string.orColors)));
		optionsArrayAdapter.add(new XorColorMixer(getResources().getString(R.string.xorColors)));
		
		colorMixOptions.setAdapter(optionsArrayAdapter);
	}
}