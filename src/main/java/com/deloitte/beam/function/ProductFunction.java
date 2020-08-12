package com.deloitte.beam.function;

import org.apache.beam.sdk.transforms.SimpleFunction;

public class ProductFunction extends SimpleFunction<String, String> {

	@Override
	public String apply(String input) {
		return input.toUpperCase();
	}
}
