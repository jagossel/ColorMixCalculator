package org.logicallycreative.colormixcalculator.colormixer;

public class OrColorMixer implements ColorMixable
{
	private String resourceValue;
	
	public OrColorMixer(String nameResourceValue)
	{
		resourceValue = nameResourceValue;
	}
	
	public ColorData mixColors(ColorData first, ColorData second)
	{
		int red = first.red | second.red;
		int green = first.green | second.green;
		int blue = first.blue | second.blue;
		
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
