package com.deloitte.beam.function;

import org.apache.beam.sdk.transforms.DoFn;

public class DisplayDoFn extends DoFn<String, String> {

	@ProcessElement
	public void processElement(@Element String product) {
		System.out.println(product);
	}
}
