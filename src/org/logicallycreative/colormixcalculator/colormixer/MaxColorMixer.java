package org.logicallycreative.colormixcalculator.colormixer;

public class MaxColorMixer implements ColorMixable
{
	private String humanReadableName;

	public MaxColorMixer(String readableName)
	{
		humanReadableName = readableName;
	}

	public ColorData mixColors(ColorData firstColor, ColorData secondColor)
	{
		int red = Math.max(firstColor.red, secondColor.red);
		int green = Math.max(firstColor.green, secondColor.green);
		int blue = Math.max(firstColor.blue, secondColor.blue);
		
		ColorData mixedColor = new ColorData();
		mixedColor.red = red;
		mixedColor.green = green;
		mixedColor.blue = blue;
		
		return mixedColor;
	}

	@Override
	public String toString()
	{
		return humanReadableName;
	}
}
