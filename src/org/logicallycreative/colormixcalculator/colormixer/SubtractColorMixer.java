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
		int red = first.red - second.red;
		int green = first.green - second.green;
		int blue = first.blue - second.blue;
		
		ColorData mixedColor = new ColorData();
		mixedColor.red = Math.max(0, red);
		mixedColor.green = Math.max(0, green);
		mixedColor.blue = Math.max(0, blue);
		
		return mixedColor;
	}
	
	@Override
	public String toString()
	{
		return resourceValue;
	}
}