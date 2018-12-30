/*
 * Copyright (C) 2015-2017, C. Ramakrishnan / Illposed Software.
 * All rights reserved.
 *
 * This code is licensed under the BSD 3-Clause license.
 * See file LICENSE (or LICENSE.html) for more information.
 */

package com.illposed.osc;

/**
 * Holds (meta-)info about a message.
 * This might be used by some implementations of {@link MessageSelector}, for example.
 */
public class OSCMessageInfo {

	private final CharSequence argumentTypeTags;

	// Public API
	/**
	 * @param argumentTypeTags the <i>Arguments Type Tags</i> string, for example "iiscdi[fff]h"
	 */
	@SuppressWarnings({"WeakerAccess", "SpellCheckingInspection"})
	public OSCMessageInfo(final CharSequence argumentTypeTags) {
		this.argumentTypeTags = argumentTypeTags;
	}

	/**
	 * Returns the <i>Arguments Type Tags</i> string.
	 * @return for example "iiscdi[fff]h"
	 */
	@SuppressWarnings("SpellCheckingInspection")
	public CharSequence getArgumentTypeTags() {
		return argumentTypeTags;
	}
}
