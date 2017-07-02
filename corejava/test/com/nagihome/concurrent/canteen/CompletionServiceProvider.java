/**
 * 
 */
package com.nagihome.concurrent.canteen;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author nageswararao
 *
 */
@SuppressWarnings("rawtypes")
public class CompletionServiceProvider {

	private static ExecutorService execService = Executors.newCachedThreadPool();
	private static CompletionService completionService = new ExecutorCompletionService<>(execService);

	private CompletionServiceProvider() {	}

	public static CompletionService getInstance() {
		return completionService;
	}
}
