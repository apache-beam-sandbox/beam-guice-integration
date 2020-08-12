package com.deloitte.beam;

import java.util.Arrays;
import java.util.List;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.PCollection;

import com.deloitte.beam.function.DisplayDoFn;
import com.deloitte.beam.function.ProductFunction;
import com.deloitte.guice.bindings.ProductModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class BeamSimpleFunctionDemo {

	public static void main(String[] args) {
		Pipeline pipeline = Pipeline.create();
		List<String> products = Arrays.asList("Chair","Lumbar Support",
				"Table","Laptop");
		
		PCollection<String> productsPColl = pipeline
				.apply(Create.of(products));
		
		Injector injector = Guice.createInjector(new ProductModule());
		ProductFunction productFuntion = 
				(ProductFunction) injector.getInstance(SimpleFunction.class);
	
		DisplayDoFn displayFunction  = 
				(DisplayDoFn) injector.getInstance(DoFn.class);
		
		productsPColl.apply("uppercase",MapElements.via(productFuntion))
					 .apply("display", ParDo.of(displayFunction));
		
		pipeline.run().waitUntilFinish();
	}

}
