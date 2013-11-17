package org.logicallycreative.colormixcalculator.colormixer;

public class AddColorMixer implements ColorMixable
{
	private String resourceValue;

	public AddColorMixer(String nameResourceValue)
	{
		resourceValue = nameResourceValue;
	}

	public ColorData mixColors(ColorData first, ColorData second)
	{
		int red = first.red + second.red;
		int green = first.green + second.green;
		int blue = first.blue + second.blue;

		ColorData mixedColor = new ColorData();
		mixedColor.red = Math.min(255, red);
		mixedColor.green = Math.min(255, green);
		mixedColor.blue = Math.min(255, blue);

		return mixedColor;
	}

	@Override
	public String toString()
	{
		return resourceValue;
	}
}
