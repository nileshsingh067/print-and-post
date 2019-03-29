package com.print.and.post.core.abstractverticle;

import java.io.Serializable;
	
/**
 * This class contains the address values to be used in Registration process.
 *
 * @since 0.0.1
 */
public class MessageBusAddress implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new message bus address.
	 */
	public MessageBusAddress() {
	}

	/** The address. */
	private String address;

	/**
	 * Instantiates a new message bus address.
	 *
	 * @param address
	 *            The bus address
	 */
	public MessageBusAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the address.
	 *
	 * @return The address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** The Constant BATCH_BUS. */
	public static final MessageBusAddress BATCH_BUS = new MessageBusAddress("batch-bus");

	/** The Constant STRUCTURE_BUS_IN. */
	public static final MessageBusAddress PACKET_VALIDATOR_BUS_IN = new MessageBusAddress("packet-validator-bus-in");

	/** The Constant STRUCTURE_BUS_OUT. */
	public static final MessageBusAddress PACKET_VALIDATOR_BUS_OUT = new MessageBusAddress("packet-validator-bus-out");

	/** The Constant BIOMETRIC_BUS_IN. */
	public static final MessageBusAddress BIO_DEDUPE_BUS_IN = new MessageBusAddress("bio-dedupe-bus-in");

	/** The Constant BIOMETRIC_BUS_OUT. */
	public static final MessageBusAddress BIO_DEDUPE_BUS_OUT = new MessageBusAddress("bio-dedupe-bus-out");

	/** The Constant FAILURE_BUS. */
	public static final MessageBusAddress FAILURE_BUS = new MessageBusAddress("failure-bus");

	/** The Constant RETRY_BUS. */
	public static final MessageBusAddress RETRY_BUS = new MessageBusAddress("retry");

	/** The Constant ERROR. */
	public static final MessageBusAddress ERROR = new MessageBusAddress("error");
	
	
	
	public static final MessageBusAddress PRINT_AND_POST_UIN_RECV_IN=new MessageBusAddress("print-and-post-uin-recv-in");
	
	public static final MessageBusAddress PRINT_AND_POST_UIN_RECV_OUT=new MessageBusAddress("print-and-post-uin-recv-out");
	
	
	public static final MessageBusAddress PRINT_AND_POST_STATUS_RECV_IN=new MessageBusAddress("print-and-post-status-recv-in");
	
	public static final MessageBusAddress PRINT_AND_POST_STATUS_RECV_OUT=new MessageBusAddress("print-and-post-status-recv-out");
	
	
	public static final MessageBusAddress PRINT_AND_POST_STATUS_UPDATER_IN=new MessageBusAddress("print-and-post-status-updater-in");
	
	public static final MessageBusAddress PRINT_AND_POST_STATUS_UPDATER_OUT=new MessageBusAddress("print-and-post-status-updater-out");

}
