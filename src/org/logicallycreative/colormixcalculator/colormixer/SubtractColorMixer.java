package org.logicallycreative.colormixcalculator.colormixer;

public class SubtractColorMixer implements ColorMixable
{
	private String resourceValue;

	public SubtractColorMixer(String nameResourceValue)
	{
		resourceValue = nameResourceValue;
	}

	public ColorData mixColors(ColorData first, ColorData second)
	{
		int maxRed = Math.max(first.red, second.red);
		int maxGreen = Math.max(first.green, second.green);
		int maxBlue = Math.max(first.blue, second.blue);
		
		int minRed = Math.min(first.red, second.red);
		int minGreen = Math.min(first.green, second.green);
		int minBlue = Math.min(first.blue, second.blue);
		
		int red = maxRed - minRed;
		int green = maxGreen - minGreen;
		int blue = maxBlue - minBlue;
		
		ColorData mixedColor = new ColorData();
		mixedColor.red = red;
		mixedColor.green = green;
		mixedColor.blue = blue;
		
		return mixedColor;
	}
	
	@Override
	public String toString()
	{
		return resourceValue;
	}
}
