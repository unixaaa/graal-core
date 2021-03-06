/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.graal.hotspot.nodes;

import com.oracle.graal.graph.NodeClass;
import com.oracle.graal.nodeinfo.InputType;
import com.oracle.graal.nodeinfo.NodeInfo;
import com.oracle.graal.nodes.ValueNode;
import com.oracle.graal.nodes.memory.address.AddressNode;

@NodeInfo
public abstract class ObjectWriteBarrier extends WriteBarrier {

    public static final NodeClass<ObjectWriteBarrier> TYPE = NodeClass.create(ObjectWriteBarrier.class);
    @Input(InputType.Association) protected AddressNode address;
    @OptionalInput protected ValueNode value;
    protected final boolean precise;

    protected ObjectWriteBarrier(NodeClass<? extends ObjectWriteBarrier> c, AddressNode address, ValueNode value, boolean precise) {
        super(c);
        this.address = address;
        this.value = value;
        this.precise = precise;
    }

    public ValueNode getValue() {
        return value;
    }

    public AddressNode getAddress() {
        return address;
    }

    public boolean usePrecise() {
        return precise;
    }
}
