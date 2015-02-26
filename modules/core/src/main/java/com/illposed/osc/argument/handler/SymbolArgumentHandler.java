/*
 * Copyright (C) 2015, C. Ramakrishnan / Illposed Software.
 * All rights reserved.
 *
 * This code is licensed under the BSD 3-Clause license.
 * See file LICENSE (or LICENSE.html) for more information.
 */

package com.illposed.osc.argument.handler;

import com.illposed.osc.argument.ArgumentHandler;
import com.illposed.osc.argument.OSCSymbol;
import com.illposed.osc.utility.OSCParseException;
import com.illposed.osc.utility.OSCSerializeException;
import com.illposed.osc.utility.SizeTrackingOutputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/**
 * Parses and serializes an OSC symbol type.
 */
public class SymbolArgumentHandler implements ArgumentHandler<OSCSymbol>, Cloneable {

	public static final char DEFAULT_IDENTIFIER = 'S';

	private final StringArgumentHandler stringArgumentHandler;

	public SymbolArgumentHandler() {
		this.stringArgumentHandler = new StringArgumentHandler();
	}

	public StringArgumentHandler getInternalStringArgumentHandler() {
		return stringArgumentHandler;
	}

	@Override
	public char getDefaultIdentifier() {
		return DEFAULT_IDENTIFIER;
	}

	@Override
	public Class<OSCSymbol> getJavaClass() {
		return OSCSymbol.class;
	}

	@Override
	public void setProperties(final Map<String, Object> properties) {
		stringArgumentHandler.setProperties(properties);
	}

	@Override
	public boolean isMarkerOnly() {
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public SymbolArgumentHandler clone() throws CloneNotSupportedException {
		return (SymbolArgumentHandler) super.clone();
	}

	@Override
	public OSCSymbol parse(final ByteBuffer input) throws OSCParseException {
		return OSCSymbol.valueOf(stringArgumentHandler.parse(input));
	}

	@Override
	public void serialize(final SizeTrackingOutputStream stream, final OSCSymbol value)
			throws OSCSerializeException
	{
		stringArgumentHandler.serialize(stream, value.toString());
	}
}