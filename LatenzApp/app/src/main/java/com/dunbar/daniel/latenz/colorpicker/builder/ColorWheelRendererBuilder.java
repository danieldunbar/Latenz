package com.dunbar.daniel.latenz.colorpicker.builder;


import com.dunbar.daniel.latenz.colorpicker.ColorPickerView;
import com.dunbar.daniel.latenz.colorpicker.renderer.ColorWheelRenderer;
import com.dunbar.daniel.latenz.colorpicker.renderer.FlowerColorWheelRenderer;
import com.dunbar.daniel.latenz.colorpicker.renderer.SimpleColorWheelRenderer;

public class ColorWheelRendererBuilder {
	public static ColorWheelRenderer getRenderer(ColorPickerView.WHEEL_TYPE wheelType) {
		switch (wheelType) {
			case CIRCLE:
				return new SimpleColorWheelRenderer();
			case FLOWER:
				return new FlowerColorWheelRenderer();
		}
		throw new IllegalArgumentException("wrong WHEEL_TYPE");
	}
}