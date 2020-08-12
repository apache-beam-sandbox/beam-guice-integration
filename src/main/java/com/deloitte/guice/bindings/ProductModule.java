package com.deloitte.guice.bindings;

import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.SimpleFunction;

import com.deloitte.beam.function.DisplayDoFn;
import com.deloitte.beam.function.ProductFunction;
import com.google.inject.AbstractModule;

public class ProductModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(SimpleFunction.class).to(ProductFunction.class);
		bind(DoFn.class).to(DisplayDoFn.class);

	}

}
