package com.jason.blog.domain.task.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class AsyncTaskAssigner implements InitializingBean {
	private ExecutorService executorService = null;
	private int poolSize = 50;

	/**
	 * 
	 * @param poolSize
	 */
	public void setPoolSize(int poolSize) {
		
		if (poolSize <= 0) {
			throw new IllegalArgumentException("poolSize must gt 0!");
		}

		this.poolSize = poolSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public final void afterPropertiesSet() throws Exception {
		initializeThreadPool();
	}

	protected void initializeThreadPool() {
		executorService = Executors.newFixedThreadPool(this.poolSize);
	}

	/**
	 * 
	 * @param asyncTask
	 */
	public void assign(final AsyncTask asyncTask) {

		Thread asyncTaskThread = new Thread() {

			@Override
			public void run() {
				asyncTask.execute();
			}
		};

		asyncTaskThread.setUncaughtExceptionHandler(ASYNC_TASK_EXCEPTION_HANDLER);
		executorService.submit(asyncTaskThread);
	}

	private static final Logger LOG = LoggerFactory.getLogger(AsyncTaskAssigner.class);
	private static final Thread.UncaughtExceptionHandler ASYNC_TASK_EXCEPTION_HANDLER = new Thread.UncaughtExceptionHandler() {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			LOG.error(String.format("error occur on asyncTask with thread-id:%s", t.getId()), e);
		}
	};
}
