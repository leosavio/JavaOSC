/*
 * Copyright (C) 2019, C. Ramakrishnan / Illposed Software.
 * All rights reserved.
 *
 * This code is licensed under the BSD 3-Clause license.
 * See file LICENSE (or LICENSE.html) for more information.
 */

package com.illposed.osc.transport;

import com.illposed.osc.OSCSerializerAndParserBuilder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class OSCPortOutBuilder {
	private OSCSerializerAndParserBuilder serializerBuilder;
	private SocketAddress remote;
	private SocketAddress local;
	private NetworkProtocol networkProtocol = NetworkProtocol.UDP;

	public OSCPortOut build() throws IOException {
		if (local == null) {
			throw new IllegalArgumentException(
				"Missing local socket address / port.");
		}

		if (remote == null) {
			throw new IllegalArgumentException(
				"Missing remote socket address / port.");
		}

		if (serializerBuilder == null) {
			serializerBuilder = new OSCSerializerAndParserBuilder();
		}

		return new OSCPortOut(
			serializerBuilder, remote, local, networkProtocol
		);
	}

	public OSCPortOutBuilder setPort(final int port) {
		final SocketAddress address = new InetSocketAddress(port);
		local = address;
		remote = address;
		return this;
	}

	public OSCPortOutBuilder setRemotePort(final int port) {
		remote = new InetSocketAddress(port);
		return this;
	}

	public OSCPortOutBuilder setLocalPort(final int port) {
		local = new InetSocketAddress(port);
		return this;
	}

	public OSCPortOutBuilder setSocketAddress(final SocketAddress address) {
		local = address;
		remote = address;
		return this;
	}

	public OSCPortOutBuilder setLocalSocketAddress(final SocketAddress address) {
		local = address;
		return this;
	}

	public OSCPortOutBuilder setRemoteSocketAddress(final SocketAddress address) {
		remote = address;
		return this;
	}

	public OSCPortOutBuilder setNetworkProtocol(final NetworkProtocol protocol) {
		networkProtocol = protocol;
		return this;
	}
}
