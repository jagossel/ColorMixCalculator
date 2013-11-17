package org.logicallycreative.colormixcalculator.colormixer;

public class XorColorMixer implements ColorMixable
{
	private String humanReadableName;
	
	public XorColorMixer(String humanReadableMixerName)
	{
		humanReadableName = humanReadableMixerName;
	}
	
	public ColorData mixColors(ColorData first, ColorData second)
	{
		int red = first.red ^ second.red;
		int green = first.green ^ second.green;
		int blue = first.blue ^ second.blue;
		
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
