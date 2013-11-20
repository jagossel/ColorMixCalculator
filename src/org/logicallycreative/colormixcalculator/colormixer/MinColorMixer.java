package org.logicallycreative.colormixcalculator.colormixer;

public class MinColorMixer implements ColorMixable
{
	private String humanReadableName;

	public MinColorMixer(String readableName)
	{
		humanReadableName = readableName;
	}

	public ColorData mixColors(ColorData firstColor, ColorData secondColor)
	{
		int red = Math.min(firstColor.red, secondColor.red);
		int green = Math.min(firstColor.green, secondColor.green);
		int blue = Math.min(firstColor.blue, secondColor.blue);
		
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
