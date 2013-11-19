package org.logicallycreative.colormixcalculator.colormixer;

public class AverageColorMixer implements ColorMixable
{
	private String humanReadableName;

	public AverageColorMixer(String readableName)
	{
		humanReadableName = readableName;
	}

	public ColorData mixColors(ColorData firstColor, ColorData secondColor)
	{
		int red = (firstColor.red + secondColor.red) / 2;
		int green = (firstColor.green + secondColor.green) / 2;
		int blue = (firstColor.blue + secondColor.blue) / 2;

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
