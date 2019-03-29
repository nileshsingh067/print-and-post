package com.print.and.post.core.spi.eventbus;

/**
 * 	
 * This class declares the Eventbus.
 *
 * @param <T>            The type of underlying Eventbus
 * @since 0.0.1
 */
public interface MosipEventbusFactory<T> {

	/**
	 * This method returns the Eventbus instance.
	 *
	 * @return Eventbus instance
	 */
	public T getEventbus();

}
